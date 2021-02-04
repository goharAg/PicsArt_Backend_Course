package hw3;

public class StudentAccountTest {
    public static void main(String[] args) {
        StudentAccount student1 = new StudentAccount("Gohar", "Aghajanyan", 123456, "Computer Science", 2023, 15);
        student1.addCourse(3);

        student1.getFullName();
        student1.coursesLeftToTake();


        StudentAccount student2 = new StudentAccount("Artur", "Simonyan", 1277568, "Engineering", 2024, 25);
        student2.addCourse(3);

        student2.getFullName();
        student2.getMajor();



    }
}
