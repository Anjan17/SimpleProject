import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by beheraa on 7/24/2017.
 */
@WebServlet(name = "RemoveOperator")
public class RemoveOperator extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        Connection con = ConnectionFactory.getConnection();
        int oid = Integer.parseInt(request.getParameter("id"));
        try {
            pw.print("trying to remove operator");
            String sql = "delete from users where id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,oid);
            int rs = pst.executeUpdate();
            if(rs!=0) {
                pw.print("Operator removed");
            } else {
                pw.print("Operator removing failed !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
