package OnlineLibraryProject.service;

import OnlineLibraryProject.model.Book;
import OnlineLibraryProject.model.Ebook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class EbookService extends Service {
    private static final String url = "/home/gohar/Desktop/PicsArt_Backend_Course/OnlineLibraryProject/files/ebookFile";
    HashSet<Book> allEBooks;
    FileService fs = new FileService();

    public EbookService(){
        allEBooks = new HashSet<Book>();
        updateEBooks();
    }


    public Ebook createEbook(String title, String author,String genre, String lang,String format)  {
        return new Ebook(title,author,genre,lang, format);
    }

    public Ebook create(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input title: ");
        String title = sc.nextLine();
        sc.nextLine();
        System.out.print("\nInput author: ");
        String author = sc.nextLine();
        sc.nextLine();
        System.out.print("\nInput genre: ");
        String genre = sc.next();
        sc.nextLine();

        System.out.print("\nInput language: ");
        String lang = sc.next();
        sc.nextLine();
        System.out.print("\nInput format: ");
        String format = sc.next();

        Ebook ab = createEbook(title,author,genre,lang,format  );
        fs.write(Paths.get(url), ab);
        allEBooks.add(ab);
        return ab;
    }

    public Ebook createEbook(String[] stringParts)  {
        return createEbook(stringParts[0],stringParts[1],stringParts[2],stringParts[3],stringParts[4]);
    }

    public void updateEBooks()  {
        List<String> l;
        try{
            l = fs.read(Paths.get(url));
        }catch(IOException e){
            return;
        }

        for(String s : l){
            String[] stringParts = s.split("[,]");
            allEBooks.add(createEbook(stringParts));
        }
    }



    public void printFullInfo(Book abb){
        Ebook ab = (Ebook) abb;
        System.out.print(ab.getTitle() + " " );
        System.out.print("by " + ab.getAuthor());
        System.out.print(" : " + ab.getGenre());
        System.out.print(" in " + ab.getLang());
        System.out.print(" Format:  " + ab.getFormat() + "\n");


    }
    public HashSet<Book> allBooks() {
        return allEBooks;
    }

}
