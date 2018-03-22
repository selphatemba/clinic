package Dao.DaoImplementation;

import Dao.DaoInterface.DaoI;
import Dao.DaoInterface.DaoIAnnotation;
import Entities.Patient;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Dao.DaoInterface.DaoIAnnotation.User.PATIENT;

/**
 * Created by SELPHA on 14/2/2018.
 */
@RequestScoped
@DaoIAnnotation(choice = PATIENT)
public class PatientDao implements DaoI {

    @PersistenceContext(unitName = "clinic")
    private EntityManager entityManager;
    Patient p=null;

    public PatientDao() {
        p=new Patient();
    }

    //create a patient
    public boolean insert(Object o) {
        p=(Patient) o;
        try {
            entityManager.persist(p);
        }catch (PersistenceException p){
            p.printStackTrace();
            return false;
        }
        return true;
    }

    //update patient
    public boolean update(Object o) {
        p=(Patient) o;
        try {
            p=entityManager.find(Patient.class,p.getIDnumber());
            entityManager.merge(p);
        }catch (PersistenceException p){
            p.printStackTrace();
            return false;
        }
        return true;
    }


    //delete patient
    public boolean delete(Object o) {
        p= (Patient) o;
        try{
            entityManager.remove(p);
        }catch (PersistenceException p){
            p.printStackTrace();
            return false;
        }
        return true;
    }

    //read patient
    public boolean find(Object o) {
        return false;
    }


    //find a patient by ID
    public boolean findById(Object o) {
        p=(Patient) o;
        try{
            entityManager.find(Patient.class,p.getIDnumber());
        }catch (PersistenceException p){
            p.printStackTrace();
            return false;
        }
        return true;
       }

        //find all patients
    public List<Object> findAll(Object o) {
        p=(Patient) o;
        List<Object>patients=new ArrayList<Object>();
        try {
            String s="select p from Patient p";
            patients=entityManager.createQuery(s).getResultList();
        }catch (PersistenceException p){
            p.printStackTrace();
        }
        return patients;
    }

    //count all patients
    public int countAll(Object o) {
        p=(Patient) o;
        List<Object>patients=new ArrayList<Object>();
        try {
            String s="select p from Patient p";
            patients=entityManager.createQuery(s).getResultList();
        }catch (PersistenceException p){
            p.printStackTrace();
        }
        return patients.size();
    }
}
