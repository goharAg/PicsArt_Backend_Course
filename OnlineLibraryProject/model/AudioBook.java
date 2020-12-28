package OnlineLibraryProject.model;

import OnlineLibraryProject.enumFiles.BookTypes;

import java.util.Date;

public class AudioBook extends Book {
    private String narrator;
    private double length;




    public AudioBook(String title,String author,  String genre, String lang, String nar, double len,int rate ){
        super(BookTypes.AUDIOBOOK,title, genre, lang, author,rate);
        setNarrator(nar);
        setLength(len);

    }


    public String getNarrator() {
        return narrator;
    }

    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }


}
