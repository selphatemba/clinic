package test.java;

import Entities.Payment;
import main.Java.Bean.BeanImplementation.AdminBean;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdminBeanTest {
    Payment p;
    @Test
    public void payForServicesTest(){
        AdminBean adminBean=new AdminBean();
        boolean paid=adminBean.payForServices(p);
        assertEquals(true,paid);
    }
}
