package Web.servlet;

import Bean.BeanInterface.AdminBeanI;
import Entities.Dispensation;
import Entities.Medicine;
import Entities.Patient;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by SELPHA on 5/3/2018.
 */
@WebServlet(urlPatterns = "/pharmacy")
public class Pharmacy extends HttpServlet{
    @EJB
    private AdminBeanI adminBeanI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("DispenseDrug.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Patient p=null;
        p.setPid(req.getParameter("PatientID"));
        Dispensation dispensation=new Dispensation();

        if(adminBeanI.dispenseDrug(dispensation)){
            resp.sendRedirect("/ClinicMis2/home");
        }else {
            resp.sendRedirect("/ClinicMis2/pharmacy");
        }
    }
}
