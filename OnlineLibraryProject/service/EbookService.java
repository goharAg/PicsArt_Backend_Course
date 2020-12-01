package OnlineLibraryProject.service;

import OnlineLibraryProject.model.Ebook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class EbookService {
    private static final String url = "/home/gohar/Desktop/PicsArt_Backend_Course/OnlineLibraryProject/service/ebookFile";

    public Ebook createEbook(String title, String author,String genre, String lang,String format)  {
        Ebook ab = new Ebook(title,author,genre,lang, format);

        return ab;
    }

    public Ebook createAndWriteEbook(String title, String author,String genre, String lang,String format)  {
        Ebook ab = new Ebook(title,author,genre,lang, format);
        writeEbook(ab);
        return ab;
    }

    public Ebook createEbook(){
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

        Ebook ab = createAndWriteEbook(title,author,genre,lang,format  );
        return ab;
    }

    public Ebook createEbook(String[] stringParts)  {
        Ebook ab = createEbook(stringParts[0],stringParts[1],stringParts[2],stringParts[3],stringParts[4]);

        return ab;

    }

    public void writeEbook( Ebook ab)  {
        Path p = Paths.get(url);
        String  fileText = ab.getTitle() + "," + ab.getAuthor() + "," + ab.getGenre() + "," + ab.getLang() + "," + ab.getFormat() + "\n";
        try {
            Files.write(p, fileText.getBytes(), StandardOpenOption.APPEND);
        }catch(IOException e){
            return ;
        }



    }

    public void writeEbooks( Ebook[] ab){
        for(int i = 0; i < ab.length;i++){
            writeEbook(ab[i]);
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

    private Ebook[] fetchAB()  {

        Path p = Paths.get(url);
        String[] strings;
        try {
             strings = Files.readAllLines(p).toArray(new String[0]);
        }catch(IOException e){
            strings = new String[0];
        }
        Ebook[] audioBArray = new Ebook[strings.length];



        for(int j = 0; j< strings.length; j++){
            String[] stringParts = strings[j].split("[,]");
            Ebook ab = createEbook(stringParts);
            audioBArray[j] = ab;

        }

        return audioBArray;
    }

    public void printFullInfo(Ebook ab){
        System.out.print(ab.getTitle() + " " );
        System.out.print("by " + ab.getAuthor());
        System.out.print(" : " + ab.getGenre());
        System.out.print(" in " + ab.getLang());
        System.out.print(" Format:  " + ab.getFormat() + "\n");


    }

    public void printShortInfo(Ebook ab){
        System.out.print(ab.getTitle() + " " );
        System.out.print("by " + ab.getAuthor() + "\n");
    }



    public Ebook[] allEbooks() {
        Ebook[] ab = fetchAB();
        return ab;

    }





}
