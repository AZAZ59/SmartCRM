import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Grand on 03.03.2015.
 */
@WebServlet(name = "hello", urlPatterns = "/")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaBasicsTutorial");
        EntityManager em = emf.createEntityManager();
        ArtistService service = new ArtistService(em);

        resp.getWriter().println("--- Create and persist artist ---");
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Artist artist = service.createArtist(1, "Franz Ferdinand", "Rock");
        transaction.commit();
        resp.getWriter().println(String.format("Persisted: %s\n", artist));

        resp.getWriter().println("--- Find artist ---");
        artist = service.findArtist(1);
        resp.getWriter().println(String.format("Found: %s\n", artist));

        resp.getWriter().println("--- Find all artists ---");
        List<Artist> artists = service.findAllArtists();
        for (Artist foundArtist : artists) {
            resp.getWriter().println(String.format("Found: %s\n", foundArtist));
        }

        resp.getWriter().println("--- Update artist ---");
        transaction.begin();
        artist = service.changeArtistGenre(1, "Indie Rock");
        transaction.commit();
        resp.getWriter().println(String.format("Updated: %s\n", artist));

        resp.getWriter().println("--- Remove artist ---");
        transaction.begin();
        service.removeArtist(1);
        transaction.commit();
        artist = service.findArtist(1);
        resp.getWriter().println(String.format("Found: %s\n", artist));

        resp.getWriter().println("<b> Hello World!! </b>");
    }


}
