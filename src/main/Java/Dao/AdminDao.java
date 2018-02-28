package Dao;

import Pojo.*;


import java.sql.*;
import java.util.ArrayList;

/**
 * Created by SELPHA on 14/2/2018.
 */
public class AdminDao implements AdminInterface{
    DBUtil util=null;

//constructor creates util object
    public AdminDao() {
        util=new DBUtil();
    }

//book patient
    public boolean bookPatient(Booking b) {
        boolean bookpatient=false;
        int k=0;
        try {
            String sql="insert into bookpatient (doctorid,patientid) values('"+b.getD()+"','"+b.getP()+"')";
            k= util.write(sql);
            util.conn.commit();
            if(k>0){
                bookpatient=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookpatient;
    }

    //doctor consultation
    public boolean consultDoctor(Booking b, Doctor d) {
        boolean patientSeen=false;
        int k=0;
        try{
            String sql1="insert into consultDoctor (patientid,doctotid) values('"+b.getD()+"','"+b.getP()+"',";
            k=util.write(sql1);
            util.conn.commit();
            if(k>0){
                patientSeen=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patientSeen;
    }

    //prescribe drug
    public boolean prescribeDrug(Patient p, ArrayList<Medicine> medicines) {
        int k=0;
        boolean prescribeDrug=false;
        try {
            String sql="insert into prescriptions (patient,medicine)values("+p.getPid()+",'"+medicines+"')";
            k=util.write(sql);
            util.conn.commit();
            if(k>0){
            prescribeDrug=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prescribeDrug;
    }

    //run lab test
    public boolean runLabTest(Patient p, LabTest l) {
        boolean runLabTest=false;
        try {
            String sql="insert into labtest (patientId,testResults)values("+p.getPid()+","+LabTest.values()+")";
            util.write(sql);
            util.conn.commit();
            runLabTest=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return runLabTest;
    }

    //patient pay for services
    public boolean pay(Payment p) {
        boolean paid=false;
        try {
            String s="insert into payment(patientid,service,amount)values ('"+p.getP()+"','"+p.getS()+"',"+p.getAmount()+")";
            util.write(s);
            util.conn.commit();
            paid=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paid;
    }

    //dispense drug
    public boolean dispenseDrug(Patient p, ArrayList<Medicine> medicines) {
        int k=0;
        String sql="insert into pharmacy (patientId,medicine) values("+p.getPid()+"'"+medicines+"')";
        k=util.write(sql);
        if(k<0){
            return  false;
        }
return true;
    }

    //arrayList of available medicine
    public void createArrayListOfMedicine(){
        ArrayList<Medicine>medicines=new ArrayList<Medicine>();
        for (int i=0;i<500;i++){
            Medicine m=new Medicine();
            medicines.add(m);
        }

    }

}
