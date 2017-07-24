import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by beheraa on 7/19/2017.
 */
@WebServlet(name = "ServletReportViewUser")
public class ServletReportViewUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        Connection con = ConnectionFactory.getConnection();
        //pw.print("Hiiiiii");
        response.setContentType("text/html");
//        PrintWriter pw = response.getWriter();
//        Connection con = ConnectionFactory.getConnection();
        pw.println("<table border = 1>");
        pw.println("<tr><th>Name</th><th>Model No</th><th>Brand</th><th>Price</th></tr>");
        try {
            PreparedStatement pst = con.prepareStatement("select model_no,name,brand,price from vehicles");
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                String model = rs.getString("model_no");
                String name = rs.getString("name");
                String brand = rs.getString("brand");
                double price= rs.getDouble("price");
                pw.println("<td>"+name+"</td><td>"+model+"</td><td>"+brand+"</td><td>"+price+"</td></tr><br>");
            }
            pw.print("</table>");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
