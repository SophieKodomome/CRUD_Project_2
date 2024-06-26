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

public class ReadTaskById extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Task task = new Task();
        String stringId = request.getParameter("id");
        int selectedId = Integer.parseInt(stringId);
        try {
            
            System.out.println("Retrieving todo list from the database...");
            task = Task.getTodoListById(selectedId);
            System.out.println("Todo list retrieved successfully.");

            int id = task.getId();
            String listaskName=task.getTask();
            int orderTask = task.getOrderTask();
            Timestamp remind=task.getRemind();
            Timestamp due=task.getDue();
            boolean status = task.getStatus();
                System.out.println(id);
            
            System.out.println("Setting request attributes...");
            request.setAttribute("id", id);
            request.setAttribute("tasklist", listaskName);
            request.setAttribute("orderTask", orderTask);
            request.setAttribute("remind", remind);
            request.setAttribute("due", due);
            request.setAttribute("status", status);
            System.out.println("Request attributes set successfully.");
            
            System.out.println("Forwarding request to modify.jsp...");
            RequestDispatcher dispatcher = request.getRequestDispatcher("modify.jsp");
            dispatcher.forward(request, response);
            System.out.println("Request forwarded successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database Error: " + e.getMessage());
            return;
        }
    }
    
    
}
