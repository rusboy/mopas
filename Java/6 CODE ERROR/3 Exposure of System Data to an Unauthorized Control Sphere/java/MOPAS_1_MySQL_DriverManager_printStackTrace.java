/**
 *  MOPAS Exposure of System Data to an Unauthorized Control Sphere Example 1
 *  Fetch data from MySQL database using DriverManager class
 *  Requirements: MySQL connector
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/MOPAS_1_MySQL_DriverManager_printStackTrace"})
public class MOPAS_1_MySQL_DriverManager_printStackTrace extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String query = "SELECT * FROM items WHERE owner = 'User'";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        // error here to throw exception
        String driverName = "com.mysql.jdbc.Driver111";
        String dbURL = "jdbc:mysql://localhost:3306/db";
        String user = "user";
        String password = "s3cr3tp@ss";

        try {
            Class.forName(driverName);

            connection = DriverManager.getConnection(dbURL,user,password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // do something
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace(response.getWriter());
        }
        catch (SQLException ex) {
            ex.printStackTrace(response.getWriter());
        }
        finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
            catch (SQLException ex) {
            }
        }
    }
}