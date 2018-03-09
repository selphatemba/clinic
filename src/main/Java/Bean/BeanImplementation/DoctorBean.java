package Bean.BeanImplementation;

import Bean.BeanInterface.BeanI;
import Dao.DaoInterface.DaoI;
import Dao.DaoInterface.DaoIAnnotation;
import Pojo.Doctor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import static Dao.DaoInterface.DaoIAnnotation.User.DOCTOR;

/**
 * Created by SELPHA on 19/2/2018.
 */

//creates a managed bean called "doctorbean"
@RequestScoped
public class DoctorBean implements BeanI {
    @Inject
    @DaoIAnnotation(choice = DOCTOR)
    DaoI daoI;
    Doctor d=null;

    public DoctorBean() {
        d=new Doctor();
    }

    public boolean register(Object o) {
        d= (Doctor) o;
        return daoI.insert(d);
    }

    public boolean login(Object o) {
        return false;
    }

    public boolean edit(Object o) {
        return daoI.update(d);
    }

    public boolean logout(Object o) {
        return false;
    }
}
