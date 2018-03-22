package Dao.DaoImplementation;

import Dao.DaoInterface.AdminInterface;
import Entities.*;


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
    public boolean pay(Payment p) {
        try {
            entityManager.persist(p);
        }catch (PersistenceException pex){
            pex.printStackTrace();
            return false;
        }
        return true;
    }

    //dispense drug
    public boolean dispenseDrug(Dispensation dispensation) {
        try {
            entityManager.persist(dispensation);
        }catch (PersistenceException p){
            p.printStackTrace();
            return false;
        }
        return true;
    }

    //arrayList of available medicine
    public ArrayList<Medicine> createArrayListOfMedicine(){
        ArrayList<Medicine>medicines=new ArrayList<Medicine>();
        for (int i=0;i<500;i++){
           Medicine m=new Medicine();
            medicines.add(m);
        }
        return medicines;

    }

}
