package Bean.BeanImplementation;

import Bean.BeanInterface.PatientBeanI;
import Dao.DaoInterface.DaoI;
import Dao.DaoInterface.DaoIAnnotation;
import Entities.Patient;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Inject;

import static Dao.DaoInterface.DaoIAnnotation.User.PATIENT;

/**
 * Created by SELPHA on 19/2/2018.
 */

//creates a managed bean called "patientbean"
@Stateless
public class PatientBean implements PatientBeanI {
    @Inject
    @DaoIAnnotation(choice = PATIENT)
    DaoI daoI;
    Patient p=null;

    public PatientBean() {
       // p=new Patient();
    }

    //register patient
    @PostConstruct
    public void register(){
    }

    public boolean register(Patient p) {
        return daoI.insert(p);
    }

    public boolean edit(Patient p) {
        return daoI.update(p);
    }

  @PreDestroy
    public void logout(){
    }
}


