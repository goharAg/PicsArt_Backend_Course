package OnlineLibraryProject.test;

import OnlineLibraryProject.service.Catalog;

import java.io.IOException;
import java.util.Scanner;

public class LibraryTest {
    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        Catalog ct = new Catalog();
        boolean quit = false;
        while(!quit) {
            System.out.println("1. Show All Books");
            System.out.println("2. Show Only AudioBooks");
            System.out.println("3. Show Only EBooks");
            System.out.println("4. Show Only PaperBooks");
            System.out.println("5. Add a Book");
            System.out.println("6. Search a book");
            System.out.println("7. Quit");


            int num = sc.nextInt();

            switch (num) {
                case 1:
                    ct.viewCatalog();
                    break;
                case 2:
                    ct.showAudioBooks();
                    break;
                case 3:
                    ct.showEBooks();
                    break;
                case 4:
                    ct.showPaperBooks();
                    break;
                case 5:
                    boolean answeredCorrectly = false;
                    String type = "";
                    while (!answeredCorrectly) {

                        System.out.println("Type which kind of book do you wan to add?");
                        System.out.println("1. AudioBook");
                        System.out.println("2. Ebook");
                        System.out.println("3. PaperBook");

                        int n = sc.nextInt();

                        if(n == 1)
                        {
                            System.out.println("1");
                            type = "AudioBook";
                            answeredCorrectly = true;
                            ct.addBook(type);
                        }
                        else if(n == 2){
                            type = "Ebook";
                            answeredCorrectly = true;
                            ct.addBook(type);
                        }
                        else if(n == 3){
                            type = "PaperBook";
                            answeredCorrectly = true;
                            ct.addBook(type);
                        }
                        else{
                            System.out.println("Else"+ n);
                        }
                    }


                    break;

                case 6:
                    boolean rightInput = false;
                    while (!rightInput) {
                        System.out.println("Do you want to search the book by");
                        System.out.println("1. title ");
                        System.out.println("2. author");
                        System.out.println("3. genre");
                        int nn = sc.nextInt();
                        if(nn == 1){
                             sc.nextLine();
                            System.out.print("Type title :");
                            String title = sc.nextLine();
                            ct.searchByTitle(title);
                            rightInput = true;

                        }
                        else if(nn == 2){
                             sc.nextLine();
                            System.out.print("Type author :");
                            String author = sc.nextLine();
                            ct.searchByAuthor(author);

                            rightInput = true;
                        }
                        else if(nn == 3){
                           sc.nextLine();
                            System.out.print("Type genre :");
                            String genre = sc.nextLine();
                            ct.searchByGenre(genre);
                            rightInput = true;

                        }

                    }


                    break;
                case 7:
                    quit = true;


            }
        }



    }
}