package Web;

import Bean.BeanInterface.BeanI;
import Pojo.Doctor;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by SELPHA on 5/3/2018.
 */
@WebServlet(urlPatterns = "/registerdoctor")
public class RegisterDoctor extends HttpServlet{
    @EJB
    private BeanI docterBeanI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("DoctorRegister.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Doctor doctor=new Doctor();
        doctor.setFname(req.getParameter("firstname"));
        doctor.setSname(req.getParameter("secondname"));
        doctor.setIdnumber(Integer.parseInt(req.getParameter("idnumber")));
        doctor.setDid(req.getParameter("Did"));

        if(docterBeanI.register(doctor)){
            resp.sendRedirect("/ClinicMis2/home");
        }else{
            resp.sendRedirect("/ClinicMis2/registerdoctor");
        }

    }
}
