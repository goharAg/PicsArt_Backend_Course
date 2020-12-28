package OnlineLibraryProject.test;

import OnlineLibraryProject.service.Catalog;
import OnlineLibraryProject.service.UserService;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.SocketHandler;

public class LibraryTest {
    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        Catalog ct = new Catalog();
        UserService us = new UserService();
        boolean quit = false;
        boolean loggedIn = false;

        while(!loggedIn){
            System.out.println("Welcome to to your Online Library. ");
            System.out.println("1. Log In");
            System.out.println("2. Register");

            int choice = sc.nextInt();

            switch (choice){
                case 1:
                        loggedIn = us.login();
                    break;
                case 2:
                    us.register();

                    break;

            }
        }

        if (loggedIn) {
            while (!quit) {
                System.out.printf("%10s%n","MENU");
                System.out.println("1. Show All Books");
                System.out.println("2. Show Only AudioBooks");
                System.out.println("3. Show Only EBooks");
                System.out.println("4. Show Only PaperBooks");
                System.out.println("5. Add a Book");
                System.out.println("6. Search a book");
                System.out.println("7. Sort Books");
                System.out.println("8. Quit");


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
                            System.out.println("4. Back");

                            int n = sc.nextInt();

                            if (n == 1) {

                                type = "AudioBook";
                                answeredCorrectly = true;
                                ct.addBook(type);
                            } else if (n == 2) {
                                type = "Ebook";
                                answeredCorrectly = true;
                                ct.addBook(type);
                            } else if (n == 3) {
                                type = "PaperBook";
                                answeredCorrectly = true;
                                ct.addBook(type);
                            }
                            else if (n == 4) {
                                answeredCorrectly = true;
                            }else {
                                System.out.println("Else" + n);
                            }
                        }
                        break;

                    case 6:
                        boolean rightInput = false;
                        while (!rightInput) {
                            System.out.println("Do you want to search the book by");
                            System.out.println("1. Title ");
                            System.out.println("2. Author");
                            System.out.println("3. Genre");
                            int nn = sc.nextInt();
                            if (nn == 1) {
                                sc.nextLine();
                                System.out.print("Type title :");
                                String title = sc.nextLine();
                                ct.searchByTitle(title);
                                rightInput = true;

                            } else if (nn == 2) {
                                sc.nextLine();
                                System.out.print("Type author :");
                                String author = sc.nextLine();
                                ct.searchByAuthor(author);

                                rightInput = true;
                            } else if (nn == 3) {
                                sc.nextLine();
                                System.out.print("Type genre :");
                                String genre = sc.nextLine();
                                ct.searchByGenre(genre);
                                rightInput = true;

                            }

                        }
                        break;
                    case 7:
                        boolean numChoice = false;
                        while (!numChoice) {
                            System.out.println("Do you want to sort the book by");
                            System.out.println("1. Title ");
                            System.out.println("2. Author");

                            int nch = sc.nextInt();
                            if (nch == 1) {
                                ct.sortByTitle();
                                numChoice = true;

                            } else if (nch == 2) {
                                ct.sortByAuthor();
                                numChoice = true;
                            }
                        }
                        break;
                    case 8:
                        quit = true;

                }
            }


        }
    }
}
