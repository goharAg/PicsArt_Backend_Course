package OnlineLibraryProject.model;

import java.util.Date;

public class Ebook  extends Book{
    private String format;





    public Ebook(String title,String author,String genre, String lang,  String format ){
        super(title, genre, lang, author);
        setFormat(format);


    }


    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }


}
