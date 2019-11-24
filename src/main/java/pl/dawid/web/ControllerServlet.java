package pl.dawid.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        PrintWriter pw = resp.getWriter();
        pw.println("<HTML lang=\"pl-PL\"><HEAD><meta charset=\"utf-8\">");
        pw.println("<TITLE>Komis u Dawida</TITLE>");
        pw.println("</HEAD><BODY>");
        if(name!=null){
            pw.println("<H3><font color=\"red\">"+name+" witaj w Komisie!</font></H3>");
        }else{
            pw.println("<H3><font color=\"red\">Witaj użytkowniku Komisu!</font></H3>");
        }
        pw.println("</BODY></HTML>");
        pw.println("<a href=\"makeForm.html\">Link do wyboru marki<?a>");
    }
}
