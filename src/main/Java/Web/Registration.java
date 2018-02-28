package Web;

import Bean.BeanI;
import Bean.UserBeanI;
import Pojo.Gender;
import Pojo.Title;
import Pojo.User;

import javax.inject.Inject;
import javax.inject.Named;
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
    @Inject
    @UserBeanI
    private BeanI beanI;
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
        user.setPhoneNumber(Integer.parseInt(req.getParameter("phonenumber")));
        user.setPassword(req.getParameter("password"));
        user.setPassword(req.getParameter("password2"));


        if (beanI.register(user)) {
            out.print("Successfully signed up");
        } else {
            out.print("Not signed up kindly try again");
        }
    }
}
