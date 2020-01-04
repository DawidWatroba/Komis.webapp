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
import javax.smartcardio.CardChannel;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = "/findCarById")
public class FindCarById extends HttpServlet {


    @Resource(name = "jdbc:komis")
    private DataSource dataSource;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int carId = Integer.parseInt(req.getParameter("car_id"));
        CarInfoDAO carDAO = new CarInfoDAOImpl();
        CarBean car = carDAO.findCarById(carId, dataSource);
        req.getSession().setAttribute("auto",car);
        req.getRequestDispatcher("carInfoForm.jsp").forward(req,resp);
    }
}

