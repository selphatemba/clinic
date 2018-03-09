package Bean.BeanInterface;

import javax.ejb.Remote;

/**
 * Created by SELPHA on 26/2/2018.
 */
@Remote
public interface BeanI {
    boolean register(Object o);
    boolean login(Object o);
    boolean edit(Object o);
    boolean logout(Object o);
}
