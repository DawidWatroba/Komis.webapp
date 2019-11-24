package pl.dawid.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request,
                        HttpServletResponse response)
            throws IOException {
        PrintWriter pw = response.getWriter();
        pw.println("<HTML><HEAD>");
        pw.println("<meta charset=\"UTF-8\">");
        pw.println("<TITLE><font color=\"red\">Komis u Dawida</font></TITLE>");
        pw.println("</HEAD><BODY>");
        pw.println("<H3>Hello Komisśćźż!</H3>");
        pw.println("</BODY></HTML>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
