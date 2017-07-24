import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.SQLException;

/**
 * Created by beheraa on 7/19/2017.
 */
@WebServlet(name = "Checking")
public class Checking extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String uname = request.getParameter("uname");
        String pswd = request.getParameter("pswd");
        Connection con = ConnectionFactory.getConnection();
        //pw.println("Hi");
       // Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
        try {
            String sql = "select * from users where username = ? and password = ?";
           // Statement st = con.createStatement();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,uname);
            pst.setString(2,pswd);
           //pw.print(uname+"<br>"+pswd);
            ResultSet rs = pst.executeQuery();
            //pw.print(rs);

            if(rs.next()) {                         //Checking whether the username and password are in fact present in the database.
                    String sql1 = "select privelege from users where username = ? and password = ?";
                    pst = con.prepareStatement(sql1);
                pst.setString(1,uname);
                pst.setString(2,pswd);
                ResultSet rs1 = pst.executeQuery();
                //pw.println("Hi");
                int privilege = 0;
                if(rs1.next()) {
                    privilege = rs.getInt("privelege");
                    //pw.println(privilege);
                }
                //System.out.print(privilege);
                if(privilege == 1) {
                    request.setAttribute("Privilege",1);
                    RequestDispatcher rd = request.getRequestDispatcher("Operator_Page");
                    rd.forward(request,response);
                } else if(privilege == 2) {
                    request.setAttribute("Privilege",2);
                    RequestDispatcher rd = request.getRequestDispatcher("Admin_Page");
                    rd.forward(request,response);
                }
            } else {                                // If not present in the database, then display the error message.

                RequestDispatcher rd = request.getRequestDispatcher("Login.html");
                pw.println("Invalid username or password");
                Thread.sleep(1000);
                rd.include(request,response);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
