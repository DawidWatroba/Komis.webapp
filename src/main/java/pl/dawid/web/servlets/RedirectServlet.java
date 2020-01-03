package pl.dawid.web.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/Komis/process")
public class RedirectServlet extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter pw = resp.getWriter();
//        String make = req.getParameter("marka");
//        pw.println(make);
//    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String make = req.getParameter("marka");
        PrintWriter pw = resp.getWriter();
        switch (make) {
            case "Alfa Romeo":
                resp.sendRedirect("https://www.alfaromeo.com/");
                break;
            case "BMW":
                resp.sendRedirect("https://www.bmw.com/en/index.html");
                break;
            case "Honda":
                resp.sendRedirect("https://www.honda.com/");
                break;
            case "Jaguar":
                resp.sendRedirect("https://www.jaguar.pl/");
                break;
            case "Mercedes":
                resp.sendRedirect("https://www.mercedes-benz.pl/passengercars.html");
                break;
            case "Opel":
                resp.sendRedirect("https://www.opel.pl/");
                break;
            default:
                pw.println("<H3><font color=\"red\">ERROR nie wybrałeś marki</font></H3>");

        }
    }
}

