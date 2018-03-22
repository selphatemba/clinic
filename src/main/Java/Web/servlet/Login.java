/*
package Web.servlet;

import Bean.BeanImplementation.UserBean;
import Bean.BeanInterface.UserBeanI;
import Pojo.User;

import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


*
 * Created by SELPHA on 21/2/2018.


@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
    @EJB
    private UserBeanI userBeanI;
    @Inject
    Event<UserBean> userBeanEvent;
    private User user=new User();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        user.setJobId(req.getParameter("userid"));
        user.setPassword(req.getParameter("password"));
        if(userBeanI.login(user)){
 HttpSession session=req.getSession();
            session.setAttribute("name",user.getJobId());
            out.print("welcome"+req.getAttribute("name"));

            resp.sendRedirect("/ClinicMis2/home");


        if(user.getJobId().matches("D.....D")){
        userBeanEvent.fire(new UserBean());
}
        }
        else {

            resp.sendRedirect("/ClinicMis2/login");
        }

    }
}
*/
