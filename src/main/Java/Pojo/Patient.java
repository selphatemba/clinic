package Pojo;

/**
 * Created by SELPHA on 14/2/2018.
 */
public class Patient {
    private String fname;
    private String sname;
    private int IDnumber;
    private String Pid;

    public int getIDnumber() {
        return IDnumber;
    }

    public void setIDnumber(int IDnumber) {
        this.IDnumber = IDnumber;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPid() {
        return Pid;
    }

    public void setPid(String pid) {
        Pid = pid;
    }

    @Override
    public String toString() {
        return this.Pid;
    }
}
