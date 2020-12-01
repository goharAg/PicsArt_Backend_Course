package OnlineLibraryProject.model;

public abstract class Book {
    private String title;

    private String genre;
    private String lang;



    private String author;

    public Book(String title,  String genre, String lang, String author) {
        setTitle(title);
        setAuthor(author);
        setGenre(genre);
        setLang(lang);

    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }




}
