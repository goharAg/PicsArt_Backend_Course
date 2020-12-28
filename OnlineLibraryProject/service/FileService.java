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
        StringBuilder fileText = new StringBuilder();

        fileText.append(ab.getTitle()).append(",").append(ab.getAuthor()).append(",").append(ab.getGenre()).append(",").append(ab.getLang()).append(",").append(ab.getNarrator()).append(",").append(ab.getLength()).append("\n");
        try {
            Files.write(p, fileText.toString().getBytes(), StandardOpenOption.APPEND);
        }catch(IOException e){
            System.out.println("Problem writing while writing AudioBook");
            return;

        }
    }

    public void write(Path p, Ebook ab)  {
        StringBuilder fileText = new StringBuilder();
        fileText.append(ab.getTitle()).append(",").append(ab.getAuthor()).append(",").append(ab.getGenre()).append(",").append(ab.getLang()).append(",").append(ab.getFormat());

        try {
            Files.write(p, fileText.toString().getBytes(), StandardOpenOption.APPEND);
        }catch(IOException e){
            System.out.println("Problem writing while writing EBook");
            return ;
        }
    }

    public void write(Path p, PaperBook ab)  {
        StringBuilder fileText = new StringBuilder();
        fileText.append(ab.getTitle()).append(",").append(ab.getAuthor()).append(",").append(ab.getGenre()).append(",").append(ab.getLang()).append(",").append(ab.getPublishingCompany());


        try {
            Files.write(p, fileText.toString().getBytes(), StandardOpenOption.APPEND);
        }catch(IOException e){
            System.out.println("Problem writing while writing PaperBook");
            return ;
        }
    }

}
