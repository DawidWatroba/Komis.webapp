package pl.dawid.web.client;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/read_users")
public class ReadClientDataServlet extends HttpServlet {

    @Resource(name = "jdbc:komis")
    private DataSource ds;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        try {
            /*
te linijki przenosimy wyżej -> @Resource....
    InitialContext initCtx = new InitialContext();
    Context context = (Context) initCtx.lookup("java:comp/env");
    DataSource ds = (DataSource) context.lookup(getServletContext().getInitParameter("dataSource"));
*/
            ClientDataDAO dao = new ClientDataDAOImpl();
            List clients = dao.readClientsData(ds);
            pw.println("<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Title</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<table>");
            for (Object o : clients) {
                Client c = (Client)o;
                pw.print("<tr>");
                pw.print("<td>");
                pw.println(c.getName());
                pw.println("</td>");
                pw.print("<td>");
                pw.println(c.getSurname());
                pw.println("</td>");
                pw.print("<td>");
                pw.println(c.getAge());
                pw.println("</td>");
                pw.print("<td>");
                pw.println(c.getRegion());
                pw.println("</td>");
                pw.print("<td>");
                pw.println(c.getSex());
                pw.println("</td>");
                pw.println("</tr>");
            }
            pw.println("</table>\n" +
                    "</body>\n" +
                    "</html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
