package Web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by SELPHA on 21/2/2018.
 */
@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String s=(String) session.getAttribute("name");
        if(s!=null) {
            session.invalidate();
            resp.sendRedirect("index.jsp");
        }
    }
}
