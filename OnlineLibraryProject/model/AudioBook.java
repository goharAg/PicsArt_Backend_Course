package OnlineLibraryProject.model;

import java.util.Date;

public class AudioBook extends Book {
    private String narrator;
    private int length;


    public AudioBook(String title,String author,  String genre, String lang, String nar, int len ){
        super(title, genre, lang, author);
        setNarrator(nar);
        setLength(len);

    }



    public String getNarrator() {
        return narrator;
    }

    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }


}
