package OnlineLibraryProject.service;


import OnlineLibraryProject.model.Book;
import OnlineLibraryProject.model.PaperBook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class PaperBookService {
    private static final String url = "/home/gohar/Desktop/PicsArt_Backend_Course/OnlineLibraryProject/files/paperbookFile";
    private HashSet<Book> allPaperBooks;
    private FileService fs = new FileService();

    public PaperBookService(){
        allPaperBooks = new HashSet<>();
    }


    public PaperBook createPaperBook(String title, String author,String genre, String lang,String pubComp)  {
        PaperBook ab = new PaperBook(title,author,genre,lang, pubComp);
        return ab;
    }



    public PaperBook createPaperBook()  {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input title: ");
        String title = sc.nextLine();

        System.out.print("\nInput author: ");
        String author = sc.nextLine();

        System.out.print("\nInput genre: ");
        String genre = sc.next();
        sc.nextLine();

        System.out.print("\nInput language: ");
        String lang = sc.next();
        sc.nextLine();
        System.out.print("\nInput publishing company: ");
        String format = sc.nextLine();
        sc.nextLine();
        PaperBook ab = createPaperBook(title,author,genre,lang,format  );
        fs.write(Paths.get(url), ab);
        return ab;
    }

    public PaperBook createPaperBook(String[] stringParts)  {
        PaperBook ab = createPaperBook(stringParts[0],stringParts[1],stringParts[2],stringParts[3],stringParts[4]);
        return ab;

    }

    public void updatePaperBooks()  {
        List<String> l;
        try{
            l = fs.read(Paths.get(url));
        }catch(IOException e){
            return;
        }

        for(String s : l){
            String[] stringParts = s.split("[,]");
            allPaperBooks.add(createPaperBook(stringParts));
        }
    }



    public void printFullInfo(PaperBook ab){
        System.out.print(ab.getTitle() + " " );
        System.out.print("by " + ab.getAuthor());
        System.out.print(" : " + ab.getGenre());
        System.out.print(" in " + ab.getLang());
        System.out.print(" Format:  " + ab.getPublishingCompany() + "\n");


    }

    public void printShortInfo(PaperBook ab){
        System.out.print(ab.getTitle() + " " );
        System.out.print("by " + ab.getAuthor() + "\n");
    }

    public HashSet<Book> allPaperBooks()  {
       return allPaperBooks;

    }





}
