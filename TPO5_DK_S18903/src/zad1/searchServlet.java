package zad1;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/search")
public class searchServlet extends HttpServlet {
    DataSource dataSource;

    public void init() throws ServletException {
        try {
            Context init = new InitialContext();
            Context contx = (Context) init.lookup("java:comp/env");
            dataSource = (DataSource) contx.lookup("jdbc/books");
        } catch (NamingException exc) {
            throw new ServletException(
                    "Nie mogę uzyskać źródła java:comp/env/jdbc/books", exc);
        }
    }

    public void serviceRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html; charset=windows-1250");
        PrintWriter out = resp.getWriter();
        out.println("<html>\n" +
                "<head>\n" +
                "    <title>The Book App</title>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"style.css\" />\n" +
                "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<div id=\"container\">\n" +
                "    <div id=\"header\">\n" +
                "        <h1>THE BOOK APP</h1>\n" +
                "    </div>\n" +
                "    <div id=\"sideheader\"></div>\n" +
                "    <div id=\"left_column\">\n" +
                "        <div class=\"left_column_boxes\">\n" +
                "            <h4>Menu</h4>\n" +
                "            <div id=\"navcontainer\">\n" +
                "                <ul id=\"navlist\">\n" +
                "                    <li id=\"active\"><a href=\"index.jsp\" id=\"current\">Home</a></li>\n" +
                "                    <li><a href=\"search.jsp\">Search</a></li>\n" +
                "                    <li><a href=\"http://localhost:8080/BookApp/random\">Randomize</a></li>\n" +
                "                    <li><a href=\"http://localhost:8080/BookApp/allbooks\">All Books</a></li>\n" +
                "                    <li><a href=\"guide.jsp\">Guide</a></li>\n" +
                "                </ul>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <p class=\"center\">Created by <b>Kacper Dobosz</b></p>\n" +
                "    </div>\n" +
                "    <div id=\"content\">\n" +
                "        <form class=\"example\" method=\"post\" action=\"search\">\n" +
                "            <input type=\"text\" placeholder=\"Search by id..\" name=\"search\">\n" +
                "            <button type=\"submit\"><i class=\"fa fa-search\"></i></button>\n" +
                "        </form>\n");
        Connection con = null;
        String parameter = req.getParameter("search");
        if(Integer.valueOf(parameter)>=1 && Integer.valueOf(parameter)<=12){
            try{
                synchronized (dataSource) {
                    con = dataSource.getConnection();
                }
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from books where imgId = "+ parameter);
                out.println("<b>Your search result:</b> ");
                while (rs.next())  {
                    int imgId = rs.getInt("imgId");
                    String year  = rs.getString("year");
                    String title = rs.getString("title");
                    String author  = rs.getString("author");
                    out.println("<li>"+ " Title: " + title +" Year: " + year + " Author: " + author + "</li>");
                }
                rs.close();
                stmt.close();
            } catch (Exception exc)  {
                out.println(exc.getMessage());
            } finally {
                try { con.close(); } catch (Exception exc) {}
            }

        }else {
            out.println("Sorry!!! Your ID can't be lower than 1 or higher than 12");
        }
        out.println("<div id=\"empty\"></div>\n" +
                "    </div>\n" +
                "    <div id=\"footer\"></div>\n" +
                "</div>\n" +
                "<div align=center>I used this template from this site: <a href='http://all-free-download.com/free-website-templates/'>Site with cool templates :D</a></div></body>\n" +
                "</html>");
        out.close();

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        serviceRequest(request, response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        serviceRequest(request, response);
    }
}
