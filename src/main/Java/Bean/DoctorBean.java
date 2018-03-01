package Bean;

import Dao.DaoI;
import Dao.DoctorDaoI;
import Pojo.Doctor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;

import static Bean.UserBeanI.User.DOCTOR;

/**
 * Created by SELPHA on 19/2/2018.
 */

//creates a managed bean called "doctorbean"
@RequestScoped
@UserBeanI(choice = DOCTOR)
public class DoctorBean implements BeanI {
    @Inject
    @DoctorDaoI
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
