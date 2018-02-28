package Pojo;

/**
 * Created by SELPHA on 14/2/2018.
 */
public class Payment {
    Patient p;
    Service s;
    Double amount;

    public Patient getP() {
        return p;
    }

    public void setP(Patient p) {
        this.p = p;
    }

    public Service getS() {
        return s;
    }

    public void setS(Service s) {
        this.s = s;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
