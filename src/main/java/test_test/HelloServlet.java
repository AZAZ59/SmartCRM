package test_test;

import com.avilyne.rest.resource.RaspService;
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

        com.avilyne.rest.resource.UniversityService parserv = new com.avilyne.rest.resource.UniversityService(em);
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

    @Override
    public void init() throws ServletException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaBasicsTutorial");

        EntityManager em = emf.createEntityManager();
        Variables.em = em;
        System.err.println("HEEELOOO");
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

        group.setNameGroup("6212");
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

        RaspService serv = new RaspService();
        serv.addRasp(1, 1, "315-15", "ОПЕРАЦИОННЫЕ СИСТЕМЫ", Type.Laboratory.toString(), "", "SSAU", "6212", "false");
        serv.addRasp(1, 1, "519-14", "Практикум на ЭВМ", Type.Laboratory.toString(), "", "SSAU", "6212", "false");
        serv.addRasp(1, 1, "315-15", "ОПЕРАЦИОННЫЕ СИСТЕМЫ", Type.Laboratory.toString(), "", "SSAU", "6212", "false");
        serv.addRasp(1, 1, "519-14", "Практикум на ЭВМ", Type.Laboratory.toString(), "", "SSAU", "6212", "false");
        serv.addRasp(2, 1, "423-14", "ДИФФЕРЕНЦИАЛЬНЫЕ И РАЗНОСТНЫЕ УРАВНЕНИЯ", Type.Practice.toString(), "", "SSAU", "6212", "false");
        //понедельник
/*
        serv.addRasp(2, 2, "423-14", "ТЕОРИЯ АВТОМАТОВ И ФОРМАЛЬНЫХ ЯЗЫКОВ", Type.Lectory.toString(), "Чигарина", "SSAU", "6212", "false");
        serv.addRasp(3, 2, "419-14", "ТЕОРИЯ АВТОМАТОВ И ФОРМАЛЬНЫХ ЯЗЫКОВ", Type.Practice.toString(), "", "SSAU", "6212", "false");
        //вторник

        serv.addRasp(2, 3, "Спорткомплекс", "Физкультура", Type.Practice.toString(), "", "SSAU", "6212", "false");
        serv.addRasp(3, 3, "503-14", "ОПЕРАЦИОННЫЕ СИСТЕМЫ", Type.Lectory.toString(), "проф. Востокин С. В.", "SSAU", "6212", "false");
        serv.addRasp(4, 3, "513-14", "ДИФФЕРЕНЦИАЛЬНЫЕ И РАЗНОСТНЫЕ УРАВНЕНИЯ", Type.Lectory.toString(), "проф. Щепакина Е. А.", "SSAU", "6212", "false");
        serv.addRasp(5, 3, "503-14", "БЕЗОПАСНОСТЬ ЖИЗНЕДЕЯТЕЛЬНОСТИ", Type.Lectory.toString(), "Терентьев А. В.", "SSAU", "6212", "false");
        //среда

        serv.addRasp(1, 4, "Военная Кафедра", "Военная Кафедра", Type.Practice.toString(), "", "SSAU", "6212", "false");
        serv.addRasp(2, 4, "Военная Кафедра", "Военная Кафедра", Type.Practice.toString(), "", "SSAU", "6212", "false");
        serv.addRasp(3, 4, "Военная Кафедра", "Военная Кафедра", Type.Practice.toString(), "", "SSAU", "6212", "false");
        //четверг

        serv.addRasp(3, 5, "421-5", "Физика", Type.Practice.toString(), "доц. Шацкий А. В.", "SSAU", "6212", "false");
        serv.addRasp(4, 5, "430-14", "Физика", Type.Lectory.toString(), "доц. Шацкий А. В.", "SSAU", "6212", "false");
        serv.addRasp(5, 5, "430-14", "ПРАВОВЕДЕНИЕ", Type.Lectory.toString(), "доц. Олиндер Н. В.", "SSAU", "6212", "false");
        serv.addRasp(6, 5, "Спорткомплекс", "Физкультура", Type.Practice.toString(), "", "SSAU", "6212", "false");
        //пятница

        serv.addRasp(1, 6, "430-14", "Теория вероятностей и математическая статистика (вариативная часть)", Type.Practice.toString(), "Орлова И. С.", "SSAU", "6212", "false");
        serv.addRasp(2, 6, "430-14", "Теория вероятностей и математическая статистика (вариативная часть)", Type.Practice.toString(), "Орлова И. С.", "SSAU", "6212", "false");
        serv.addRasp(3, 6, "431-14", "Правоведение", Type.Practice.toString(), "", "SSAU", "6212", "false");
        //суббота
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        serv.addRasp(4, 1+6, "423-14", "Дифференциальные и разностные уравнения", Type.Lectory.toString(), "", "SSAU", "6112", "true");
        serv.addRasp(5, 1+6, "406-3", "Физика", Type.Laboratory.toString(), "", "SSAU", "6112", "true");
        serv.addRasp(6, 1+6, "406-3", "Физика", Type.Laboratory.toString(), "", "SSAU", "6112", "true");
        //понедельник

        serv.addRasp(4, 2+6, "Теория автоматов и формальных языков", "", Type.Practice.toString(), "", "SSAU", "6112", "true");
        serv.addRasp(5, 2+6, "306-15", "ОПЕРАЦИОННЫЕ СИСТЕМЫ", Type.Laboratory.toString(), "", "SSAU", "6212", "true");
        serv.addRasp(5, 2+6, "314-15", "Теория автоматов и формальных языков", Type.Laboratory.toString(), "", "SSAU", "6212", "true");
        serv.addRasp(6, 2+6, "306-15", "ОПЕРАЦИОННЫЕ СИСТЕМЫ", Type.Laboratory.toString(), "", "SSAU", "6212", "true");
        serv.addRasp(6, 2+6, "314-15", "Теория автоматов и формальных языков", Type.Laboratory.toString(), "", "SSAU", "6212", "true");
        //вторник

        serv.addRasp(2, 3+6, "Спорткомплекс", "Физкультура", Type.Practice.toString(), "", "SSAU", "6212", "true");
        serv.addRasp(3, 3+6, "513-14", "ОПЕРАЦИОННЫЕ СИСТЕМЫ", Type.Lectory.toString(), "проф. Востокин С. В.", "SSAU", "6212", "true");
        serv.addRasp(4, 3+6, "513-14", "ДИФФЕРЕНЦИАЛЬНЫЕ И РАЗНОСТНЫЕ УРАВНЕНИЯ", Type.Lectory.toString(), "проф. Щепакина Е. А.", "SSAU", "6212", "true");
        serv.addRasp(5, 3+6, "513-14", "Физика", Type.Lectory.toString(), "", "SSAU", "6112", "true");
        //среда

        serv.addRasp(1, 4+6, "401-14", "Безопасность жизнедеятельности", Type.Laboratory.toString(), "", "SSAU", "6112", "true");
        serv.addRasp(2, 4+6, "401-14", "Безопасность жизнедеятельности", Type.Laboratory.toString(), "", "SSAU", "6112", "true");
        serv.addRasp(5, 4+6, "519-14", "Практикум на ЭВМ", Type.Laboratory.toString(), "", "SSAU", "6112", "true");
        serv.addRasp(6, 4+6, "519-14", "Практикум на ЭВМ", Type.Laboratory.toString(), "", "SSAU", "6112", "true");
        //четверг

        serv.addRasp(4, 5+6, "505-14", "Физика", Type.Practice.toString(), "", "SSAU", "6112", "true");
        serv.addRasp(5, 5+6, "505a-14", "Правоведение", Type.Practice.toString(), "", "SSAU", "6112", "true");
        serv.addRasp(6, 5+6, "Физкультура", "Физкультура", Type.Practice.toString(), "", "SSAU", "6112", "true");
        //пятница

        serv.addRasp(2, 6+6, "430-14", "ТЕОРИЯ ВЕРОЯТНОСТЕЙ И МАТЕМАТИЧЕСКАЯ СТАТИСТИКА (ВАРИАТИВНАЯ ЧАСТЬ)", Type.Laboratory.toString(), "", "SSAU", "6112", "true");
        serv.addRasp(3, 6+6, "430-14", "ТЕОРИЯ ВЕРОЯТНОСТЕЙ И МАТЕМАТИЧЕСКАЯ СТАТИСТИКА (ВАРИАТИВНАЯ ЧАСТЬ)", Type.Laboratory.toString(), "", "SSAU", "6112", "true");
        //суббота
*/

    }
}
