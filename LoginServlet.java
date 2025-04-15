
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ahmed
 */
public class LoginServlet extends HttpServlet {

//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//
//        }
//    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password"); // Use the correct driver class name
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empowerhub", "root", "root");
            PreparedStatement ps = con.prepareStatement("select * from details where username=? and password=?");

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                response.sendRedirect("Landing.html");
//                out.print("You are successfully logged in!");
            } else {
                out.print("<h1>Sorry username or password incorrect</h1>");
            }
        } catch (Exception e) {
            out.println(e);
        }
    }
}


/* @Override
            protected void doPost
            (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                processRequest(request, response);
            }

            @Override
            public String getServletInfo

            
                () {
        return "Short description";
            }// </editor-fold>

        }*/
