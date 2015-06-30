package CRM.model;

import CRM.Variables.Variables;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    }

    @Override
    public void init() throws ServletException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaBasicsTutorial");

        EntityManager em = emf.createEntityManager();
        Variables.em = em;
        System.err.println("HEEELOOO");
  /*      EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        University university = new University();
        University university2 = new University();
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
        university2.setName("SSAU_2");

        group.setNameGroup("6212");
        group.setUniversity(university);

        group2.setNameGroup("6213");
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
        em.persist(university2);


        transaction.commit();

        RaspService serv = new RaspService();
        serv.addRasp(1, 1, "315-15/519-14", "ОПЕРАЦИОННЫЕ СИСТЕМЫ/Практикум на ЭВМ", Type.Laboratory.toString(), "", "SSAU", "6212", "false");
        serv.addRasp(2, 1, "315-15/519-14", "ОПЕРАЦИОННЫЕ СИСТЕМЫ/Практикум на ЭВМ", Type.Laboratory.toString(), "", "SSAU", "6212", "false");
        serv.addRasp(3, 1, "423-14", "ДИФФЕРЕНЦИАЛЬНЫЕ И РАЗНОСТНЫЕ УРАВНЕНИЯ", Type.Practice.toString(), "", "SSAU", "6212", "false");
        //понедельник

        serv.addRasp(2, 2, "423-14", "ТЕОРИЯ АВТОМАТОВ И ФОРМАЛЬНЫХ ЯЗЫКОВ", Type.Lectory.toString(), "Чигарина", "SSAU", "6212", "false");
        serv.addRasp(3, 2, "419-14", "ТЕОРИЯ АВТОМАТОВ И ФОРМАЛЬНЫХ ЯЗЫКОВ", Type.Practice.toString(), "", "SSAU", "6212", "false");
        //вторник

        serv.addRasp(2, 3, "Спорткомплекс", "Физкультура", Type.Practice.toString(), "", "SSAU", "6212", "false");
        serv.addRasp(3, 3, "503-14", "ОПЕРАЦИОННЫЕ СИСТЕМЫ", Type.Lectory.toString(), "проф. Востокин С. В.", "SSAU", "6212", "false");
        serv.addRasp(4, 3, "513-14", "ДИФФЕРЕНЦИАЛЬНЫЕ И РАЗНОСТНЫЕ УРАВНЕНИЯ", Type.Lectory.toString(), "проф. Щепакина Е. А.", "SSAU", "6212", "false");
        serv.addRasp(5, 3, "503-14", "БЕЗОПАСНОСТЬ ЖИЗНЕДЕЯТЕЛЬНОСТИ", Type.Lectory.toString(), "Терентьев А. В.", "SSAU", "6212", "false");
        //среда

        serv.addRasp(1, 4, "Военная Кафедра", "", Type.Practice.toString(), "", "SSAU", "6212", "false");
        serv.addRasp(2, 4, "Военная Кафедра", "", Type.Practice.toString(), "", "SSAU", "6212", "false");
        serv.addRasp(3, 4, "Военная Кафедра", "", Type.Practice.toString(), "", "SSAU", "6212", "false");
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
        serv.addRasp(4, 7, "423-14", "Дифференциальные и разностные уравнения", Type.Lectory.toString(), "", "SSAU", "6212", "true");
        serv.addRasp(5, 7, "406-3", "Физика", Type.Laboratory.toString(), "", "SSAU", "6212", "true");
        serv.addRasp(6, 7, "406-3", "Физика", Type.Laboratory.toString(), "", "SSAU", "6212", "true");
        //понедельник

        serv.addRasp(4, 2 + 6, "Теория автоматов и формальных языков", "", Type.Practice.toString(), "", "SSAU", "6212", "true");
        serv.addRasp(5, 2+6, "306-15", "ОПЕРАЦИОННЫЕ СИСТЕМЫ", Type.Laboratory.toString(), "", "SSAU", "6212", "true");
        serv.addRasp(5, 2+6, "314-15", "Теория автоматов и формальных языков", Type.Laboratory.toString(), "", "SSAU", "6212", "true");
        serv.addRasp(6, 2+6, "306-15", "ОПЕРАЦИОННЫЕ СИСТЕМЫ", Type.Laboratory.toString(), "", "SSAU", "6212", "true");
        serv.addRasp(6, 2+6, "314-15", "Теория автоматов и формальных языков", Type.Laboratory.toString(), "", "SSAU", "6212", "true");
        //вторник

        serv.addRasp(2, 3+6, "Спорткомплекс", "Физкультура", Type.Practice.toString(), "", "SSAU", "6212", "true");
        serv.addRasp(3, 3+6, "513-14", "ОПЕРАЦИОННЫЕ СИСТЕМЫ", Type.Lectory.toString(), "проф. Востокин С. В.", "SSAU", "6212", "true");
        serv.addRasp(4, 3+6, "513-14", "ДИФФЕРЕНЦИАЛЬНЫЕ И РАЗНОСТНЫЕ УРАВНЕНИЯ", Type.Lectory.toString(), "проф. Щепакина Е. А.", "SSAU", "6212", "true");
        serv.addRasp(5, 3 + 6, "513-14", "Физика", Type.Lectory.toString(), "", "SSAU", "6212", "true");
        //среда

        serv.addRasp(1, 4 + 6, "401-14", "Безопасность жизнедеятельности", Type.Laboratory.toString(), "", "SSAU", "6212", "true");
        serv.addRasp(2, 4 + 6, "401-14", "Безопасность жизнедеятельности", Type.Laboratory.toString(), "", "SSAU", "6212", "true");
        serv.addRasp(5, 4 + 6, "519-14", "Практикум на ЭВМ", Type.Laboratory.toString(), "", "SSAU", "6212", "true");
        serv.addRasp(6, 4 + 6, "519-14", "Практикум на ЭВМ", Type.Laboratory.toString(), "", "SSAU", "6212", "true");
        //четверг

        serv.addRasp(4, 5 + 6, "505-14", "Физика", Type.Practice.toString(), "", "SSAU", "6212", "true");
        serv.addRasp(5, 5 + 6, "505a-14", "Правоведение", Type.Practice.toString(), "", "SSAU", "6212", "true");
        serv.addRasp(6, 5 + 6, "Физкультура", "Физкультура", Type.Practice.toString(), "", "SSAU", "6212", "true");
        //пятница

        serv.addRasp(2, 6 + 6, "430-14", "ТЕОРИЯ ВЕРОЯТНОСТЕЙ И МАТЕМАТИЧЕСКАЯ СТАТИСТИКА (ВАРИАТИВНАЯ ЧАСТЬ)", Type.Laboratory.toString(), "", "SSAU", "6212", "true");
        serv.addRasp(3, 6 + 6, "430-14", "ТЕОРИЯ ВЕРОЯТНОСТЕЙ И МАТЕМАТИЧЕСКАЯ СТАТИСТИКА (ВАРИАТИВНАЯ ЧАСТЬ)", Type.Laboratory.toString(), "", "SSAU", "6212", "true");
        //суббота

//6213

        serv.addRasp(2, 1, "315-15/519-14", "ДИФФЕРЕНЦИАЛЬНЫЕ И РАЗНОСТНЫЕ УРАВНЕНИЯ", Type.Laboratory.toString(), "", "SSAU", "6213", "false");
        serv.addRasp(3, 1, "315-15/519-14", "ОПЕРАЦИОННЫЕ СИСТЕМЫ/Практикум на ЭВМ", Type.Laboratory.toString(), "", "SSAU", "6213", "false");
        serv.addRasp(4, 1, "423-14", "ОПЕРАЦИОННЫЕ СИСТЕМЫ/Практикум на ЭВМ", Type.Practice.toString(), "", "SSAU", "6213", "false");
        //понедельник

        serv.addRasp(2, 2, "423-14", "ТЕОРИЯ АВТОМАТОВ И ФОРМАЛЬНЫХ ЯЗЫКОВ", Type.Lectory.toString(), "Чигарина", "SSAU", "6213", "false");
        serv.addRasp(3, 2, "425-14", "Физика", Type.Lectory.toString(), "Чигарина", "SSAU", "6213", "false");
        serv.addRasp(4, 2, "419-14", "ТЕОРИЯ АВТОМАТОВ И ФОРМАЛЬНЫХ ЯЗЫКОВ", Type.Practice.toString(), "", "SSAU", "6213", "false");
        //вторник

        serv.addRasp(2, 3, "Спорткомплекс", "Физкультура", Type.Practice.toString(), "", "SSAU", "6213", "false");
        serv.addRasp(3, 3, "503-14", "ОПЕРАЦИОННЫЕ СИСТЕМЫ", Type.Lectory.toString(), "проф. Востокин С. В.", "SSAU", "6213", "false");
        serv.addRasp(4, 3, "513-14", "ДИФФЕРЕНЦИАЛЬНЫЕ И РАЗНОСТНЫЕ УРАВНЕНИЯ", Type.Lectory.toString(), "проф. Щепакина Е. А.", "SSAU", "6213", "false");
        serv.addRasp(5, 3, "503-14", "БЕЗОПАСНОСТЬ ЖИЗНЕДЕЯТЕЛЬНОСТИ", Type.Lectory.toString(), "Терентьев А. В.", "SSAU", "6213", "false");
        //среда

        serv.addRasp(1, 4, "Военная Кафедра", "", Type.Practice.toString(), "", "SSAU", "6213", "false");
        serv.addRasp(2, 4, "Военная Кафедра", "", Type.Practice.toString(), "", "SSAU", "6213", "false");
        serv.addRasp(3, 4, "Военная Кафедра", "", Type.Practice.toString(), "", "SSAU", "6213", "false");
        //четверг

        serv.addRasp(4, 5, "430-14", "Физика", Type.Lectory.toString(), "доц. Шацкий А. В.", "SSAU", "6213", "false");
        serv.addRasp(5, 5, "430-14", "ПРАВОВЕДЕНИЕ", Type.Lectory.toString(), "доц. Олиндер Н. В.", "SSAU", "6213", "false");
        serv.addRasp(6, 5, "Спорткомплекс", "Физкультура", Type.Practice.toString(), "", "SSAU", "6213", "false");
        //пятница

        serv.addRasp(1, 6, "430-14", "Теория вероятностей и математическая статистика (вариативная часть)", Type.Practice.toString(), "Орлова И. С.", "SSAU", "6213", "false");
        serv.addRasp(2, 6, "431-14", "Правоведение", Type.Practice.toString(), "", "SSAU", "6213", "false");
        serv.addRasp(3, 6, "430-14", "Теория вероятностей и математическая статистика (вариативная часть)", Type.Practice.toString(), "Орлова И. С.", "SSAU", "6213", "false");

        //суббота
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        serv.addRasp(3, 7, "406-3", "Физика", Type.Laboratory.toString(), "", "SSAU", "6213", "true");
        serv.addRasp(4, 7, "406-3", "Физика", Type.Laboratory.toString(), "", "SSAU", "6213", "true");
        serv.addRasp(5, 7, "423-14", "Дифференциальные и разностные уравнения", Type.Lectory.toString(), "", "SSAU", "6213", "true");

        //понедельник

        serv.addRasp(4, 2 + 6,  "314-15,306-15", "Теория автоматов и формальных языков/ОПЕРАЦИОННЫЕ СИСТЕМЫ", Type.Practice.toString(), "", "SSAU", "6213", "true");
        serv.addRasp(4, 2 + 6,  "314-15,306-15", "Теория автоматов и формальных языков/ОПЕРАЦИОННЫЕ СИСТЕМЫ", Type.Practice.toString(), "", "SSAU", "6213", "true");
        serv.addRasp(6, 2+6, "419-14", "Теория автоматов и формальных языков", Type.Laboratory.toString(), "", "SSAU", "6213", "true");
        //вторник

        serv.addRasp(2, 3+6, "Спорткомплекс", "Физкультура", Type.Practice.toString(), "", "SSAU", "6213", "true");
        serv.addRasp(3, 3+6, "513-14", "ОПЕРАЦИОННЫЕ СИСТЕМЫ", Type.Lectory.toString(), "проф. Востокин С. В.", "SSAU", "6213", "true");
        serv.addRasp(4, 3+6, "513-14", "ДИФФЕРЕНЦИАЛЬНЫЕ И РАЗНОСТНЫЕ УРАВНЕНИЯ", Type.Lectory.toString(), "проф. Щепакина Е. А.", "SSAU", "6213", "true");
        serv.addRasp(5, 3 + 6, "513-14", "Физика", Type.Lectory.toString(), "", "SSAU", "6213", "true");
        //среда

        serv.addRasp(3, 4 + 6, "519-14/401-14", "Практикум на ЭВМ/Безопасность жизнедеятельности", Type.Laboratory.toString(), "", "SSAU", "6213", "true");
        serv.addRasp(4, 4 + 6, "519-14/401-14", "Практикум на ЭВМ/Безопасность жизнедеятельности", Type.Laboratory.toString(), "", "SSAU", "6213", "true");

        //четверг

        serv.addRasp(4, 5 + 6, "505а-14", "Правоведение", Type.Practice.toString(), "", "SSAU", "6213", "true");
        serv.addRasp(5, 5 + 6, "505-14", "Физика", Type.Practice.toString(), "", "SSAU", "6213", "true");
        serv.addRasp(6, 5 + 6, "Физкультура", "Физкультура", Type.Practice.toString(), "", "SSAU", "6213", "true");
        //пятница

        serv.addRasp(1, 6 + 6, "430-14", "ТЕОРИЯ ВЕРОЯТНОСТЕЙ И МАТЕМАТИЧЕСКАЯ СТАТИСТИКА (ВАРИАТИВНАЯ ЧАСТЬ)", Type.Laboratory.toString(), "", "SSAU", "6213", "true");
        serv.addRasp(3, 6 + 6, "430-14", "ТЕОРИЯ ВЕРОЯТНОСТЕЙ И МАТЕМАТИЧЕСКАЯ СТАТИСТИКА (ВАРИАТИВНАЯ ЧАСТЬ)", Type.Laboratory.toString(), "", "SSAU", "6213", "true");
        //суббота
*/
    }
}
