package OnlineLibraryProject.service;

import OnlineLibraryProject.enumFiles.BookTypes;
import OnlineLibraryProject.interfaces.Search;
import OnlineLibraryProject.model.AudioBook;
import OnlineLibraryProject.model.Book;
import OnlineLibraryProject.model.Ebook;
import OnlineLibraryProject.model.PaperBook;

import java.util.*;


public class Catalog implements Search {



    private Service audioService = new AudioBookService();
    private Service ebService = new EbookService();
    private Service pbService = new PaperBookService();

    private int size = 0;

    private EnumMap<BookTypes, HashSet<Book>> allBooks;


    public Catalog()  {

    allBooks = new EnumMap<>(BookTypes.class);
    allBooks.put(BookTypes.AUDIOBOOK, audioService.allBooks());
    allBooks.put(BookTypes.EBOOK, ebService.allBooks());
    allBooks.put(BookTypes.PAPERBOOK, pbService.allBooks());

    }



    public void viewCatalog(){
        if(allBooks.get(BookTypes.AUDIOBOOK).size() == 0 && allBooks.get(BookTypes.EBOOK).size() == 0 && allBooks.get(BookTypes.PAPERBOOK).size() == 0){
            System.out.println("There are no books yet");
            return;
        }


        System.out.println("//// All Books ////");
        for(Book b: allBooks.get(BookTypes.AUDIOBOOK)){
            audioService.printShortInfo((AudioBook) b);
        }
        for(Book b: allBooks.get(BookTypes.EBOOK)){
            ebService.printShortInfo((Ebook) b);
        }
        for(Book b: allBooks.get(BookTypes.PAPERBOOK)){
            pbService.printShortInfo((PaperBook) b);
        }



    }

    private boolean isEmpty(){
        if(allBooks.get(BookTypes.AUDIOBOOK).size() == 0 && allBooks.get(BookTypes.EBOOK).size() == 0 && allBooks.get(BookTypes.PAPERBOOK).size() == 0){
            System.out.println("There are no books yet");
            return true;
        }
        else{
            return false;
        }

    }

    public void addBook(String kind)  {

            if(kind.equals("AudioBook")){
                addAudioBook();
            }
            if(kind.equals("Ebook")){
                addEBook();
            }
            if(kind.equals("PaperBook")){
                addPaperBook();
            }

    }



    public void showAll(){
        if(isEmpty()){
            System.out.println("There are no books yet");
            return;
        }
        showAudioBooks();
        showEBooks();
        showPaperBooks();

    }

    public void showAudioBooks(){

        System.out.println("/// AudioBooks////");

        if(allBooks.get(BookTypes.AUDIOBOOK).size() == 0){
            System.out.println("There are no Audiobooks");
            return;
        }
        for(Book b : allBooks.get(BookTypes.AUDIOBOOK)){
            audioService.printFullInfo((AudioBook)b);
        }

    }

    public void showEBooks(){
        System.out.println("//// Ebooks ////");

        if(allBooks.get(BookTypes.EBOOK).size() == 0){
            System.out.println("There are no Ebooks");
            return;
        }
        for(Book b : allBooks.get(BookTypes.EBOOK)){
            ebService.printFullInfo((Ebook)b);
        }

    }
    public void showPaperBooks(){

        System.out.println("//// Paper Books ////");
        if(allBooks.get(BookTypes.PAPERBOOK).size() == 0){
            System.out.println("There are no Paperbooks");
            return;
        }
        for(Book b : allBooks.get(BookTypes.PAPERBOOK)){
            pbService.printFullInfo((PaperBook)b);
        }

    }

    public void addAudioBook()  {
       Book ab = audioService.create();
        allBooks.get(BookTypes.AUDIOBOOK).add(ab);
        System.out.println("AudioBook added.");

    }



    public void addEBook()  {
        Book eb = ebService.create();
        allBooks.get(BookTypes.EBOOK).add(eb);
        System.out.println("Ebook added.");

    }
    public void addPaperBook()  {
        Book pb =pbService.create();
        allBooks.get(BookTypes.PAPERBOOK).add(pb);
        System.out.println("PaperBook added.");

    }

    public void updateAllBooks(){
        allBooks.replace(BookTypes.AUDIOBOOK, audioService.allBooks());
        allBooks.replace(BookTypes.EBOOK, ebService.allBooks());
        allBooks.replace(BookTypes.PAPERBOOK, pbService.allBooks());
    }
    private List<Book> getListOfBooks(){
        List<Book> bookList = new ArrayList<Book>() ;
        bookList.addAll(allBooks.get(BookTypes.AUDIOBOOK));
        bookList.addAll(allBooks.get(BookTypes.EBOOK));
        bookList.addAll(allBooks.get(BookTypes.PAPERBOOK));
        return bookList;
    }

    public List<Book> sortByTitle(){

        List<Book> bookList = getListOfBooks();
        Collections.sort(bookList, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareToIgnoreCase(b2.getTitle());
            }
        });

        for(Book b: bookList){
            printBookInfo(b);
        }

        return bookList;
    }
    public List<Book> sortByAuthor(){
        List<Book> bookList = getListOfBooks();
        Collections.sort(bookList, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getAuthor().compareToIgnoreCase(b2.getAuthor());
            }
        });

        for(Book b: bookList){
            printBookInfo(b);
        }

        return bookList;
    }



    public void printBookInfo(Book b){
        if(b instanceof AudioBook){
            audioService.printFullInfo((AudioBook) b);
        }
        if(b instanceof Ebook){
            ebService.printFullInfo((Ebook) b);
        }
        if(b instanceof PaperBook){
            pbService.printFullInfo((PaperBook) b);
        }

    }

    @Override
    public void searchByTitle(String title) {
        boolean found = false;
        Iterator<Map.Entry<BookTypes, HashSet<Book>>> mapIt = allBooks.entrySet().iterator();
        while(mapIt.hasNext()){
            Map.Entry<BookTypes, HashSet<Book>> mapEntry = mapIt.next();
            for(Book b : mapEntry.getValue()){
                if(b.getTitle().equals(title)){
                    printBookInfo(b);
                    found = true;
                }
            }
        }
        if(!found){
            System.out.println("Not Found");
        }

    }

    @Override
    public void searchByAuthor(String author) {
        boolean found = false;
        Iterator<Map.Entry<BookTypes, HashSet<Book>>> mapIt = allBooks.entrySet().iterator();
        while(mapIt.hasNext()){
            Map.Entry<BookTypes, HashSet<Book>> mapEntry = mapIt.next();
            for(Book b : mapEntry.getValue()){
                if(b.getAuthor().equals(author)){
                    printBookInfo(b);
                    found = true;
                }
            }
        }
        if(!found){
            System.out.println("Not Found");
        }
    }

    @Override
    public void searchByGenre(String genre) {
        boolean found = false;
        Iterator<Map.Entry<BookTypes, HashSet<Book>>> mapIt = allBooks.entrySet().iterator();
        while(mapIt.hasNext()){
            Map.Entry<BookTypes, HashSet<Book>> mapEntry = mapIt.next();
            for(Book b : mapEntry.getValue()){
                if(b.getGenre().equals(genre)){
                    printBookInfo(b);
                    found = true;
                }
            }
        }
        if(!found){
            System.out.println("Not Found");
        }

    }
}
