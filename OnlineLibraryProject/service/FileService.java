package OnlineLibraryProject.service;

import OnlineLibraryProject.model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileService {



    public List read(Path path) throws IOException {
             return Files.readAllLines(path);
    }

    public void write(Path p,User user) throws IOException {
        System.out.println(user.getUsername());
        String text = user.getFullName() +"," + user.getUsername() + "," + user.getEmail()+ ","+user.getPassword()+"\n";
        Files.write(p, text.getBytes(), StandardOpenOption.APPEND );
    }

    public void write(Path p, AudioBook ab)  {
        String fileText = ab.getTitle() +","+ab.getAuthor()+","+ab.getGenre()+","+ab.getLang()+","+ab.getNarrator()+","+ab.getLength()+"\n" ;
        try {
            Files.write(p, fileText.getBytes(), StandardOpenOption.APPEND);
        }catch(IOException e){

        }
    }

    public void write(Path p, Ebook ab)  {
        String  fileText = ab.getTitle() + "," + ab.getAuthor() + "," + ab.getGenre() + "," + ab.getLang() + "," + ab.getFormat() + "\n";
        try {
            Files.write(p, fileText.getBytes(), StandardOpenOption.APPEND);
        }catch(IOException e){
            return ;
        }
    }

    public void write(Path p, PaperBook ab)  {
        String fileText = ab.getTitle() +","+ab.getAuthor()+","+ab.getGenre()+","+ab.getLang()+","+ab.getPublishingCompany()+"\n" ;
        try {
            Files.write(p, fileText.getBytes(), StandardOpenOption.APPEND);
        }catch(IOException e){
            System.out.println("IOException");
            return ;
        }
    }

}
