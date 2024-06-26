import java.sql.Connection;
import java.util.ArrayList;

public class Main {

    public static void main(String args[]){
        System.out.println("hello");
        try {
            ArrayList<Task> arrayListTask= Task.getTodoList();
            for (Task task : arrayListTask) {
                System.out.println(task.getId());
            } 
        } catch (Exception e) {
            e.getMessage();
        }

    }
}