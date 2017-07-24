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
@WebServlet(name = "AddOperator")
public class AddOperator extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        Connection con = ConnectionFactory.getConnection();
        int oid = Integer.parseInt(request.getParameter("oid"));
        String oname = request.getParameter("oname");
        String pswd = request.getParameter("pswd");
        try {
            pw.print("trying to add operator");
            String sql = "insert into users (id,username,password,privelege) values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,oid);
            pst.setString(2,oname);
            pst.setString(3,pswd);
            pst.setInt(4,1);
            int rs = pst.executeUpdate();
            if(rs!=0) {
                pw.print("Operator added");
            } else {
                pw.print("Operator adding failed !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
