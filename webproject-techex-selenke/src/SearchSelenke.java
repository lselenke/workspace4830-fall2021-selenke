import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchSelenke")
public class SearchSelenke extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public SearchSelenke() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String keyword = request.getParameter("keyword");
      search(keyword, response);
   }

   void search(String keyword, HttpServletResponse response) throws IOException {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Contact List";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
            "transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");

      Connection connection = null;
      PreparedStatement preparedStatement = null;
      try {
         DBConnectionSelenke.getDBConnection();
         connection = DBConnectionSelenke.connection;

         if (keyword.isEmpty()) {
            String selectSQL = "SELECT * FROM MyTableSelenkeTechEx";
            preparedStatement = connection.prepareStatement(selectSQL);
         } else {
            String selectSQL = "SELECT * FROM MyTableSelenkeTechEx WHERE FIRST_NAME LIKE ? OR LAST_NAME LIKE ?";
            String theName = keyword + "%";
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, theName);
            preparedStatement.setString(2, theName);
         }
        
         ResultSet rs = preparedStatement.executeQuery();

         while (rs.next()) {
            int id = rs.getInt("id");
            String firstName = rs.getString("first_name").trim();
            String lastName = rs.getString("last_name").trim();
            String company = rs.getString("company").trim();
            String phone = rs.getString("phone").trim();
            String address_street = rs.getString("address_street").trim();
            //String address_apnum = rs.getString("address_apnum").trim();
            String address_city = rs.getString("address_city").trim();
            String address_state = rs.getString("address_state").trim();
            String address_country = rs.getString("address_country").trim();
            String address_zip = rs.getString("address_zip").trim();
            String email = rs.getString("email").trim();
            String family = rs.getString("family").trim();

            if (keyword.isEmpty() || firstName.contains(keyword) || lastName.contains(keyword) ) {
               out.println("ID: " + id + ", ");
               out.println("Name: " + firstName + " " + lastName + "<br>");
               out.println("Company: " + company + "<br>");
               out.println("Phone: " + phone + "<br>");
               out.println("Address: " + address_street + "<br>");
               out.println(address_city + ", " + address_state + address_zip + "<br>");
               out.println(address_country + "<br>");
               out.println("Email: " + email + "<br>");
               out.println("Family: " + family + "<br>" + "<br>");
            }
         }
         out.println("<a href=/webproject-techex-selenke/search_selenke.html>Search Data</a> <br>");
         out.println("</body></html>");
         rs.close();
         preparedStatement.close();
         connection.close();
      } catch (SQLException se) {
         se.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if (preparedStatement != null)
               preparedStatement.close();
         } catch (SQLException se2) {
         }
         try {
            if (connection != null)
               connection.close();
         } catch (SQLException se) {
            se.printStackTrace();
         }
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}
