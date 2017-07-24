import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "ServletOperator")
public class ServletOperator extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("Hi Operator<br>");
        pw.print("<form name=\"Form1\" action=\"http://localhost:8080/AddSparePart.html\" method=\"post\">");
        pw.print("<input type=\"submit\" value=\"Add Spare Part\"></form>");
        //RequestDispatcher rd = request.getRequestDispatcher("AddSparePart.html");
        //rd.forward(request,response);
        pw.print("<form name=\"Form2\" action=\"http://localhost:8080/RemoveSparePart.html\" method=\"post\">");
        pw.print("<input type=\"submit\" value=\"Remove Spare Part\"></form>");
        pw.print("<form name=\"FormLogout\" action=\"http://localhost:8080/Logout\" method=\"post\">");
        pw.print("<input type=\"submit\" value=\"Logout\"></form>");
        pw.close();
        //pw.print("<a href='http://localhost:8080/AddSparePart'>Add Spare Part</a>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
