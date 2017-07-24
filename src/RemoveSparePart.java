import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * Created by beheraa on 7/24/2017.
 */
@WebServlet(name = "RemoveSparePart")
public class RemoveSparePart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        int id = Integer.parseInt(request.getParameter("id"));
        PrintWriter pw = response.getWriter();
        Connection con = ConnectionFactory.getConnection();
        int ra = 0;
        try {
            pw.print("Trying to delete<br>");
            String sql = "delete from spareparts where id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,id);
            ra = pst.executeUpdate();
            if(ra != 0) {
                pw.print("removal successful");
            } else {
                pw.print("removal unsuccessful");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
