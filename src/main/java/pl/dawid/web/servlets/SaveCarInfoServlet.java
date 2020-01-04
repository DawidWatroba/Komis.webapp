package pl.dawid.web.servlets;


import pl.dawid.web.CarBean;
import pl.dawid.web.dao.CarInfoDAO;
import pl.dawid.web.dao.CarInfoDAOImpl;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;


@WebServlet(urlPatterns = "/add_car")
public class SaveCarInfoServlet extends HttpServlet {
    @Resource(name = "jdbc:komis")
    private DataSource dataSource;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // logika zapisywania auta

        CarBean car = (CarBean) req.getSession().getAttribute("auto");

        CarInfoDAO dao = new CarInfoDAOImpl();
        dao.saveCarInfo(car, dataSource);
        //usuwanie beana samochodu, żeby nie wyświetlał się
        // przy dodawaniu kolejnego auta w tej samej sesji
        req.getSession().removeAttribute("car");

        req.getRequestDispatcher("start_page.jsp").forward(req, resp);
    }}
/*


 */