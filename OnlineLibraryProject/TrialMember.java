package OnlineLibraryProject;

import java.util.Date;

public class TrialMember extends Account implements UserFunctionality {


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

    @Override
    public void register() {

    }

    @Override
    public void login() {

    }

    @Override
    public void logout() {

    }

    @Override
    public void renewBook(BookItem b) {

    }

    @Override
    public void reserveBook(BookItem b) {

    }

    @Override
    public void returnBook(BookItem b) {

    }
}
