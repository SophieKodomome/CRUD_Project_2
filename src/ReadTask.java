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
            System.out.println("Attempting to establish database connection...");
            connection = PSQLConnect.getConnection();
            System.out.println("Database connection established successfully.");
            
            System.out.println("Retrieving todo list from the database...");
            taskList = Task.getTodoList(connection);
            System.out.println("Todo list retrieved successfully.");
            
            int[] arrayId = new int[taskList.size()];
            String[] arrayListaskName = new String[taskList.size()];
            int[] arrayOrderTask = new int[taskList.size()];
            Timestamp[] arrayRemind = new Timestamp[taskList.size()];
            Timestamp[] arrayDue = new Timestamp[taskList.size()];
            boolean[] arrayStatus = new boolean[taskList.size()];

            System.out.println("Populating arrays with task data...");
            for(int i=0; i<taskList.size();i++){
                arrayId[i] = taskList.get(i).getId();
                arrayListaskName[i]=taskList.get(i).getTask();
                arrayOrderTask[i] = taskList.get(i).getOrderTask();
                arrayRemind[i]=taskList.get(i).getRemind();
                arrayDue[i]=taskList.get(i).getDue();
                arrayStatus[i] = taskList.get(i).getStatus();
                System.out.println(arrayId[i]);
            }
            System.out.println("Arrays populated successfully.");
            
            System.out.println("Setting request attributes...");
            request.setAttribute("id", arrayId);
            request.setAttribute("tasklist", arrayListaskName);
            request.setAttribute("orderTask", arrayOrderTask);
            request.setAttribute("remind", arrayRemind);
            request.setAttribute("due", arrayDue);
            request.setAttribute("status", arrayStatus);
            System.out.println("Request attributes set successfully.");
            
            System.out.println("Forwarding request to tasklist.jsp...");
            RequestDispatcher dispatcher = request.getRequestDispatcher("tasklist.jsp");
            dispatcher.forward(request, response);
            System.out.println("Request forwarded successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database Error: " + e.getMessage());
            return;
        } finally {
            if (connection != null) {
                try {
                    System.out.println("Closing database connection...");
                    connection.close();
                    System.out.println("Database connection closed successfully.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    
}
