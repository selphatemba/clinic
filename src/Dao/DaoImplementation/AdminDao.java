package Dao.DaoImplementation;

import Dao.DaoInterface.AdminInterface;
import Entities.Booking;
import Entities.Consultation;
import Entities.Prescription;
import Entities.TestResult;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.ArrayList;

/**
 * Created by SELPHA on 14/2/2018.
 */
public class AdminDao implements AdminInterface {
    private EntityManager entityManager;

    public AdminDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    //book patient
    public boolean bookPatient(Booking b) {
        try {
            entityManager.persist(b);
        }catch (PersistenceException p){
            p.printStackTrace();
            return false;
        }
        return true;
    }

    //doctor consultation
    public boolean consultDoctor(Consultation c) {
        try {
            entityManager.persist(c);
        }catch (PersistenceException p){
            p.printStackTrace();
            return false;
        }
        return true;

    }

    //prescribe drug
    public boolean prescribeDrug(Prescription p) {
        try {
            entityManager.persist(p);
        }catch (PersistenceException pe){
            pe.printStackTrace();
            return false;
        }
        return true;

    }

    //run lab test
    public boolean runLabTest(TestResult testResult) {
        try {
            entityManager.persist(testResult);
        }catch (PersistenceException p){
            p.printStackTrace();
            return false;
        }
        return true;
    }

    //patient pay for services
    public boolean pay(Entities.Payment p) {
        try {
            entityManager.persist(p);
        }catch (PersistenceException pex){
            pex.printStackTrace();
            return false;
        }
        return true;
    }

    //dispense drug
    public boolean dispenseDrug(Entities.Dispensation dispensation) {
        try {
            entityManager.persist(dispensation);
        }catch (PersistenceException p){
            p.printStackTrace();
            return false;
        }
        return true;
    }

    //arrayList of available medicine
    public ArrayList<Entities.Medicine> createArrayListOfMedicine(){
        ArrayList<Entities.Medicine>medicines=new ArrayList<Entities.Medicine>();
        for (int i=0;i<500;i++){
           Entities.Medicine m=new Entities.Medicine();
            medicines.add(m);
        }
        return medicines;

    }

}
