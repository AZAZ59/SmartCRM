package CRM;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Created by azaz on 30.06.15.
 */
@WebServlet(name = "hello", urlPatterns = "/servlet")
public class MainServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRMPersistanceUnit");
        EntityManager em = emf.createEntityManager();
        Variables.getInstance().em=em;
    }
}
