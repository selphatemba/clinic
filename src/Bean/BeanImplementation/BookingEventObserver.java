package Bean.BeanImplementation;

import Entities.Booking;

import javax.enterprise.event.Observes;

/**
 * Created by SELPHA on 11/3/2018.
 */
public class BookingEventObserver {
    public void NotifyDoctor(@Observes Booking b){
        System.out.println("Doctor  "+b.getdID()+"you have a new booking");
    }
}
