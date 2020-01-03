package pl.dawid.web.servlets;

import pl.dawid.web.dao.ClientDataDAO;
import pl.dawid.web.dao.ClientDataDAOImpl;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/delete")
public class DeleteClientPrepServlet extends HttpServlet {

    @Resource(name = "jdbc:komis")
    private DataSource ds;

    @Override
    public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException {
        try {
            ClientDataDAO dao = new ClientDataDAOImpl();
            List clients = dao.readClientsData(ds);
            req.setAttribute("clients", clients);
            req.getRequestDispatcher("deleteForm.jsp").forward(req, res);
    } catch (Exception e) {
        e.printStackTrace();
    }
    }


}
