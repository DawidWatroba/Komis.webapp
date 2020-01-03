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

@WebServlet(urlPatterns = "/delete_client")
public class DeleteClientServlet extends HttpServlet {
    @Resource(name="jdbc:komis")
    DataSource dataSource;
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String client = req.getParameter("client");
        getServletContext().log(client);
        String[]splittedClient = client.split(" ");
        String name = splittedClient[0];
        String surname = splittedClient[1];
        ClientDataDAO dao = new ClientDataDAOImpl();
        try{
            dao.removeClient(name, surname, dataSource);
            req.getRequestDispatcher("read_users").forward(req,res);
        }catch(Exception e){
            throw new ServletException("Błąd", e);
        }
    }
}
