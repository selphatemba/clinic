package Dao.DaoImplementation;

import Dao.DaoInterface.DaoI;
import Dao.DaoInterface.DaoIAnnotation;
import Entities.Doctor;


import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

import static Dao.DaoInterface.DaoIAnnotation.User.DOCTOR;

/**
 * Created by SELPHA on 14/2/2018.
 */
@RequestScoped
@DaoIAnnotation(choice = DOCTOR)
public class DoctorDao implements DaoI {
    @PersistenceContext(unitName = "clinic")
            private EntityManager entityManager;

    Doctor d=null;
    public DoctorDao() {
        d=new Doctor();
    }

    //create doctor
    public boolean insert(Object o) {
        d= (Doctor) o;
        try {
            entityManager.persist(d);
        }catch (PersistenceException p){
            p.printStackTrace();
            return false;
        }
        return true;
    }

    //update doctor
    public boolean update(Object o) {
        d= (Doctor) o;
        try {
            d=entityManager.find(Doctor.class,d.getIdnumber());
            entityManager.merge(d);
        }catch (PersistenceException p){
            p.printStackTrace();
            return false;
        }
        return true;
    }

    //delete a doctor
    public boolean delete(Object o) {
        d= (Doctor) o;
        try{
            entityManager.remove(d);
        }catch (PersistenceException p){
            p.printStackTrace();
            return false;
        }
        return true;

    }

    public boolean find(Object o) {
        return false;
    }

    //Find a doctor by Doctor ID
    public boolean findById(Object o) {
        d= (Doctor) o;
        try{
            entityManager.find(Doctor.class,d.getIdnumber());
        }catch (PersistenceException p){
            p.printStackTrace();
            return false;
        }
        return true;
    }


    //Find all doctors
    public List<Object> findAll(Object o) {
        d= (Doctor) o;
        List<Object>doctors=new ArrayList<Object>();
        try {
            String s="select d from Doctor d";
            doctors=entityManager.createQuery(s).getResultList();
        }catch (PersistenceException p){
            p.printStackTrace();
        }
        return doctors;

    }

    //count all doctors
    public int countAll(Object o) {
        d= (Doctor) o;
        List<Object>doctorList=new ArrayList<Object>();
        try {
            String s="select d from Doctor d";
            doctorList=entityManager.createQuery(s).getResultList();
        }catch (PersistenceException p){
            p.printStackTrace();
        }
        return doctorList.size();
    }
    }



