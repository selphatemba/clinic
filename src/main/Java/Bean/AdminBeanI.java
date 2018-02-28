package Bean;

import Pojo.*;

import java.util.ArrayList;

/**
 * Created by SELPHA on 14/2/2018.
 */
public interface AdminBeanI {
    boolean payForServices(Payment p);
    boolean bookPatientToDoctor(Booking b);
    void dispenseDrug(Patient p,ArrayList<Medicine> medicines);
    boolean consultDoctor(Booking b, Doctor d);
    boolean runLabTest(Patient p, LabTest l);
}
