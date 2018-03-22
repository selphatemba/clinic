package Bean.BeanImplementation;

import Bean.BeanInterface.DoctorBeanI;
import Dao.DaoInterface.DaoI;
import Dao.DaoInterface.DaoIAnnotation;
import Entities.Doctor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Inject;

import static Dao.DaoInterface.DaoIAnnotation.User.DOCTOR;

/**
 * Created by SELPHA on 19/2/2018.
 */

//creates a managed bean called "doctorbean"
@Stateless(name = "doctorBean")
public class DoctorBean implements DoctorBeanI {
    @Inject
    @DaoIAnnotation(choice = DOCTOR)
    DaoI daoI;
    Doctor d=null;

    public DoctorBean() {

        //d=new Doctor();
    }

    @PostConstruct
    public void register(){}

    public boolean register(Doctor d) {
        return daoI.insert(d);
    }

    public boolean edit(Doctor d) {
        return daoI.update(d);
    }


    @PreDestroy
    public void logout(){
    }
}
