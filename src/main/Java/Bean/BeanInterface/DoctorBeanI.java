package Bean.BeanInterface;

import Entities.Doctor;

import javax.ejb.Local;

/**
 * Created by SELPHA on 16/3/2018.
 */
@Local
public interface DoctorBeanI {
    boolean register(Doctor d);
    boolean edit(Doctor d);

}
