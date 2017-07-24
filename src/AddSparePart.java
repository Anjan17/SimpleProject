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
 * Created by beheraa on 7/23/2017.
 */
@WebServlet(name = "AddSparePart")
public class AddSparePart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        String model_no = request.getParameter("model_no");
        String nam = request.getParameter("name");
        /*pw.print(id);
        pw.print(model_no);
        pw.print(nam); */
        Connection con = ConnectionFactory.getConnection();
        int rs = 0;
        try {
            pw.print("inserting values");
            String sql = "insert into spareparts (id,model_no,Name1,brand,price,units,vehicle_id,tax) values(?,?,?,?,?,?,?,?);";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, model_no);
            pst.setString(3, nam);
            pst.setString(4,"Figo");
            pst.setDouble(5,4500);
            pst.setInt(6,567);
            pst.setInt(7,2345);
            pst.setDouble(8,5.9);
            rs = pst.executeUpdate();

            pw.print(rs);
            if (rs != 0) {
                pw.print("Spare Part added");
            } else {
                pw.print("Spare part addition failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
