package OnlineLibraryProject.service;

import OnlineLibraryProject.model.AudioBook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class AudioBookService {
    private static final String url = "/home/gohar/Desktop/PicsArt_Backend_Course/OnlineLibraryProject/files/audiobookFile";

    public AudioBook createAB(String title, String author,String genre, String lang, String nar, int len  )  {
        AudioBook ab = new AudioBook(title,author,genre,lang,nar,len );


        System.out.println("AudioBook is created");
        return ab;
    }

    public AudioBook createAndWriteAB(String title, String author,String genre, String lang, String nar, int len  )  {
        AudioBook ab = new AudioBook(title,author,genre,lang,nar,len );
        writeAudioBook(ab);


        return ab;
    }

    public AudioBook createAB()  {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input title: ");
        String title = sc.nextLine();
        System.out.println(" title: " + title);

        System.out.print("\nInput author: ");
        String author = sc.nextLine();
        System.out.println(" author: " + author);

        System.out.print("\nInput genre: " );
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
        System.out.println("length: "+len);

        AudioBook ab = createAndWriteAB(title,author,genre,lang,nar,len  );
        return ab;
    }

    public AudioBook createAB(String[] stringParts)  {
        AudioBook ab = createAB(stringParts[0],stringParts[1],stringParts[2],stringParts[3],stringParts[4],Integer.parseInt(stringParts[5]));

        return ab;

    }

    public void writeAudioBook( AudioBook ab)  {
        Path p = Paths.get(url);
        String fileText = ab.getTitle() +","+ab.getAuthor()+","+ab.getGenre()+","+ab.getLang()+","+ab.getNarrator()+","+ab.getLength()+"\n" ;
       try {
           Files.write(p, fileText.getBytes(), StandardOpenOption.APPEND);
       }catch(IOException e){

       }


    }
    public void clearFile(){
        Path p = Paths.get(url);
        String fileText = "" ;
        try {
            Files.write(p, fileText.getBytes());
        }
        catch(IOException e){

        }
    }

    public void writeAudioBooks( AudioBook[] ab) {
      for(int i = 0; i < ab.length;i++){
          writeAudioBook(ab[i]);
      }
    }

    private AudioBook[] fetchAB() {

        Path p = Paths.get(url);
        String[] strings;
        try {
            strings = Files.readAllLines(p).toArray(new String[0]);
        }catch(IOException e){
            strings = new String[0];
        }
        AudioBook[] audioBArray = new AudioBook[strings.length];



        for(int j = 0; j< strings.length; j++){
            String[] stringParts = strings[j].split("[,]");
            AudioBook ab = createAB(stringParts);
            audioBArray[j] = ab;

        }

        return audioBArray;
    }

    public void printFullInfo(AudioBook ab){
        System.out.print(ab.getTitle() + " " );
        System.out.print("by " + ab.getAuthor());
        System.out.print(" : " + ab.getGenre());
        System.out.print(" in " + ab.getLang());
        System.out.print("Length " + ab.getLength() + " read by " + ab.getNarrator() + "\n");

    }

    public void printShortInfo(AudioBook ab){
        System.out.print(ab.getTitle() + " " );
        System.out.print("by " + ab.getAuthor() + "\n");
    }

    public AudioBook[] allAudioBooks()  {
        AudioBook[] ab = fetchAB();
        return ab;

    }





}
