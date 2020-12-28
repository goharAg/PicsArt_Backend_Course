package OnlineLibraryProject.service;

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
    private static boolean validateUsername(  String usn ) {
        String REGEX = "(.*).{10,}";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(usn);
        if(m.matches() && !users.containsKey(usn)){
            System.out.println("Valid username");
            return true;
        }else{
            System.out.println("Not valid username");
            return false;
        }
    }
    private static boolean validateEmail(String email){
        String REGEX = "(.+)@[a-zA-Z]+[.][a-z]+";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(email);
        if(m.matches()){
            System.out.println("Valid email");
            return true;
        }else{
            System.out.println("Not valid email");
            return false;
        }
    }
    private static boolean validatePassword(String psw){
        String REGEX = "((?=(.*\\d){3,})(?=.*[A-Z]))[0-9a-zA-Z!@#$%]{8,}";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(psw);
        if(m.matches()){
            System.out.println("Valid password");
            return true;
        }else{
            System.out.println("Not valid pasword");
            return false;
        }

    }




    @Override
    public void register() {
        sc.nextLine();
        System.out.print("Full name: ");
        String fullname = sc.nextLine();
        System.out.println("\nUsername should contain more than 10 digits");
        System.out.print("\nUsername: ");
        String username = sc.next();

        System.out.print("\nEmail: ");
        String email = sc.next();
        System.out.println("\nUPassword should contain at least 2 UPPERCASE letters, 3 numbers, and has length at least 8");
        System.out.print("\nPassword: ");
        String password = sc.next();


        if(validateUsername(username) && validateEmail(email) && validatePassword(password)){
            password = md5(password);
           User newUser = createUser(fullname,username,email,password);
            try{
                fs.write(p,newUser);
            }catch(Exception e){
                System.out.println("Something went wrong!");
            }

            users.put(username,password);
            System.out.println("Registration succesful!");

        }else {
            System.out.println("Not valid input");
            return;
        }


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
        System.out.print("\nUsername: ");
        String username = sc.next();
        System.out.print("\nPassword: ");
        String pw = sc.next();

        if(checkPassword(username,md5(pw))){
            System.out.println("right");
            return true;
        }else{
            System.out.println("not right");
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
