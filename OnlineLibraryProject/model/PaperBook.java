package OnlineLibraryProject.model;

import java.util.Date;

public class PaperBook extends Book{

    private String publishingCompany;

    public PaperBook(String title,String author ,  String genre, String lang,  String pubComp) {
        super("PaperBook",title, genre, lang, author);

        setPublishingCompany(pubComp);
    }



    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }


}
