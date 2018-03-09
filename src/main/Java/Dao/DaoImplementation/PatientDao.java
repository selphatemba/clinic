package Dao.DaoImplementation;

import Dao.DaoInterface.DaoI;
import Dao.DaoInterface.DaoIAnnotation;
import Pojo.Patient;

import javax.enterprise.context.RequestScoped;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Dao.DaoInterface.DaoIAnnotation.User.PATIENT;

/**
 * Created by SELPHA on 14/2/2018.
 */
@RequestScoped
@DaoIAnnotation(choice = PATIENT)
public class PatientDao implements DaoI {
    DBUtil util=null;
    Patient p=null;
    ResultSet rs=null;

    public PatientDao() {
        util = new DBUtil();
    }


    //create a patient
    public boolean insert(Object o) {
        p=(Patient) o;
        boolean loggedin=false;
        int k =0;
        try {
            String sql="insert into patientregister (fname,sname,IDnumber,Pid) values('"+p.getFname()+"','"+p.getSname()+"','"+p.getIDnumber()+"','"+p.getPid()+"')";
            k = util.write(sql);
            util.conn.commit();
            if (k>0) {
                loggedin = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loggedin;
    }

    //update patient
    public boolean update(Object o) {
        p=(Patient) o;
        boolean updated=false;
        int k=0;
        try {
            String n="update patientregister set fname="+p.getFname()+"sname="+p.getSname()+"IDnumber="+p.getIDnumber()+"Pid="+p.getPid();
            ResultSet rs=util.read(n);
            k=util.write(n);
            util.conn.commit();
            if(k>0){
                updated=true;
            }
        }catch (SQLException s){
            s.printStackTrace();
        }
        return updated;
    }


    //delete patient
    public boolean delete(Object o) {
        p= (Patient) o;
        boolean patientdeleted=false;
        int k=0;
        try {
            String sql="delete from patientregister where Pid='"+p.getPid()+"'";
            k=util.write(sql);
            util.conn.commit();
            if(k>0){
                patientdeleted=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patientdeleted;
    }

    //read patient
    public boolean find(Object o) {
        return false;
    }


    //find a patient by ID
    public boolean findById(Object o) {
        p=(Patient) o;
        boolean read=false;
        int k=0;
        try {
            String s="select * from patientregister where Pid='"+p.getPid()+"'";
            rs=util.read(s);
            while (rs.next()){
                read=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return read;}

        //find all patients
    public ResultSet findAll(Object o) {
        p=(Patient) o;
        try {
            String s="select * from patientregister";
            rs=util.read(s);
            while (rs.next()){
                return rs;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //count all patients
    public int countAll(Object o) {
        p=(Patient) o;
        int count=0;
        try {
            String s="select count(*) from patientregister";
            rs=util.read(s);
            while (rs.next()){
                count++;}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  count;
    }
}
