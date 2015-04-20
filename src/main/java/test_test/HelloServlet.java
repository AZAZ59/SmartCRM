package test_test;

import test_test.services.Variables;

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
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Grand on 03.03.2015.
 */
//@WebServlet(name = "hello", urlPatterns = "/")
@WebServlet(name = "hello", urlPatterns = "/servlet")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaBasicsTutorial");

        EntityManager em = emf.createEntityManager();
        Variables.em = em;
        resp.getWriter().println("HEEELOOO");
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        University university = new University();
        Group group = new Group();
        Group group2 = new Group();
        Set<Group> groupSet = new HashSet<Group>();
        Set<User> userSet = new HashSet<User>();
        User user = new User();
        UserRights userRights = new UserRights();

        user.setName("AZAZ");
        user.setGroup(group);
        user.setPassword("123");

        userRights.setRights(1);
        userRights.setUser(user);
        user.setRights(userRights);

        university.setName("SSAU");

        group.setNameGroup("123");
        group.setUniversity(university);

        group2.setNameGroup("second");
        group2.setUniversity(university);

        groupSet.add(group);
        groupSet.add(group2);
        userSet.add(user);

        group.setUsers(userSet);

        university.setGroups(groupSet);
        em.persist(user);
        em.persist(userRights);
        em.persist(group);
        em.persist(group2);
        em.persist(university);

        transaction.commit();
        /*
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

        test_test.services.UniversityService parserv = new test_test.services.UniversityService(em);
        resp.getWriter().println("--- Create and persist parent ---");
        transaction = em.getTransaction();
        transaction.begin();
        test_test.University parent = parserv.createParent(1, "NameParent", "Child1", "Child2");
        transaction.commit();
        resp.getWriter().println(String.format("Persisted: %s\n", parent));

        resp.getWriter().println("--- Find parent ---");
        parent = parserv.findParent(1);
        resp.getWriter().println(String.format("Found: %s\n", parent));

        resp.getWriter().println("--- Find all parents ---");
        List<test_test.University> parents = parserv.findAllParents();
        for (test_test.University foundParent : parents) {
            resp.getWriter().println(String.format("Found: %s\n", foundParent));
        }

        resp.getWriter().println("--- Update parent ---");
        transaction.begin();
        parent = parserv.changeChild1Name(1, "Indie Rock");
        transaction.commit();
        resp.getWriter().println(String.format("Updated: %s\n", parent));

        resp.getWriter().println("--- Remove parent ---");
        transaction.begin();
        parserv.removeParent(1);
        transaction.commit();
        parent = parserv.findParent(1);
        resp.getWriter().println(String.format("Found: %s\n", parent));
        

        resp.getWriter().println("<b> Hello World!! </b>");*/
    }


}
