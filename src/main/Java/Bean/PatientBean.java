package Bean;

import Dao.DaoI;
import Dao.PatientDaoI;
import Pojo.Patient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;

/**
 * Created by SELPHA on 19/2/2018.
 */

//creates a managed bean called "patientbean"
@RequestScoped
@PatientBeanI
public class PatientBean implements BeanI {
    @Inject
    @PatientDaoI
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


