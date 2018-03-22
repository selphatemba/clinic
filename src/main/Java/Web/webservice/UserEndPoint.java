package Web.webservice;

import Bean.BeanImplementation.UserBean;
import Bean.BeanInterface.UserBeanI;
import Entities.Gender;
import Entities.Title;
import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//Created by SELPHA on 15/3/2018.


@Path("/user")
public class UserEndPoint {
    @EJB
    private UserBeanI userBeanI;
    @Inject
    Event<UserBean> userBeanEvent;
    Entities.User user = new Entities.User();

    @Path("/registration")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response registerUser(@FormParam("fname") String fname,
                                 @FormParam("lname") String lname,
                                 @FormParam("town") String town,
                                 @FormParam("gender") Gender gender,
                                 @FormParam("title") Title title,
                                 @FormParam("jobid") String jobId,
                                 @FormParam("idnumber") int idNumber,
                                 @FormParam("email") String email,
                                 @FormParam("password") String password
    ) {
        Entities.User user = new Entities.User();
        user.setFname(fname);
        user.setLname(lname);
        user.setTown(town);
        user.setGender(gender);
        user.setTitle(title);
        user.setJobId(jobId);
        user.setIdNumber(idNumber);
        user.setEmail(email);
        user.setPassword(password);
        if (userBeanI.register(user)) {
            return Response.status(200).entity(user.getTitle() + "  " + user.getFname() + "  " + user.getLname() + "   you are successfully registered").build();

        }
        return Response.status(201).entity("Failed!!").build();
    }

    @Path("/edit")
    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response editUser(@FormParam("fname") String fname,
                             @FormParam("lname") String lname,
                             @FormParam("town") String town,
                             @FormParam("gender") Gender gender,
                             @FormParam("title") Title title,
                             @FormParam("jobid") String jobId,
                             @FormParam("idnumber") int idNumber,
                             @FormParam("email") String email,
                             @FormParam("password") String password) {

        user.setFname(fname);
        user.setLname(lname);
        user.setTown(town);
        user.setGender(gender);
        user.setTitle(title);
        user.setJobId(jobId);
        user.setIdNumber(idNumber);
        user.setEmail(email);
        user.setPassword(password);
        if (userBeanI.edit(user)) {
            return Response.status(200).entity(user.getTitle() + "  " + user.getFname() + "  " + user.getLname() + "   you are successfully updated").build();
        }
        return Response.status(201).entity("Failed!!").build();
    }

    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(@FormParam("userid") String jobId,
                          @FormParam("password") String password) throws MySQLSyntaxErrorException {
        user.setJobId(jobId);
        user.setPassword(password);
        userBeanI.login(user);
        if (user.getJobId().matches("D........D")) {
            userBeanEvent.fire(new UserBean());
        } else {

        }
        return Response.status(200).entity(user.getJobId() + "  you are successfully logged in").build();
    }

    @Path("/logout")
    @GET
    @Consumes
    @Produces(MediaType.TEXT_PLAIN)
    public Response logOut(@FormParam("userid") String jobId) {
        user.setJobId(jobId);
        if (userBeanI.logout(user)) {
            return Response.status(200).entity(user.getJobId() + "  you are successfully logged out").build();
        }
        return Response.status(201).entity("Failed!!").build();
    }
}
