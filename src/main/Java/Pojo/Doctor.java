package Pojo;

/**
 * Created by SELPHA on 14/2/2018.
 */
public class Doctor {
    String fname;
    String sname;
    String Did;

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

    public String getDid() {
        return Did;
    }

    public void setDid(String did) {
        Did = did;
    }

    @Override
    public String toString() {
        return this.Did;
    }
}
