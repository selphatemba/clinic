package Bean.BeanImplementation;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;

/**
 * Created by SELPHA on 11/3/2018.
 */
@RequestScoped
public class DoctorLoginObserver {
    public void notifyAdmin(@Observes UserBean userBean){
        System.out.println("A doctor just logged in!");
    }
}
