import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadTask extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Task> taskList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = PSQLConnect.getConnection();
            taskList = Task.getTodoList(connection);
            int[] id = new int[taskList.size()];
            ArrayList<String> tosk = new ArrayList<>();
            int[] orderTask = new int[taskList.size()];
            ArrayList<Timestamp> remind = new ArrayList<>();
            ArrayList<Timestamp> due = new ArrayList<>();
            boolean[] status = new boolean[taskList.size()];
            int count =0;
            for(Task task : taskList){
                id[count] = task.getId();
                tosk.add(task.getTask());
                orderTask[count] = task.getOrderTask();
                remind.add(task.getRemind());
                due.add(task.getDue());
                status[count] = task.getStatus();
                count++;
            }
            request.setAttribute("id", id);
            request.setAttribute("task", tosk);
            request.setAttribute("orderTask", orderTask);
            request.setAttribute("remind", remind);
            request.setAttribute("due", due);
            request.setAttribute("status", status);
            RequestDispatcher dispatcher = request.getRequestDispatcher("tasklist.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database Error: " + e.getMessage());
            return;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    
}
