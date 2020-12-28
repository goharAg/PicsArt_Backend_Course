package OnlineLibraryProject.model;

public class User {
    private String  fullname;

    private String username;
    private String email;
    private String password;

    public User(String fullname, String username, String email, String password ){
        setFullName(fullname);
        setUsername(username);

        setEmail(email);
        setPassword(password);
    }

    public String getFullName() {
        return fullname;
    }

    public void setFullName(String name) {
        this.fullname = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
