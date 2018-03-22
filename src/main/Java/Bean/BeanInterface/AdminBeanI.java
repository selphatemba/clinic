package Bean.BeanInterface;

import Entities.*;

import javax.ejb.Local;
import java.util.ArrayList;

/**
 * Created by SELPHA on 14/2/2018.
 */
@Local
public interface AdminBeanI {
    boolean payForServices(Payment p);
    boolean bookPatientToDoctor(Booking b);
    boolean dispenseDrug(Dispensation dispensation);
    boolean consultDoctor(Consultation consultation);
    boolean runLabTest(TestResult testResult);
    ArrayList<Medicine>getAllMedicine();
}
