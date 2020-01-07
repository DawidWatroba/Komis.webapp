package pl.dawid.web.servlets;

import pl.dawid.web.ClientBean;
import pl.dawid.web.OrderBean;
import pl.dawid.web.dao.ClientDataDAO;
import pl.dawid.web.dao.ClientDataDAOImpl;
import pl.dawid.web.dao.OrderDAO;
import pl.dawid.web.dao.OrderDAOImpl;

import javax.annotation.Resource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = "/placeOrders")
public class SaveOrderServlet extends HttpServlet {

    @Resource(name = "jdbc:komis")
    private DataSource dataSource;

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) {
        OrderBean order = new OrderBean();
        order.setClientId(Integer.parseInt(req.getParameter("clientId")));
        order.setPart(req.getParameter("part"));
        order.setProfile(req.getParameter("profile"));
        order.setCount(Integer.parseInt(req.getParameter("count")));
        order.setId(Integer.parseInt(req.getParameter("id")));

        OrderDAO dao = new OrderDAOImpl();
        try {
            dao.saveOrder(dataSource, order);
            req.getRequestDispatcher("start_page.jsp").forward(req, resp);
            req.getSession().removeAttribute("klient");
            req.getSession().removeAttribute("order");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}