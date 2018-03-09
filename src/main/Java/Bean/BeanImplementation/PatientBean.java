package Bean.BeanImplementation;

import Bean.BeanInterface.BeanI;
import Dao.DaoInterface.DaoI;
import Dao.DaoInterface.DaoIAnnotation;
import Pojo.Patient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import static Dao.DaoInterface.DaoIAnnotation.User.PATIENT;

/**
 * Created by SELPHA on 19/2/2018.
 */

//creates a managed bean called "patientbean"
@RequestScoped
public class PatientBean implements BeanI {
    @Inject
    @DaoIAnnotation(choice = PATIENT)
    DaoI daoI;
    Patient p=null;

    public PatientBean() {
        p=new Patient();
    }

    //register patient
    public boolean register(Object o) {
        p= (Patient) o;
        return daoI.insert(p);
    }

    public boolean login(Object o) {
        return false;
    }

    public boolean edit(Object o) {
        p= (Patient) o;
        return daoI.update(p);
    }

    public boolean logout(Object o) {
        return false;
    }
}


