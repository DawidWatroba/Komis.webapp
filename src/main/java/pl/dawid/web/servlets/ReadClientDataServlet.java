package pl.dawid.web.servlets;

import pl.dawid.web.Client;
import pl.dawid.web.dao.ClientDataDAO;
import pl.dawid.web.dao.ClientDataDAOImpl;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/read_users")
public class ReadClientDataServlet extends HttpServlet {

    @Resource(name = "jdbc:komis")
    private DataSource ds;
            /*
          te linijki przenosimy wyżej -> @Resource....
            InitialContext initCtx = new InitialContext();
            Context context = (Context) initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource) context.lookup(getServletContext().getInitParameter("dataSource"));
*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        try {
            ClientDataDAO dao = new ClientDataDAOImpl();
            List clients = dao.readClientsData(ds);
            req.setAttribute("clients", clients);
            req.getRequestDispatcher("user_list.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}