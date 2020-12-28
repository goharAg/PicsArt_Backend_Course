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

public class PaperBookService extends Service {
    private static final String url = "OnlineLibraryProject/files/paperbookFile";
    private HashSet<Book> allPaperBooks;
    private FileService fs = new FileService();

    public PaperBookService(){
        allPaperBooks = new HashSet<>();
        updatePaperBooks();
    }


    public PaperBook createPaperBook(String title, String author,String genre, String lang,String pubComp)  {
        PaperBook ab = new PaperBook(title,author,genre,lang, pubComp);
        return ab;
    }



    public PaperBook create()  {
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
            if(s.isEmpty())
                continue;
            String[] stringParts = s.split("[,]");

            allPaperBooks.add(createPaperBook(stringParts));
        }
    }



    public void printFullInfo(Book abb){
        PaperBook ab = (PaperBook) abb;
        System.out.printf("Title: %s  Author: %s Genre: %s in %s . Publishing company: %s %n",
                ab.getTitle(),ab.getAuthor(),ab.getGenre(),ab.getLang(),ab.getPublishingCompany());



    }



    public HashSet<Book> allBooks()  {
       return allPaperBooks;

    }





}
