package Dao;

import Pojo.*;

import java.util.ArrayList;

/**
 * Created by SELPHA on 14/2/2018.
 */
public interface AdminInterface {
    boolean bookPatient(Booking b);
    boolean consultDoctor(Booking b, Doctor d);
    boolean runLabTest(Patient p, LabTest l);
    boolean pay(Payment p);
    boolean dispenseDrug(Patient p,ArrayList<Medicine> medicines);
}
