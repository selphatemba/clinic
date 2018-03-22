package Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * Created by SELPHA on 22/3/2018.
 */
@Entity
public class Dispensation {
    @Id
    private int dispensationID;
    private String patientID;
    @Lob
    private String medicine;


    public int getDispensationID() {
        return dispensationID;
    }

    public void setDispensationID(int dispensationID) {
        this.dispensationID = dispensationID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }
}
