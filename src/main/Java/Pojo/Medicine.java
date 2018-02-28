package Pojo;

import java.util.Date;

/**
 * Created by SELPHA on 14/2/2018.
 */
public class Medicine {
    String name;
    Date yom;
    int ageLimit;
    int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getYom() {
        return yom;
    }

    public void setYom(Date yom) {
        this.yom = yom;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
