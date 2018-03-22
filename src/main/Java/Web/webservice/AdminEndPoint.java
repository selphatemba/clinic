package Web.webservice;

import Bean.BeanInterface.AdminBeanI;
import Entities.*;
import com.google.gson.Gson;

import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

/**
 * Created by SELPHA on 19/3/2018.
 */
@Path("/admin")
public class AdminEndPoint {
    @EJB
    private AdminBeanI adminBeanI;
    @Inject
    Event<Booking> bookingEvent;


    @Path("/payment")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response payForServices(@FormParam("PatientID")String patientID,
                                   @FormParam("service")Service service,
                                   @FormParam("Amount")Double amount){
        Payment pay=new Payment();
        pay.setpID(patientID);
        pay.setS(service);
        pay.setAmount(amount);
        adminBeanI.payForServices(pay);
        return Response.status(200).entity("Patient  "+pay.getpID()+"  has successfully paid for   "+pay.getS()).build();

    }
    @Path("/booking")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response bookPatient(@FormParam("doctorid")String dID,
                                @FormParam("patientid")String pID){
        Booking booking=new Booking();
        booking.setdID(dID);
        booking.setpID(pID);
        adminBeanI.bookPatientToDoctor(booking);
        bookingEvent.fire(booking);
        return Response.status(200).entity("Doctor  "+booking.getdID()+"  successfully booked to patient  "+booking.getpID()).build();
    }


    @Path("/pharmacy")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response dispenseDrug(@FormParam("PatientID")String patientID,@FormParam("medicine")String medicine){
        Dispensation dispensation=new Dispensation();
        dispensation.setPatientID(patientID);
        dispensation.setMedicine(medicine);
        if(adminBeanI.dispenseDrug(dispensation)) {
            return Response.status(200).entity("successfully dispensed").build();
        }
        return Response.status(201).entity("Failed!!").build();
    }


    @Path("/consultation")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response consultDoctor(String jsonObject){
        Gson gson=new Gson();
        if(adminBeanI.consultDoctor(gson.fromJson(jsonObject,Consultation.class))){
        return Response.status(200).entity("Added successfully").build();
        }
        return Response.status(201).entity("Failed!!").build();
    }


    @Path("/labtest")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public  Response runLabTest(String jsonObject){
        Gson gson=new Gson();
        if(adminBeanI.runLabTest(gson.fromJson(jsonObject,TestResult.class))){
            return Response.status(200).entity("successfully added").build();
        }
        return Response.status(201).entity("Failed!!").build();
    }
}
