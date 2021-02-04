package hw6.test;


import hw6.module.Student;
import hw6.service.StudentService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class FileReader {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String texturl = sc.next();
        Path p = Paths.get(texturl);

      String[] strings =   Files.readAllLines(p).toArray(new String[0]);
      Student[] studentArray = new Student[strings.length];

        StudentService ss = new StudentService();

      for(int j = 0; j< strings.length; j++){
          String[] stringParts = strings[j].split("[,]");
            Student st = ss.createStudent(stringParts);
            studentArray[j] = st;

      }

      ss.printFullInfo(studentArray[0]);
      ss.biggestMaleStudent(studentArray);
      ss.femaleStudents50Plus(studentArray);
      ss.printFemaleSortedByYear(studentArray);
      ss.printsortedByMark(studentArray);
      ss.minMarkStudent(studentArray);
      ss.maleStudents(studentArray);

    }

}
