import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by beheraa on 7/19/2017.
 */
@WebServlet(name = "ServletAdmin")
public class ServletAdmin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        pw.println("Hi Admin<br>");
        pw.print("<form name=\"myForm1\" action=\"http://localhost:8080/AddOperator.html\" method=\"post\">");
        pw.print("<input type='submit' name='Add operator' value = 'Add Operator'></form><br>");
        pw.print("<form name=\"myForm2\" action=\"http://localhost:8080/RemoveOperator.html\" method=\"post\">");
        pw.print("<input type='submit' name='Remove operator' value = 'Remove Operator'></form><br>");
        pw.print("<form name=\"FormLogout\" action=\"http://localhost:8080/Logout\" method=\"post\">");
        pw.print("<input type=\"submit\" value=\"Logout\"></form>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
