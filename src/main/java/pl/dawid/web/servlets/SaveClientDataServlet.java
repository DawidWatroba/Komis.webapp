package pl.dawid.web.servlets;

import pl.dawid.web.Client;
import pl.dawid.web.dao.ClientDataDAO;
import pl.dawid.web.dao.ClientDataDAOImpl;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/add_user")
public class SaveClientDataServlet extends HttpServlet {
    @Resource(name = "jdbc:komis")
    private DataSource ds;

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {
        Client client = new Client();
        client.setName(req.getParameter("name"));
        client.setSurname(req.getParameter("surname"));
        client.setAge(Integer.parseInt(req.getParameter("age")));
        client.setRegion(req.getParameter("region"));
        client.setSex(req.getParameter("sex"));

        ClientDataDAO dao = new ClientDataDAOImpl();
        try {
            dao.saveClientData(client, ds);
            //podpunkt g
            req.setAttribute("bla bla", client);
            req.getRequestDispatcher("add_new_client_successfully.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
