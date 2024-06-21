import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("user_name");
        String passWord = request.getParameter("passWord");
        User user = new User();
        Connection connection = null;

        if (userName == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Fill an username");
            return;
        }
        if (passWord == null){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST,"Fill a password");
        }
        if (userName == null && passWord == null){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST,"Fill both field");
        }
        else{
            try {
                connection = PSQLConnect.getConnection();
    
                user = User.loginUser(userName,passWord, connection);

                HttpSession session = request.getSession(); 
                session.setAttribute("username",user.getName());
                session.setAttribute("password",user.getPassWord());
                session.setAttribute("id",user.getId());
                connection.close();

                response.sendRedirect("readTask");
    
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database Error: " + e.getMessage());
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
}