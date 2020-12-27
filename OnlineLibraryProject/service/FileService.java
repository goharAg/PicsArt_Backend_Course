package OnlineLibraryProject.service;

import OnlineLibraryProject.model.AudioBook;
import OnlineLibraryProject.model.Book;
import OnlineLibraryProject.model.User;

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

}
