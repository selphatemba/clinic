package Bean.BeanInterface;

import Entities.Patient;

import javax.ejb.Local;

/**
 * Created by SELPHA on 16/3/2018.
 */
@Local
public interface PatientBeanI {
    boolean register(Patient p);
    boolean edit(Patient p);

}
