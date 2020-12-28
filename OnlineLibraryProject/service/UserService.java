package OnlineLibraryProject.service;

import OnlineLibraryProject.exceptions.InvalidInputException;
import OnlineLibraryProject.interfaces.Registration;
import OnlineLibraryProject.model.User;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserService implements Registration {



    Scanner sc = new Scanner(System.in);
    FileService fs = new FileService();
    private static final Path p = Paths.get("OnlineLibraryProject/files/database.txt");
    private static HashMap<String,String> users ;

    public UserService(){
        users = new HashMap<>();
        updateUsers();
    }

    public void updateUsers(){
        List<String> l;
        try{
            l = fs.read(p);
        }catch(IOException e){
            return;
        }

        for( String x: l){
            String[] parts = x.split(",");
            users.put(parts[1], parts[3]);
        }
    }

    public User createUser(String fullname, String username, String email, String password ){

        return new User(fullname,username,email,password);

    }
    private static boolean validateUsername(  String usn ) throws InvalidInputException {
        String REGEX = "(.*).{10,}";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(usn);
        if(m.matches() && !users.containsKey(usn)){

            return true;
        }else{
            throw new InvalidInputException("Not valid username");


        }
    }
    private static boolean validateEmail(String email) throws InvalidInputException {
        String REGEX = "(.+)@[a-zA-Z]+[.][a-z]+";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(email);
        if(m.matches()){

            return true;
        }else{
            throw new InvalidInputException("Not valid email");

        }
    }
    private static boolean validatePassword(String psw) throws InvalidInputException {
        String REGEX = "((?=(.*\\d){3,})(?=.*[A-Z]))[0-9a-zA-Z!@#$%]{8,}";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(psw);
        if(m.matches()){

            return true;
        }else{
            throw new InvalidInputException("Not valid Password.");

        }

    }




    @Override
    public void register() {
        String password, email,username;

        System.out.println("Please input");
        System.out.print("First name: ");
        String firstname = sc.next();
        System.out.print("Last name: ");
        String lastname = sc.next();
        System.out.println("Username should contain more than 10 digits");
        try {
            System.out.print("Username: ");
            username = sc.next();
            validateUsername(username);
            System.out.print("Email: ");
            email = sc.next();
            validateEmail(email);
            System.out.println("Password should contain at least 2 UPPERCASE letters, 3 numbers, and has length at least 8");
            System.out.print("Password: ");
            password = sc.next();
            validatePassword(password);
        }catch(InvalidInputException e){
            System.out.println(e.getMessage());
            System.out.println("Registration Failed");
            return;
        }

        String fullname = firstname + " " + lastname;

        password = md5(password);
        User newUser = createUser(fullname,username,email,password);
        try{
              fs.write(p,newUser);
        }catch(IOException e){
              System.out.println("File not found");
        }

        users.put(username,password);
        System.out.println("Registration was successful!");




    }

    public static String md5(String input) {
        String md5 = null;
        if(null == input) return null;
        try {
            //Create MessageDigest object for MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");
            //Update input string in message digest
            digest.update(input.getBytes(), 0, input.length());
            //Converts message digest value in base 16 (hex)
            md5 = new BigInteger(1, digest.digest()).toString(16);
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5;
    }



    @Override
    public boolean login() {
        System.out.print("Username: ");
        String username = sc.next();
        System.out.print("Password: ");
        String pw = sc.next();

        if(checkPassword(username,md5(pw))){
            return true;
        }else{
            System.out.println("Password wasn't right");
            return false;
        }


    }

    private boolean checkPassword(String usnm,String pw){
        if(users.containsKey(usnm)){
            if(users.get(usnm).equals( pw)){
                return true;
            }
        }


        return false;

    }

    @Override
    public void logout() {

    }
}
