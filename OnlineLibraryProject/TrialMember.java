package OnlineLibraryProject;

import java.util.Date;

public class TrialMember extends Account {


    private Date timeLeft;

    private Date startDate;

    public Date getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(Date timeLeft) {
        this.timeLeft = timeLeft;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void endTrial(){

    }

}
