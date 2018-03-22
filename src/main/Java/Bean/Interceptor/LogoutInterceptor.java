package Bean.Interceptor;

import Bean.Interceptor.LogoutInterceptorB;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by SELPHA on 19/3/2018.
 */
@Interceptor
@LogoutInterceptorB
@Priority(Interceptor.Priority.APPLICATION)
public class LogoutInterceptor {

    @AroundInvoke
    public Object checkSession(InvocationContext cxt){
        WebContext ctx = WebContextFactory.get();
        HttpServletRequest request = ctx.getHttpServletRequest();
        HttpSession sess=request.getSession();
        try {
            if(sess.getAttribute("name")!=null){
                sess.invalidate();
            }else {

            }
            cxt.proceed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Object();
    }
}
