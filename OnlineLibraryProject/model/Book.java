package OnlineLibraryProject.model;

import OnlineLibraryProject.enumFiles.BookTypes;

import java.util.Objects;

public abstract class Book {
    private String title;
    private String genre;
    private String lang;
    private String author;
    private BookTypes type;
    private int rating;



    public Book(BookTypes type, String title, String genre, String lang, String author, int rating) {
        this.type = type;
        setTitle(title);
        setAuthor(author);
        setGenre(genre);
        setLang(lang);
        setRating(rating);

    }
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if(rating > 5)
            this.rating = 5;
        else
            this.rating = rating;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getTitle().equals(book.getTitle()) &&
                getAuthor().equals(book.getAuthor()) &&
                type.equals(book.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getAuthor(), type);
    }
}
