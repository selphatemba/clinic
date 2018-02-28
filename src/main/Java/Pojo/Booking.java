package Pojo;

import java.util.Date;

/**
 * Created by SELPHA on 14/2/2018.
 */
public class Booking {
    Doctor d;
    Patient p;
    Date bookingTime;

    public Doctor getD() {
        return d;
    }

    public void setD(Doctor d) {
        this.d = d;
    }

    public Patient getP() {
        return p;
    }

    public void setP(Patient p) {
        this.p = p;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }
}
