package pl.dawid.web.servlets;

import pl.dawid.web.dao.ClientDataDAO;
import pl.dawid.web.dao.ClientDataDAOImpl;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = "/edit_user")
public class EditUserServlet extends HttpServlet {

    @Resource(name="jdbc:komis")
    DataSource dataSource;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("id");
        int id = Integer.parseInt(parameter);
        ClientDataDAO dao = new ClientDataDAOImpl();
        try {
            dao.removeClient(id, dataSource);
            req.getRequestDispatcher("edit_user.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException("cannot remove client", e);
        }
    }
}
