package Dao.DaoImplementation;

import Dao.DaoInterface.DaoI;
import Dao.DaoInterface.DaoIAnnotation;
import Entities.User;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Dao.DaoInterface.DaoIAnnotation.User.USER;

/**
 * Created by SELPHA on 17/2/2018.
 */
@RequestScoped
@DaoIAnnotation(choice = USER)
public class UserDao implements DaoI {
    @PersistenceContext(unitName = "clinic")
    private EntityManager entityManager;
    User u=null;

    public UserDao() {
        u=new User();
    }

    public boolean insert(Object o) {
        u = (User) o;
        try {
            entityManager.persist(u);
        }catch (PersistenceException p){
            p.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean update(Object o) {
        u= (User) o;
        try {
            u=entityManager.find(User.class,u.getIdNumber());
            entityManager.merge(u);
        }catch (PersistenceException p){
            p.printStackTrace();
            return false;
        }
    return true;
    }


    public boolean delete(Object o) {
        u=(User)o;
        try{
            entityManager.remove(u);
        }catch (PersistenceException p){
            p.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean find(Object o) {
        u=(User)o;
       try {
           String str="select u from User u where jobId='"+u.getJobId()+"' and password='"+u.getPassword()+"'";
           entityManager.createQuery(str).getSingleResult();
       }catch (PersistenceException p){
           p.printStackTrace();
           return false;
       }
       return true;
    }


    public boolean findById(Object o) {
        u=(User)o;
        try{
            entityManager.find(User.class,u.getIdNumber());
        }catch (PersistenceException p){
            p.printStackTrace();
            return false;
        }
       return true;
    }


    public List<Object> findAll(Object o) {
        u=(User)o;
        List<Object>users=new ArrayList<Object>();
        try {
            String s="select u from User u";
            users=entityManager.createQuery(s).getResultList();
        }catch (PersistenceException p){
            p.printStackTrace();
        }
        return  users;
    }


    public int countAll(Object o) {
        u=(User)o;
        List<User>users=new ArrayList<User>();
        try {
            String s="select u from User u";
            users=entityManager.createQuery(s).getResultList();
        }catch (PersistenceException p){
            p.printStackTrace();
        }
        return users.size();

    }


}
