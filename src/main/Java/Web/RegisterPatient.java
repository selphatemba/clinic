package Web;

import Bean.BeanI;
import Bean.UserBeanI;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static Bean.UserBeanI.User.PATIENT;

/**
 * Created by SELPHA on 19/2/2018.
 */
@WebServlet(urlPatterns = "/registerpatient")
public class RegisterPatient extends HttpServlet {
    @Inject
    @UserBeanI(choice = PATIENT)
    private BeanI beanI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("patientBeanI",beanI);
        req.getRequestDispatcher("Management.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("patientBeanI",beanI);
        req.getRequestDispatcher("Management.jsp").forward(req,resp);
    }
}
