import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
    public static int addTask(String task, Timestamp remindTime, Timestamp dueTime, Connection connection) throws SQLException {
        String sql = "INSERT INTO todolist (task, status, remind, due) VALUES (?, false, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, task);
        statement.setTimestamp(2, remindTime);
        statement.setTimestamp(3, dueTime);
        int rowsInserted = statement.executeUpdate();
        statement.close();
        return rowsInserted;
    }

    public static int finishTask(String id,Connection connection) throws SQLException{
        String sql = "UPDATE todolist SET status = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setBoolean(1, true);
        statement.setInt(2, Integer.parseInt(id));
        int rowsInserted = statement.executeUpdate();
        statement.close();
        return rowsInserted;
    }

    public static int deleteTask(String id,Connection connection) throws SQLException{
        String sql="DELETE FROM todolist WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, Integer.parseInt(id));
        int rowsInserted = statement.executeUpdate();
        statement.close();
        return rowsInserted;
    }

    public static ArrayList<Task> getTodoList(Connection connection) throws SQLException {
        ArrayList<Task> todolists = new ArrayList<>();
        Statement statement = null;
        ResultSet result = null;
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("select * from todolist");
    
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
}