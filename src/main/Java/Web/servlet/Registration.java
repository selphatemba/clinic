package Web.servlet;

import Bean.BeanInterface.UserBeanI;
import Entities.Gender;
import Entities.Title;
import Entities.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by SELPHA on 20/2/2018.
 */
@WebServlet(urlPatterns = "/registration")
public class Registration  extends HttpServlet{
    @EJB(name = "userBean")
    private UserBeanI userBeanI;
    User user=new User();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("Registration.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();


        user.setFname(req.getParameter("fname"));
        user.setLname(req.getParameter("lname"));
        user.setTown(req.getParameter("town"));
        user.setGender(Gender.valueOf(req.getParameter("gender")));
        user.setTitle(Title.valueOf(req.getParameter("title")));
        user.setJobId(req.getParameter("jobid"));
        user.setIdNumber(Integer.parseInt(req.getParameter("idnumber")));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        user.setPassword(req.getParameter("password2"));


        if (userBeanI.register(user)) {
            resp.sendRedirect("/ClinicMis2/login");
        } else {
            resp.sendRedirect("/ClinicMis2/registration");
        }
    }
}
