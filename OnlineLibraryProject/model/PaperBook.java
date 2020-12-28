package OnlineLibraryProject.model;

import OnlineLibraryProject.enumFiles.BookTypes;

import java.util.Date;

public class PaperBook extends Book{

    private String publishingCompany;

    public PaperBook(String title,String author ,  String genre, String lang,  String pubComp,int rate) {
        super(BookTypes.PAPERBOOK,title, genre, lang, author,rate);

        setPublishingCompany(pubComp);
    }



    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }


}
