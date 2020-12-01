package OnlineLibraryProject.service;

import OnlineLibraryProject.interfaces.Search;
import OnlineLibraryProject.model.AudioBook;
import OnlineLibraryProject.model.Book;
import OnlineLibraryProject.model.Ebook;
import OnlineLibraryProject.model.PaperBook;



public class Catalog implements Search {
    // To be made an ArrayList later
    private Book[] allBooks = {};
    private AudioBookService audioService = new AudioBookService();
    private EbookService ebService = new EbookService();
    private PaperBookService pbService = new PaperBookService();
    private AudioBook[] ab = {};
    private Ebook[] eb = {};
    private PaperBook[] pb = {};



    public Catalog()  {
        int l1,l2,l3;

        try {
             ab = audioService.allAudioBooks();
             l1 = ab.length;
        }catch(NullPointerException e){
           l1 = 0;
        }
        try {
             eb = ebService.allEbooks();
             l2 = eb.length;
        }catch(NullPointerException e){
           l2 = 0;
        }
        try {
            pb = pbService.allPaperBooks();
             l3 = pb.length;
        }catch(NullPointerException e){
            l3 = 0;
        }
        int l = l1+l2+l3;
        allBooks = mergeThreeArrays(ab,eb,pb);

    }

    public Book[] mergeThreeArrays(AudioBook[] ab, Ebook[] eb, PaperBook[] pb){
        int l1 =  ab.length;
        int l2 =  eb.length;
        int l3 =  pb.length;

        allBooks = new Book[l1+l2+l3];
        for(int i = 0; i< l1; i++){
            allBooks[i] = ab[i];
        }
        for(int i = l1, j = 0; i< l1+l2; i++, j++){
            allBooks[i] = eb[j];
        }
        for(int i = l1+l2, j = 0; i< l1+l2+l3; i++, j++){
            allBooks[i] = pb[j];
        }

        return  allBooks;

    }

    public void viewCatalog(){

        if(allBooks.length == 0){
            System.out.println("There are no books yet");
            return;
        }


        System.out.println("//// All Books ////");
        for(Book b : allBooks){

            if(b instanceof AudioBook){
                audioService.printShortInfo((AudioBook) b);
            }
            else if(b instanceof Ebook){
                ebService.printShortInfo((Ebook) b);
            }
            else if(b instanceof PaperBook){
                pbService.printShortInfo((PaperBook) b);
            }

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

    public void removeBook(Book b){}
    public void showAll(){
        if(allBooks.length == 0){
            System.out.println("There are no books yet");
            return;
        }
        showAudioBooks();
        showEBooks();
        showPaperBooks();

    }

    public void showAudioBooks(){
        ab = audioService.allAudioBooks();
        System.out.println("/// AudioBooks////");
        if(ab == null){
            System.out.println("There are no Audiobooks");
            return;
        }
        for(AudioBook b : ab){
            audioService.printFullInfo(b);
        }

    }

    public void showEBooks(){
        System.out.println("//// Ebooks ////");
        eb = ebService.allEbooks();
        if(eb.length == 0){
            System.out.println("There are no Ebooks");
            return;
        }
        for(Ebook b : eb){
            ebService.printFullInfo(b);
        }

    }
    public void showPaperBooks(){
        pb = pbService.allPaperBooks();
        System.out.println("//// Paper Books ////");
        if(pb.length == 0){
            System.out.println("There are no Paperbooks");
            return;
        }
        for(PaperBook b : pb){
            pbService.printFullInfo(b);
        }

    }

    public void addAudioBook()  {
        audioService.createAB();
        ab = audioService.allAudioBooks();
        allBooks = updateAllBooks(ab,eb,pb);
        System.out.println("AudioBook added.");

    }

    public void addEBook()  {
        ebService.createEbook();
       eb = ebService.allEbooks();
        allBooks = updateAllBooks(ab,eb,pb);
        System.out.println("Ebook added.");

    }
    public void addPaperBook()  {
        pbService.createPaperBook();
        pb = pbService.allPaperBooks();
        allBooks = updateAllBooks(ab,eb,pb);
        System.out.println("PaperBook added.");

    }

    public Book[] updateAllBooks(AudioBook[] ab, Ebook[] eb, PaperBook[] pb){
       return  mergeThreeArrays(ab,eb,pb);
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
        for(Book b: allBooks){
            if(b.getTitle().equals(title)){
                printBookInfo(b);
                found = true;
            }
        }
        if(!found){
            System.out.println("Not Found");
        }

    }

    @Override
    public void searchByAuthor(String author) {
        boolean found = false;
        for(Book b: allBooks){
            if(b.getAuthor().equals(author)){
                printBookInfo(b);
                found = true;
            }
        }
        if(!found){
            System.out.println("Not Found");
        }
    }

    @Override
    public void searchByGenre(String genre) {
        boolean found = false;
        for(Book b: allBooks){
            if(b.getGenre().equals(genre)){
                printBookInfo(b);
                found = true;
            }

        }

        if(!found){
            System.out.println("Not Found");
        }


    }
}
