package pl.dawid.web.car2;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/add_car")
public class SaveCarInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {
        //teoretycznie powinien przekierować na strone główna????????
        // req.getRequestDispatcher("Komis").forward(req,resp);
        CarBean car = new CarBean();
        String make = req.getParameter("make");
        car.setMake(make);
        //dokonyczy metode
        /*
        poprawić pliki.jsp
    */
}}
/*


 */