package Bean.BeanImplementation;

import Bean.BeanInterface.Admin;
import Bean.BeanInterface.AdminBeanI;
import Pojo.*;
import Dao.DaoImplementation.AdminDao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.inject.Qualifier;
import java.util.ArrayList;

/**
 * Created by SELPHA on 14/2/2018.
 */

//creates a managed bean called "mylogicbean"
@RequestScoped
@Admin
public class AdminBean implements AdminBeanI {
    AdminDao adminDao;


    public AdminBean() {
        adminDao=new AdminDao();
    }

    public boolean payForServices(Payment p) {
        return adminDao.pay(p);
    }

    public boolean bookPatientToDoctor(Booking b) {return adminDao.bookPatient(b);
    }
    public boolean dispenseDrug(Patient p, ArrayList<Medicine> medicines) {return adminDao.dispenseDrug(p,medicines);

    }
    public boolean consultDoctor(Booking b, Doctor d) {
        return adminDao.consultDoctor(b, d);
    }

    public boolean runLabTest(Patient p, LabTest l) {
        return adminDao.runLabTest(p, l);

    }
    public ArrayList<Medicine> getAllMedicine() {
     return adminDao.createArrayListOfMedicine();
    }
}
