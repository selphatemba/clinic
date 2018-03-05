package Dao.DaoImplementation;

import Dao.DaoInterface.DaoI;
import Dao.DaoInterface.DoctorDaoI;
import Pojo.Doctor;

import javax.enterprise.context.RequestScoped;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SELPHA on 14/2/2018.
 */
@RequestScoped
@DoctorDaoI
public class DoctorDao implements DaoI {
    DBUtil util = null;
    Doctor d=null;
    ResultSet rs=null;

    public DoctorDao() {
        util = new DBUtil();
    }

    //create doctor
    public boolean insert(Object o) {
        d= (Doctor) o;
        boolean doctoregistered = false;
        int k = 0;
        try {
            String sql = "insert into doctorregister(fname,sname,IDnumber,Did) values('" + d.getFname() + "','" + d.getSname() + "'," +d.getIdnumber()+",'" +d.getDid() + "')";
            k = util.write(sql);
            util.conn.commit();
            if (k > 0) {
                doctoregistered = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctoregistered;
    }

    //update doctor
    public boolean update(Object o) {
        d= (Doctor) o;
        boolean updated=false;
        int k=0;
        try {
            String n="update doctorregister set fname='"+d.getFname()+"' sname='"+d.getSname()+"' Did='"+d.getDid()+"'";
            rs=util.read(n);
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

    //delete a doctor
    public boolean delete(Object o) {
        d= (Doctor) o;
        boolean doctordeleted=false;
        int k=0;
        try {
            String sql="delete from doctorregister where Did='"+d.getDid()+"'";
            k=util.write(sql);
            util.conn.commit();
            if(k>0){
                doctordeleted=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctordeleted;
    }

    public boolean find(Object o) {
        return false;
    }

    //Find a doctor by Doctor ID
    public boolean findById(Object o) {
        d= (Doctor) o;
        boolean read=false;
        int k=0;
        try {
            String s="select * from doctorregister where jobID='"+d.getDid()+"'";
            rs=util.read(s);
            while (rs.next()){
                read=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return read;
    }


    //Find all doctors
    public ResultSet findAll(Object o) {
        d= (Doctor) o;
        try {
            String s="select * from doctorregister";
            rs=util.read(s);
            while (rs.next()){
                return rs;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //count all doctors
    public int countAll(Object o) {
        d= (Doctor) o;
        int count=0;
        try {
            String s="select count(*) from doctorregister";
            rs=util.read(s);
            while (rs.next()){
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  count;
    }
}


