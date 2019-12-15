package pl.dawid.web.client;

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
import java.io.PrintWriter;
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
