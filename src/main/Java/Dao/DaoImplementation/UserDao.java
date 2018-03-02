package Dao.DaoImplementation;

import Dao.DaoInterface.DaoI;
import Dao.DaoInterface.UserDaoI;
import Pojo.User;

import javax.enterprise.context.RequestScoped;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SELPHA on 17/2/2018.
 */
@RequestScoped
@UserDaoI
public class UserDao implements DaoI {
DBUtil util=null;
User u=null;
ResultSet rs=null;

    public UserDao() {
        util=new DBUtil();
    }


    public boolean insert(Object o) {
        u = (User) o;
        boolean inserted=false;
        int k =0;
        try {
            String sql="insert into registration(fname,lname,town,gender,title,jobID,phoneNumber,email,password) values('"+u.getFname()+"','"+u.getLname()+"','"+u.getTown()+
                    "','"+u.getGender()+"','"+u.getTitle()+"','"+u.getJobId()+"',"+u.getPhoneNumber()+",'"+u.getEmail()+"','"+u.getPassword()+"')";
            k = util.write(sql);
            util.conn.commit();
            if (k>0) {
                inserted = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return inserted;
    }


    public boolean update(Object o) {
        u= (User) o;
        boolean updated=false;
        int k=0;
        try {
            String s="update table registration set phoneNumber='"+u.getPhoneNumber()+"'password='"+u.getPassword()+"' where jobID='"+u.getJobId()+"'";
            k=util.write(s);
            util.conn.commit();
            if(k>0){
                updated=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }

    public boolean delete(Object o) {
        u=(User)o;
        boolean deleted=false;
        int k=0;
        try {
            String s="delete from registration where jobID='"+u.getJobId()+"'";
            k=util.write(s);
            util.conn.commit();
            if(k>0){
                deleted=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deleted;
    }

    public boolean find(Object o) {
        u=(User)o;
        boolean found=false;
        int k=0;
        try {
            String s="select * from registration where jobID='"+u.getJobId()+"'and password='"+u.getPassword()+"'";
            rs=util.read(s);
            while (rs.next()){
                found=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return found;
    }


    public boolean findById(Object o) {
        u=(User)o;
        boolean read=false;
        int k=0;
        try {
            String s="select * from registration where jobID='"+u.getJobId()+"'";
            rs=util.read(s);
            while (rs.next()){
                read=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return read;
    }


    public ResultSet findAll(Object o) {
        u=(User)o;
        boolean allFound=false;
        try {
            String s="select * from registration";
            rs=util.read(s);
            while (rs.next()){
               return rs;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }


    public int countAll(Object o) {
        u=(User)o;
        int count=0;
        try {
            String s="select count(*) from registration";
            rs=util.read(s);
            while (rs.next()){
              count++;}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  count;
    }
    //login user
    public boolean login(User u) {
        boolean loggedIn=false;
        ResultSet rs;
        int k=0;
        try {
            String s="select * from registration where jobID='"+u.getJobId()+"'and password='"+u.getPassword()+"'";
            String s1="insert into login(jobID,password)values ('"+u.getJobId()+"','"+u.getPassword()+"')";
            rs=util.read(s);
            k=util.write(s1);
            if(rs.next() && k>0){
                loggedIn=true;
            }
            k=util.write(s1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loggedIn;
    }
    //log out user
    public boolean logout(User u) {

        return false;
    }


}
