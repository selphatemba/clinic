package Dao.DaoInterface;

import Entities.*;


/**
 * Created by SELPHA on 14/2/2018.
 */
public interface AdminInterface {
    boolean bookPatient(Booking b);
    boolean consultDoctor(Consultation c);
    boolean runLabTest(TestResult testResult);
    boolean pay(Payment p);
    boolean dispenseDrug(Dispensation dispensation);
    boolean prescribeDrug(Prescription p);
}
