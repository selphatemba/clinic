package Web;

import Bean.BeanInterface.Admin;
import Bean.BeanInterface.AdminBeanI;
import Pojo.Medicine;
import Pojo.Patient;

import javax.inject.Inject;
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
    @Inject
    @Admin
    private AdminBeanI adminBeanI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("DispenseDrug.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Patient p=new Patient();
        p.setPid(req.getParameter("PatientID"));
        ArrayList<Medicine>medicines=adminBeanI.getAllMedicine();

        if(adminBeanI.dispenseDrug(p,medicines)){
            resp.sendRedirect("/ClinicMis2/home");
        }else {
            resp.sendRedirect("/ClinicMis2/pharmacy");
        }
    }
}
