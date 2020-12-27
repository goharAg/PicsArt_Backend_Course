package OnlineLibraryProject.service;


import OnlineLibraryProject.model.PaperBook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class PaperBookService {
    private static final String url = "/home/gohar/Desktop/PicsArt_Backend_Course/OnlineLibraryProject/files/paperbookFile";

    public PaperBook createPaperBook(String title, String author,String genre, String lang,String pubComp)  {
        PaperBook ab = new PaperBook(title,author,genre,lang, pubComp);

        return ab;
    }

    public PaperBook createAndWritePaperBook(String title, String author,String genre, String lang,String pubComp)  {
        PaperBook ab = new PaperBook(title,author,genre,lang, pubComp);
        writePaperBook(ab);
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
        PaperBook ab = createAndWritePaperBook(title,author,genre,lang,format  );
        return ab;
    }

    public PaperBook createPaperBook(String[] stringParts)  {
        PaperBook ab = createPaperBook(stringParts[0],stringParts[1],stringParts[2],stringParts[3],stringParts[4]);

        return ab;

    }

    public void writePaperBook( PaperBook ab)  {
        Path p = Paths.get(url);
        String fileText = ab.getTitle() +","+ab.getAuthor()+","+ab.getGenre()+","+ab.getLang()+","+ab.getPublishingCompany()+"\n" ;
        try {
            Files.write(p, fileText.getBytes(), StandardOpenOption.APPEND);
        }catch(IOException e){
            System.out.println("IOException");
            return ;
        }


    }

    public void writePaperBooks( PaperBook[] ab)  {
        for(int i = 0; i < ab.length;i++){
            writePaperBook(ab[i]);
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

    private PaperBook[] fetchAB()  {

        Path p = Paths.get(url);
        String[] strings;
        try {
            strings = Files.readAllLines(p).toArray(new String[0]);
        }catch(IOException e){
            strings = new String[0];
        }
        PaperBook[] audioBArray = new PaperBook[strings.length];



        for(int j = 0; j< strings.length; j++){
            String[] stringParts = strings[j].split("[,]");
            PaperBook ab = createPaperBook(stringParts);
            audioBArray[j] = ab;

        }

        return audioBArray;
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

    public PaperBook[] allPaperBooks()  {
        PaperBook[] ab = fetchAB();
        return ab;

    }





}
