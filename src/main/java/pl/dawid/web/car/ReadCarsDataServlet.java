package pl.dawid.web.car;

import pl.dawid.web.client.Client;
import pl.dawid.web.client.ClientDataDAO;
import pl.dawid.web.client.ClientDataDAOImpl;

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

@WebServlet(urlPatterns = "/read_cars")
public class ReadCarsDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        try {
            InitialContext initCtx = new InitialContext();
            Context context = (Context) initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource) context.lookup(getServletContext().getInitParameter("dataSource"));
            CarDataDAOImpl dao = new CarDataDAOImpl();
            List cars = dao.readCarsData(ds);
            pw.println("<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Title</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<table>");
            for (Object o : cars) {
                Car c = (Car)o;
                pw.print("<tr>");
                pw.print("<td>");
                pw.println(c.getMake());
                pw.println("</td>");
                pw.print("<td>");
                pw.println(c.getModel());
                pw.println("</td>");
                pw.print("<td>");
                pw.println(c.getProductionYear());
                pw.println("</td>");
                pw.print("<td>");
                pw.println(c.getColor());
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
