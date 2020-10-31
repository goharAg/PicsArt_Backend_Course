import java.util.Scanner;
public class Lesson2hw {
    public static void main(String[] args) {

        // Task1
        //Create an array and fill it with 2 number.
        int[] myArray  = {10, 5, 4, 3, 6, 7, 8};

        //Task2
        //Create an array and fill it with numbers from 1:1000.
        int[] numArray = new int[1000];
        for (int a = 1; a <= 1000 ; a++) {
            numArray[a-1] = a;
        }

        //Task3
        //Task3: Create an array and fill it with odd numbers from -20:20
        int[] oddNumArray = new int[20];
        for (int i = -19, j = 0; i < 20 ; i++, j+=2) {
            numArray[j] = i;
        }

        //Task4
        System.out.println("Task4: Create an array and fill it. Print all elements which can be divided by 5.");
        int[] numbers = {2, 4, 5, 10, 13, 15, 20, 21};
        for(int k = 0; k < numbers.length; k++){
            if(numbers[k] % 5 == 0){
                System.out.print(numbers[k]);
                System.out.print(" ");
            }
        }


        //Task5
        System.out.println("\nTask5: Create an array and fill it. Print all elements which are between 24.12 and 467.23. ");
        double[] doubleNumbers = {2.1, 48.7, 5, 100, 1334, 159.8, 206.98, 211.3};
        for(int f = 0; f < doubleNumbers.length; f++){
            if(numbers[f] > 24.12 && numbers[f] < 467.23){
                System.out.print(numbers[f]);
                System.out.print(" ");
            }
        }

        //Task6
        System.out.println("\nTask6: Create an array and fill it. Print count of elements which can be divided by 2.");
        int[] numbers6 = {2, 4, 5, 10, 14, 15, 20, 21};
        int count = 0;
        for(int l = 0; l < numbers.length; l++){
            if(numbers[l] % 2== 0){
                count++;
            }
        }
        System.out.println(count);

        //Task7
        System.out.println("Task7: Given an integer, 0< N < 21 , print its first\n" +
                "10 multiples.\n" +
                "\n" +
                "Each multiple N x i (where 0<i<11)\n" +
                "should be printed on a new line in the\n" +
                "form: N x i = result.");

        Scanner sc = new Scanner(System.in);
        System.out.println("Input the number between 0 and 21");
        int n = sc.nextInt();

        for(int h = 1; h<=10; h++){
            System.out.println( n + " * " + h + " = " + n*h);
        }






    }

}
