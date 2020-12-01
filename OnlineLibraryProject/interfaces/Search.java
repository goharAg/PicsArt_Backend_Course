package OnlineLibraryProject.interfaces;

import OnlineLibraryProject.model.Book;

public interface Search {

    public void searchByTitle(String title);

    public void searchByAuthor(String author);

    public void searchByGenre(String genre);

}
