package pl.dawid.web;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveClientDataServlet extends HttpServlet {
    //Client client = new Client();

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {
        Client client = new Client();
        client.setName(req.getParameter("name"));
        client.setSurname(req.getParameter("surname"));
        client.setAge(Integer.parseInt(req.getParameter("age")));
        client.setRegion(req.getParameter("region"));
        client.setSex(req.getParameter("sex"));

        ClientDataDAO dao = new ClientDataDAOImpl();
        try {
            InitialContext initCtx = new InitialContext();
            Context context = (Context) initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource) context.lookup(getServletContext().getInitParameter("dataSource"));
            dao.saveClientData(client, ds);
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
                "<center>Udalo Ci sie dodac uzytkownika!" +
                "</font></center></font><br><br>");
        pw.println("<center><font size=\"5\">" +
                "<a href=\"userForm.html\">Dodaj nastepnego klienta<?a>" +
                "</font></center><br><br>");
        pw.println("<H3></H3>");
        pw.println("</BODY></HTML>");
    }
}
