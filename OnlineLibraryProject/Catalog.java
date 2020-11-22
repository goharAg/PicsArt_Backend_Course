package OnlineLibraryProject;

public class Catalog implements Search{
    // To be made an ArrayList later

    BookItem[] array = new BookItem[10];

    public void viewCatalog(){

    }

    public void addBook(BookItem b){ }

    public void removeBook(BookItem b){}

    @Override
    public BookItem searchByTitle() {
        return null;
    }

    @Override
    public BookItem searchByAuthor() {
        return null;
    }

    @Override
    public BookItem searchByGenre() {
        return null;
    }
}
