import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DestroySession extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Destroy Session");
        
        // Get the current session, if it exists
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            session.invalidate();
            System.out.println("Session Destroyed");
        } else {
            System.out.println("No session to destroy.");
        }
        response.sendRedirect("readTask");
    }
}
