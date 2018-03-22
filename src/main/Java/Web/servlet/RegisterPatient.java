package Web.servlet;

import Bean.BeanInterface.PatientBeanI;
import Entities.Patient;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by SELPHA on 19/2/2018.
 */
@WebServlet(urlPatterns = "/registerpatient")
public class RegisterPatient extends HttpServlet {
    @EJB
    private PatientBeanI patientBeanI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("PatientRegister.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Patient patient=null;
        if(req.getParameter("fname")!=null) {
                patient.setFname(req.getParameter("fname"));
                patient.setSname(req.getParameter("lname"));
                patient.setIDnumber(Integer.parseInt(req.getParameter("idnumber")));
                patient.setPid(req.getParameter("patientid"));
                if (patientBeanI.register(patient)) {
                  resp.sendRedirect("/ClinicMis2/home");
                }

        }else resp.sendRedirect("/ClinicMis2/registerpatient");
    }
}
