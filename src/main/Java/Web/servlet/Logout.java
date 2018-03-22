package Web.servlet;

import Bean.BeanInterface.UserBeanI;
import Entities.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by SELPHA on 21/2/2018.
 */
@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet {
    @EJB
    UserBeanI userBeanI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=new User();
        userBeanI.logout(user);
            resp.sendRedirect("index.jsp");
        }
    }

