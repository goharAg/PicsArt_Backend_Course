package OnlineLibraryProject.service;

import OnlineLibraryProject.model.AudioBook;
import OnlineLibraryProject.model.Book;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class AudioBookService extends Service {
    private static final String url = "OnlineLibraryProject/files/audiobookFile";
    FileService fs = new FileService();
    HashSet<Book> allAudioBooks;

    public AudioBookService(){
        allAudioBooks = new HashSet<>();
        updateAudioBooks();
    }


    public AudioBook create(String title, String author, String genre, String lang, String nar, double len,int rate) {
        AudioBook ab = new AudioBook(title, author, genre, lang, nar, len, rate);

        return ab;
    }


    public AudioBook create() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input title: ");
        String title = sc.nextLine();


        System.out.print("Input author: ");
        String author = sc.nextLine();


        System.out.print("Input genre: ");
        String genre = sc.nextLine();


        System.out.print("Input narrator: ");
        String nar = sc.nextLine();

        System.out.print("Input language: ");
        String lang = sc.next();

        System.out.println("Input with hours, e.g 1, 2.5, 3.6 ...");
        System.out.print("Input length: ");
        double len = sc.nextDouble();

        System.out.println("Out of 5 stars ");
        System.out.print("Input rating: ");
        int rate = sc.nextInt();


        AudioBook ab = create(title, author, genre, lang, nar, len,rate);
        fs.write(Paths.get(url), ab);
        allAudioBooks.add(ab);
        return ab;
    }

    public AudioBook create(String[] stringParts) {
        AudioBook ab = create(stringParts[0], stringParts[1], stringParts[2], stringParts[3], stringParts[4], Double.parseDouble(stringParts[5]), Integer.parseInt(stringParts[6]));
        return ab;
    }

    public void updateAudioBooks()  {
        List<String> l = new ArrayList<>();
        try{
            l = fs.read(Paths.get(url));
        }catch(IOException e){
            return;
        }

        for(String s : l){
            if(s.isEmpty())
                continue;

            String[] stringParts = s.split("[,]");
            allAudioBooks.add(create(stringParts));
        }
    }

    public void printFullInfo(Book abb) {
        AudioBook ab = (AudioBook) abb;
        System.out.printf("Title: %s  Author: %s Genre: %s in %s . Length: %s hour, read by : %s %d/5 %n",
                ab.getTitle(),ab.getAuthor(),ab.getGenre(),ab.getLang(),ab.getLength(), ab.getNarrator(),ab.getRating());


    }


    public HashSet<Book> allBooks() {
        return allAudioBooks;

    }


}
