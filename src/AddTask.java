import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddTask extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String task = request.getParameter("task");
        Timestamp remindTime = Task.convertDateTimeFormat(request.getParameter("remind_time"));
        Timestamp dueTime = Task.convertDateTimeFormat(request.getParameter("due_time"));

        if (task.isEmpty() || dueTime == null || remindTime == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Information Incomplete");
            return;
        }

        try {

            int rowsInserted = Task.addTask(task, remindTime, dueTime);

            if (rowsInserted > 0) {
                response.sendRedirect("readTask");
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Task cannot be added");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database Error: " + e.getMessage());
        }
    }
}
