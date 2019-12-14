package pl.dawid.web;

import pl.dawid.web.listeners.SessionCounter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/Komis")
public class ControllerServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String name = req.getParameter("name");
        PrintWriter pw = resp.getWriter();
        pw.println("<HTML lang=\"pl-PL\"><HEAD><meta charset=\"utf-8\">");
        pw.println("<TITLE>Komis u Dawida</TITLE>");
        pw.println("</HEAD><BODY>");
        if(name!=null){
            pw.println("<H3><font color=\"red\">"+name+" witaj w Komisie!</font></H3>");
        }else{
            pw.println("<H3><font color=\"red\">Witaj uzytkowniku Komisu!</font></H3>");
        }
        pw.println("<a href=\"makeForm.html\">Link do wyboru marki</a><br><br>");
        pw.println("<a href=\"userForm.html\">Rejestracja klienta</a><br><br>");
        pw.println("<a href=\"carForm.html\">Dodaj samochod do bazy</a><br><br>");
        pw.println("<br>");
        pw.println("<h5>Liczba aktywnych uzytkownikow: "+ SessionCounter.getCounter()+"<br><br>");
        Object counter = getServletContext().getAttribute("savedClientsCounter");
        if(counter == null) {
            pw.println("Nie dodano uzytkownikow");
        }else{
            pw.println("dodano: "+counter.toString()+" uzytkownikow .");
        }
        pw.println("</h5>");
        pw.println("</BODY></HTML>");


    }
}
