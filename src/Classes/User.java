package Classes;
import java.io.Serializable;

public class User {

    // Code from https://www.javahelps.com/2015/07/serialization-in-java.html?m=1
    private static final long serialVersionUID = 5230549922091722630L;
    /////////////////////////////////////////////////////////////////////////////

    String username = "";
    String password = "";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return  getUsername() + "\n" + getPassword();
    }
}
