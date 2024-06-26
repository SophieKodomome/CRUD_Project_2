import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Task {
    private int id;
    private String task;
    private int orderTask;
    private Timestamp remind;
    private Timestamp due;
    private boolean status;

    public Task() {}

    public Task addId(int i) {
        this.id = i;
        return this;
    }

    public Task addTask(String t) {
        this.task = t;
        return this;
    }

    public Task addOrderTask(int o) {
        this.orderTask = o;
        return this;
    }

    public Task addStatus(boolean s) {
        this.status = s;
        return this;
    }

    public Task addRemindTask(Timestamp r) {
        this.remind = r;
        return this;
    }

    public Task addDueTask(Timestamp d) {
        this.due = d;
        return this;
    }
    
    public int getId(){
        return this.id;
    }

    public String getTask(){
        return this.task;
    }

    public int getOrderTask(){
        return this.orderTask;
    }

    public Timestamp getRemind(){
        return this.remind;
    }

    public Timestamp getDue(){
        return this.due;
    }

    public boolean getStatus(){
        return this.status;
    }
    public static int addTask(String task, Timestamp remindTime, Timestamp dueTime) throws SQLException {
        int rowsInserted;

        try{
            new PSQLConnect();
            Connection connection = PSQLConnect.getConnection();

            String sql = "INSERT INTO todolist (task, status, remind, due) VALUES (?, false, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, task);
            statement.setTimestamp(2, remindTime);
            statement.setTimestamp(3, dueTime);
            rowsInserted = statement.executeUpdate();
            statement.close();
            connection.close();
            return rowsInserted;
        }catch(SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    public static int finishTask(String id) throws SQLException{
        int rowsInserted;

        try{
            new PSQLConnect();
            Connection connection = PSQLConnect.getConnection();
            
            String sql = "UPDATE todolist SET status = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setBoolean(1, true);
            statement.setInt(2, Integer.parseInt(id));
            rowsInserted = statement.executeUpdate();
            statement.close();
            connection.close();
        } catch(SQLException e){
            e.printStackTrace();
           return 0;
        }
        return rowsInserted;
    }

    public static int updateTask(String id,String task, Timestamp remindTime, Timestamp dueTime) throws SQLException{
        int rowsInserted;

        try{
            new PSQLConnect();
            Connection connection = PSQLConnect.getConnection();

            String sql = "UPDATE todolist SET task = ?,remind = ?,due = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, task);
            statement.setTimestamp(2, remindTime);
            statement.setTimestamp(3, dueTime);
            statement.setInt(4, Integer.parseInt(id));
            rowsInserted = statement.executeUpdate();
            statement.close();
            connection.close();
            return rowsInserted;
        }catch(SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    public static int cancelFinishTask(String id) throws SQLException{
        int rowsInserted;

        try {
            new PSQLConnect();
            Connection connection = PSQLConnect.getConnection();
            String sql = "UPDATE todolist SET status = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setBoolean(1, false);
            statement.setInt(2, Integer.parseInt(id));
            rowsInserted = statement.executeUpdate();
            statement.close();
            connection.close();
            return rowsInserted;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    public static int deleteTask(String id) throws SQLException{
        int rowsInserted;

        try {
            new PSQLConnect();
            Connection connection = PSQLConnect.getConnection();
            String sql="DELETE FROM todolist WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(id));
            rowsInserted = statement.executeUpdate();
            statement.close();
            connection.close();
            return rowsInserted;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static ArrayList<Task> getTodoList() throws SQLException {
        ArrayList<Task> todolists = new ArrayList<>();
        Statement statement = null;
        ResultSet result = null;
        try {
            new PSQLConnect();
            Connection connection = PSQLConnect.getConnection();
            statement = connection.createStatement();
            result = statement.executeQuery("select * from todolist order by order_Task desc");
    
            while (result.next()) {
                Task task = new Task();
                task
                        .addId(result.getInt(1))
                        .addTask(result.getString(2))
                        .addOrderTask(result.getInt(3))
                        .addStatus(result.getBoolean(4))
                        .addRemindTask(result.getTimestamp(5))
                        .addDueTask(result.getTimestamp(6));
                todolists.add(task);
            }

            connection.close();
        } finally {
            if (result != null) {
                result.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
        return todolists;
    }

    public static Task getTodoListById(int id) throws SQLException {
        ArrayList<Task> todolists = new ArrayList<>();
        Statement statement = null;
        ResultSet result = null;
        try {
            new PSQLConnect();
            Connection connection = PSQLConnect.getConnection();
            statement = connection.createStatement();
            result = statement.executeQuery("select * from todolist where id="+id);
    
            while (result.next()) {
                Task task = new Task();
                task
                        .addId(result.getInt(1))
                        .addTask(result.getString(2))
                        .addOrderTask(result.getInt(3))
                        .addStatus(result.getBoolean(4))
                        .addRemindTask(result.getTimestamp(5))
                        .addDueTask(result.getTimestamp(6));
                todolists.add(task);
            }

                    connection.close();
        } finally {
            if (result != null) {
                result.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
        return todolists.get(0);
    }

    public static Timestamp convertDateTimeFormat(String date) {
        // Define input format
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        // Parse input string to LocalDateTime
        LocalDateTime dateTime = LocalDateTime.parse(date, inputFormatter);

        // Convert LocalDateTime to Timestamp
        return Timestamp.valueOf(dateTime);
    }
}