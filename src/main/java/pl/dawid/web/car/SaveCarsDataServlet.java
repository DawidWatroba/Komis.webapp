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
//@WebServlet(urlPatterns = "/add_car")
public class SaveCarsDataServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {
        Car car = new Car();
        car.setMake(req.getParameter("make"));
        car.setModel(req.getParameter("model"));
        car.setProductionYear(Integer.parseInt(req.getParameter("ProductioYear")));
        car.setColor(req.getParameter("color"));

        CarDataDAO dao = new CarDataDAOImpl();
        try {
            InitialContext initCtx = new InitialContext();
            Context context = (Context) initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource) context.lookup(getServletContext().getInitParameter("dataSource"));
            dao.saveCarData(car, ds);
            //podpunkt g :
            //req.setAttribute("bla bla", client);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PrintWriter pw = resp.getWriter();
        pw.println("<HTML><HEAD>");
        pw.println("<meta charset=\"UTF-8\">");
        pw.println("<TITLE>Brawo!</TITLE>");
        pw.println("</HEAD><BODY><font color=\"red\"><font size=\"6\">" +
                "<center>Udalo Ci się dodać auto" +
                "</font></center></font><br><br>");
        pw.println("<center><font size=\"5\">" +
                "<a href=\"carForm.html\">Dodaj kolejne auto<?a>" +
                "</font></center><br><br>");
        pw.println("<center><font size=\"5\">" +
                "<a href=\"read_cars\">Pokaz liste aut<?a>" +
                "</font></center><br><br>");
        pw.println("<H3></H3>");
        pw.println("</BODY></HTML>");
    }
}
