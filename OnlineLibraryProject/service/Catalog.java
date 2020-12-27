package OnlineLibraryProject.service;

import OnlineLibraryProject.interfaces.Search;
import OnlineLibraryProject.model.AudioBook;
import OnlineLibraryProject.model.Book;
import OnlineLibraryProject.model.Ebook;
import OnlineLibraryProject.model.PaperBook;

import java.util.*;


public class Catalog implements Search {
    // To be made an ArrayList later

    private AudioBookService audioService = new AudioBookService();
    private EbookService ebService = new EbookService();
    private PaperBookService pbService = new PaperBookService();
   // private HashSet<Book> ab;
   // private HashSet<Book> eb;
    //private HashSet<Book> pb;
    private int size = 0;

    private HashMap<String, HashSet<Book>> allBooks;


    public Catalog()  {
//    ab = audioService.allAudioBooks();
//    eb = ebService.allEbooks();
//    pb = pbService.allPaperBooks();

    allBooks = new HashMap<>();
    allBooks.put("AudioBook", audioService.allAudioBooks());
    allBooks.put("Ebook", ebService.allEbooks());
    allBooks.put("PaperBook", pbService.allPaperBooks());

    }



    public void viewCatalog(){
        if(allBooks.get("AudioBook").size() == 0 && allBooks.get("Ebook").size() == 0 && allBooks.get("PaperBook").size() == 0){
            System.out.println("There are no books yet");
            return;
        }


        System.out.println("//// All Books ////");
        for(Book b: allBooks.get("AudioBook")){
            audioService.printShortInfo((AudioBook) b);
        }
        for(Book b: allBooks.get("Ebook")){
            ebService.printShortInfo((Ebook) b);
        }
        for(Book b: allBooks.get("PaperBook")){
            pbService.printShortInfo((PaperBook) b);
        }



    }

    private boolean isEmpty(){
        if(allBooks.get("AudioBook").size() == 0 && allBooks.get("Ebook").size() == 0 && allBooks.get("PaperBook").size() == 0){
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

        if(allBooks.get("AudioBook").size() == 0){
            System.out.println("There are no Audiobooks");
            return;
        }
        for(Book b : allBooks.get("AudioBook")){
            audioService.printFullInfo((AudioBook)b);
        }

    }

    public void showEBooks(){
        System.out.println("//// Ebooks ////");

        if(allBooks.get("Ebook").size() == 0){
            System.out.println("There are no Ebooks");
            return;
        }
        for(Book b : allBooks.get("Ebook")){
            ebService.printFullInfo((Ebook)b);
        }

    }
    public void showPaperBooks(){

        System.out.println("//// Paper Books ////");
        if(allBooks.get("PaperBook").size() == 0){
            System.out.println("There are no Paperbooks");
            return;
        }
        for(Book b : allBooks.get("PaperBook")){
            pbService.printFullInfo((PaperBook)b);
        }

    }

    public void addAudioBook()  {
       AudioBook ab = audioService.create();
        allBooks.get("AudioBook").add(ab);
        System.out.println("AudioBook added.");

    }

    public void addEBook()  {
        Ebook eb = ebService.createEbook();
        allBooks.get("Ebook").add(eb);
        System.out.println("Ebook added.");

    }
    public void addPaperBook()  {
        PaperBook pb =pbService.createPaperBook();
        allBooks.get("PaperBook").add(pb);
        System.out.println("PaperBook added.");

    }

    public void updateAllBooks(){
        allBooks.replace("AudioBook", audioService.allAudioBooks());
        allBooks.replace("Ebook", ebService.allEbooks());
        allBooks.replace("PaperBook", pbService.allPaperBooks());
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
        Iterator<Map.Entry<String, HashSet<Book>>> mapIt = allBooks.entrySet().iterator();
        while(mapIt.hasNext()){
            Map.Entry<String, HashSet<Book>> mapEntry = mapIt.next();
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
        Iterator<Map.Entry<String, HashSet<Book>>> mapIt = allBooks.entrySet().iterator();
        while(mapIt.hasNext()){
            Map.Entry<String, HashSet<Book>> mapEntry = mapIt.next();
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
        Iterator<Map.Entry<String, HashSet<Book>>> mapIt = allBooks.entrySet().iterator();
        while(mapIt.hasNext()){
            Map.Entry<String, HashSet<Book>> mapEntry = mapIt.next();
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
