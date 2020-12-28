package OnlineLibraryProject.model;

import OnlineLibraryProject.enumFiles.BookTypes;

import java.util.Date;

public class Ebook  extends Book{
    private String format;





    public Ebook(String title,String author,String genre, String lang,  String format,int rate ){
        super(BookTypes.EBOOK,title, genre, lang, author,rate);
        setFormat(format);


    }


    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }


}
