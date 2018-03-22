package Bean.BeanInterface;

import Bean.Interceptor.LogoutInterceptorB;
import Entities.User;

import javax.ejb.Local;

/**
 * Created by SELPHA on 26/2/2018.
 */
@Local
public interface UserBeanI {
    boolean register(User u);
    @LogoutInterceptorB
    void login(User u);
    boolean edit(User u);
    @LogoutInterceptorB
    boolean logout(User u);
}
