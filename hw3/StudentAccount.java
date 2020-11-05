package hw3;

public class StudentAccount {
    public int coursesNeededToGraduate = 40;
    private String name;
    private String surname;
    private int id;
    private String major;
    private int credits ;
    private int coursesTaken;
    private int year;

    private char gender;




    public StudentAccount(String name, String surname, int id, String major, int year, int coursesTaken ){
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.major = major;
        this.year = year;
        this.coursesTaken = coursesTaken;
    }

    public int  coursesLeftToTake(){
        return coursesNeededToGraduate - coursesTaken;
    }
    public void addCourse(int creditNum){
        coursesTaken++;
        credits+=creditNum;
    }



    public String getFullName(){
        return name + " " + surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCoursesTaken() {
        return coursesTaken;
    }

    public void setCoursesTaken(int coursesTaken) {
        this.coursesTaken = coursesTaken;
    }

    public int getCredits() {
        return credits;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
