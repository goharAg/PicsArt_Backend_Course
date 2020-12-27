package OnlineLibraryProject.service;

import OnlineLibraryProject.model.AudioBook;
import OnlineLibraryProject.model.Book;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class AudioBookService {
    private static final String url = "/home/gohar/Desktop/PicsArt_Backend_Course/OnlineLibraryProject/files/audiobookFile";
    FileService fs = new FileService();
    HashSet<Book> allAudioBooks;

    public AudioBookService(){
        allAudioBooks = new HashSet<>();
        updateAudioBooks();
    }


    public AudioBook create(String title, String author, String genre, String lang, String nar, int len) {
        AudioBook ab = new AudioBook(title, author, genre, lang, nar, len);
        System.out.println("AudioBook is created");
        return ab;
    }


    public AudioBook create() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input title: ");
        String title = sc.nextLine();
        System.out.println(" title: " + title);

        System.out.print("\nInput author: ");
        String author = sc.nextLine();
        System.out.println(" author: " + author);

        System.out.print("\nInput genre: ");
        String genre = sc.nextLine();
        System.out.println("genre: " + genre);

        System.out.print("\nInput narrator: ");
        String nar = sc.nextLine();
        System.out.println("narrator: " + nar);
        System.out.print("\nInput language: ");
        String lang = sc.next();
        System.out.println("language: " + lang);
        sc.nextLine();
        System.out.print("\nInput length: ");
        int len = sc.nextInt();
        System.out.println("length: " + len);

        AudioBook ab = create(title, author, genre, lang, nar, len);
        fs.write(Paths.get(url), ab);
        allAudioBooks.add(ab);
        return ab;
    }

    public AudioBook create(String[] stringParts) {
        AudioBook ab = create(stringParts[0], stringParts[1], stringParts[2], stringParts[3], stringParts[4], Integer.parseInt(stringParts[5]));
        return ab;
    }

    public void updateAudioBooks()  {
        List<String> l;
        try{
            l = fs.read(Paths.get(url));
        }catch(IOException e){
            return;
        }

        for(String s : l){
            String[] stringParts = s.split("[,]");
            allAudioBooks.add(create(stringParts));
        }
    }

    public void printFullInfo(AudioBook ab) {
        System.out.print(ab.getTitle() + " ");
        System.out.print("by " + ab.getAuthor());
        System.out.print(" : " + ab.getGenre());
        System.out.print(" in " + ab.getLang());
        System.out.print("Length " + ab.getLength() + " read by " + ab.getNarrator() + "\n");

    }

    public void printShortInfo(AudioBook ab) {
        System.out.print(ab.getTitle() + " ");
        System.out.print("by " + ab.getAuthor() + "\n");
    }

    public HashSet<Book> allAudioBooks() {
        return allAudioBooks;

    }


}
