package hw6.service;


import hw6.module.Student;

public class StudentService {

    //Task1: Print full names of students
    public void fullName(Student s1){
        System.out.println(s1.getFirstName() + " " + s1.getLastName());

    }

    public Student createStudent(String[] stringParts){
        Student st = new Student();
        st.setFirstName(stringParts[0]);
        st.setLastName(stringParts[1]);
        st.setYear(Integer.parseInt(stringParts[2]));
        st.setGender(stringParts[3]);
        st.setMark(Double.parseDouble(stringParts[4]));
        return st;

    }
    public void printFullInfo(Student s1){

        System.out.print(s1.getFirstName() + " " + s1.getLastName()+ " ");
        System.out.print(" Year: " + s1.getYear());
        System.out.print(" Gender: " + s1.getGender());
        System.out.print(" Mark: " + s1.getMark() + "\n");

    }



    //Task 2: Print all male students
    public void maleStudents(Student[] array){

        System.out.println("////// Printing Male Students //////");
        for(Student s : array){
            if(s.getGender().equals("m")){
                fullName(s);
            }
        }
    }

    //Task 3: Print all female students who has mark greater then 50.4
    public void femaleStudents50Plus(Student[] array){

        System.out.println("////// Printing Female Students who got higher than 50.4 //////");
        for(Student s : array){
            if(s.getGender().equals("f") && s.getMark() > 50.4){
                fullName(s);
            }
        }
    }

    //Task 4: Print student information having the minimal mark
    public void minMarkStudent(Student[] array){
        Student minMarkStudent = array[0];
        System.out.println("////// Student having minimum grade //////");
        for(Student s : array){
            if( s.getMark() < minMarkStudent.getMark()){
                minMarkStudent = s;
            }
        }
        printFullInfo(minMarkStudent);


    }

    //Task 5: Print biggest male student information
    public void biggestMaleStudent(Student[] array){
        Student biggestMale = null;


        for(Student s : array){
            if( s.getGender().equals("m")){
                biggestMale = s;
                break;
            }
        }
        if (biggestMale != null) {
            for (Student s : array) {
                if (s.getYear() > biggestMale.getYear() && s.getGender().equals("m")) {
                        biggestMale = s;
                }
            }
            System.out.println("//// Biggest Male Student//////");
            printFullInfo(biggestMale);
        }
        else{
            System.out.println("There is no male student");
        }



    }

    public static void sortByMark(Student[] array){

        int len = array.length;
        for(int i = 0; i < len-1; i++ ){
            boolean swapped = false;
            for(int j = 0; j < len-i-1; j++){
                 if(array[j].getMark() < array[j+1].getMark()){
                    Student temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapped = true;
                 }
           }
           if(!swapped){
              break;
           }

       }

    }
    public static void sortByYear(Student[] array){

        int len = array.length;
        for(int i = 0; i < len-1; i++ ){
            boolean swapped = false;
            for(int j = 0; j < len-i-1; j++){
                if(array[j].getYear() > array[j+1].getYear()){
                    Student temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }

        }

    }


    //Task 6: Print students sorted by mark

    public void printsortedByMark(Student[] array){
        sortByMark(array);
        System.out.println("///// Students sorted by Marks//////");
        for(Student x: array){
            printFullInfo(x);

        }

    }

    //Task 7: Print female students sorted by year

    public void printFemaleSortedByYear(Student[] array){

        sortByMark(array);
        System.out.println("///// Female Students sorted by Year//////");
        for(Student x: array){
            if(x.getGender().equals("f")) {
                printFullInfo(x);
            }

        }

    }


}
