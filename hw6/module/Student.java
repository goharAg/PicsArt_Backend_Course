package hw6.module;

public class Student {
    private String firstName;
    private String lastName;
    private int year;
    private String gender;
    private double mark;

//    public Student(String firstName, String lastName, int year, String gender, double mark) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.year = year;
//        this.gender = gender;
//        this.mark = mark;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}
