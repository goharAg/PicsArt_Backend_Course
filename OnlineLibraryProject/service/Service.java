package OnlineLibraryProject.service;

import OnlineLibraryProject.model.Book;
import OnlineLibraryProject.model.PaperBook;

import java.util.HashSet;

public abstract class Service {
    public abstract Book create();

    public abstract HashSet<Book> allBooks();
    public abstract void printFullInfo(Book b);

    public void printShortInfo(Book ab){
        System.out.print(ab.getTitle() + " " );
        System.out.print("by " + ab.getAuthor() + "\n");
    }
}
