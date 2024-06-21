import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String passWord;

    public User(){}

    public User addId(int i) {
        this.id = i;
        return this;
    }

    public User addName(String n) {
        this.name = n;
        return this;
    }

    public User addPassWord(String p) {
        this.passWord = p;
        return this;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getPassWord(){
        return this.passWord;
    }

    public static User loginUser(String n,String p,Connection connection) throws SQLException{
        ArrayList<User> userList = new ArrayList<>();
        Statement statement = null;
        ResultSet result = null;
        try{
            statement = connection.createStatement();
            result = statement.executeQuery("select * from users where name='" + n + "' AND password= '"+p+"'");

            while (result.next()) {
                User user= new User();
                user
                        .addId(result.getInt(1))
                        .addName(result.getString(2))
                        .addPassWord(result.getString(3));
                userList.add(user);
            }
        } finally {
            if (result != null) {
                result.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
        return userList.get(0);
    }



}


