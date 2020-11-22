package OnlineLibraryProject;

import java.util.Date;

public class PaidMember extends Account {

    private int fee;

    private int paid;

    private Date payDay;

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public Date getPayDay() {
        return payDay;
    }

    public void setPayDay(Date payDay) {
        this.payDay = payDay;
    }



    public void pay(int ammount){

    }
}
