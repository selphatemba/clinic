package Bean.BeanImplementation;

import Bean.BeanInterface.AdminBeanI;
import Entities.*;
import Dao.DaoImplementation.AdminDao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;
import javax.persistence.EntityManager;
import java.util.ArrayList;

/**
 * Created by SELPHA on 14/2/2018.
 */

//creates a managed bean called "mylogicbean"
@Stateless
public class AdminBean implements AdminBeanI {
    private  EntityManager entityManager;
    AdminDao adminDao;
@PostConstruct
   public void start(){
   }
    public AdminBean() {
        adminDao=new AdminDao(entityManager);
    }

    public boolean payForServices(Payment p) {
        return adminDao.pay(p);
    }

    public boolean bookPatientToDoctor(Booking b) {return adminDao.bookPatient(b);
    }
    public boolean dispenseDrug(Dispensation dispensation) {return adminDao.dispenseDrug(dispensation);

    }
    public boolean consultDoctor(Consultation consultation) {
        return adminDao.consultDoctor(consultation);
    }

    public boolean runLabTest(TestResult testResult) {
        return adminDao.runLabTest(testResult);

    }
    public ArrayList<Medicine> getAllMedicine() {
     return adminDao.createArrayListOfMedicine();
    }

   @PreDestroy
    public void finish() {

    }
}
