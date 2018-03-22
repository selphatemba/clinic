package Entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by SELPHA on 22/3/2018.
 */
@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int consultationID;
    private String doctorID;
    private  String patientID;
    private Date consultationTime;
    private String requireLabTest;
    @Lob
    private String doctorNotes;

    public String getDoctorNotes() {
        return doctorNotes;
    }

    public void setDoctorNotes(String doctorNotes) {
        this.doctorNotes = doctorNotes;
    }

    public int getConsultationID() {
        return consultationID;
    }

    public void setConsultationID(int consultationID) {
        this.consultationID = consultationID;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public Date getConsultationTime() {
        return consultationTime;
    }

    public void setConsultationTime(Date consultationTime) {
        this.consultationTime = consultationTime;
    }

    public String getRequireLabTest() {
        return requireLabTest;
    }

    public void setRequireLabTest(String requireLabTest) {
        this.requireLabTest = requireLabTest;
    }


}

