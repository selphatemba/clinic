package Web.servlet;

import Bean.BeanInterface.AdminBeanI;
import Entities.Booking;
import Entities.Doctor;
import Entities.Patient;

import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by SELPHA on 11/3/2018.
 */
@WebServlet(urlPatterns = "/admin")
public class Admin extends HttpServlet {
    @EJB
    AdminBeanI adminBeanI;
    @Inject
    Event<Booking> bookingEvent;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("PatientBooking.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Booking booking=new Booking();
        booking.setdID(req.getParameter("doctorid"));
        booking.setpID(req.getParameter("patientid"));
        if(adminBeanI.bookPatientToDoctor(booking)){
            resp.sendRedirect("/ClinicMis2/home");
            bookingEvent.fire(booking);
        }else {
            resp.sendRedirect("/ClinicMis2/admin");
        }
    }
}
