package Bean.Interceptor;

import Entities.User;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;


import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by SELPHA on 12/3/2018.
 */
@Interceptor
@LoginInterceptorB
@Priority(Interceptor.Priority.APPLICATION)
public class LoginInterceptor{

    @AroundInvoke
    public Object checkSession(InvocationContext ctxt){
        WebContext ctx = WebContextFactory.get();
        HttpServletRequest request = ctx.getHttpServletRequest();
        HttpSession session=request.getSession();
    User user=new User();
    try {
        if(session.getAttribute("name")!=null){
            session.getAttribute("name");
        }else {
            session.setAttribute("name",user.getJobId());
        }
        ctxt.proceed();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return new Object();
    }
}
