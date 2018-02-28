package Web;

import Bean.BeanI;
import Bean.UserBeanI;
import Pojo.User;
import com.sun.org.apache.xml.internal.dtm.ref.sax2dtm.SAX2DTM2;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by SELPHA on 21/2/2018.
 */
@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
    @Inject
    @UserBeanI
    private BeanI beanI;
    User user=new User();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        user.setJobId(req.getParameter("jobid"));
        user.setPassword(req.getParameter("password"));
        if(beanI.login(user)){
            HttpSession session=req.getSession();
            session.setAttribute("name","selpha");
            out.print("welcome"+req.getAttribute("name"));
            resp.sendRedirect("Home.jsp");
        }
        else {

            out.print("not logged in try again");
        }

    }
}
