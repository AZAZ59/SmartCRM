package com.avilyne.rest.resource;

import test_test.Group;
import test_test.Rasp;
import test_test.Type;
import test_test.University;
import test_test.services.Variables;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Grand on 09.04.2015.
 */

@Path("/rasp")
public class RaspService {
    private EntityManager em = Variables.em;

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rasp> findAllParents() {
        //em = Variables.em;
        TypedQuery<Rasp> query = em.createQuery("SELECT a FROM  rasp a", Rasp.class);
        return query.getResultList();
    }

    @GET
    @Path("byGroupId")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rasp> findRasp(@QueryParam("id") int id) {
        TypedQuery<Rasp> query = em.createQuery("SELECT a FROM  rasp a where a.group.id=" + id, Rasp.class);
        return query.getResultList();
    }

    @GET
    @Path("byUniversity")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rasp> findUserByName(@QueryParam("university") String name) {
        TypedQuery<Rasp> query = em.createQuery("SELECT a FROM  rasp a where a.university.name like \'" + name + "\'", Rasp.class);
        return query.getResultList();
    }

    @GET
    @Path("byUniversityAndGroup")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rasp> findUserByName(@QueryParam("university") String name, @QueryParam("gropu") String name_group) {
        TypedQuery<Rasp> query = em.createQuery(
                "SELECT a FROM  rasp a where" +
                        " a.university.name like \'" + name + "\'" +
                        "and a.group.nameGroup like \'" + name_group + "\'", Rasp.class);
        return query.getResultList();
    }

    @GET
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)
    public Rasp addRasp(
            @QueryParam("university") String name_univ,
            @QueryParam("group") String name_group,
            @QueryParam("name") String name,
            @QueryParam("odd") String odd,
            @QueryParam("number_of_pair") int number,
            @QueryParam("type") String type,
            @QueryParam("teacher") String teacher
    ) {
        EntityTransaction transaction = em.getTransaction();
        University u = em.createQuery(
                "select u from university u where u.name=:name", University.class
        ).setParameter("name", name_univ).getSingleResult();
        Group g = em.createQuery(
                "select g from group g where g.nameGroup=:name", Group.class
        ).setParameter("name", name_group).getSingleResult();
        Type t = Type.valueOf(type);
        transaction.begin();
        Rasp r = new Rasp();

        r.setGroup(g);
        r.setUniversity(u);
        r.setName_pair(name);
        r.setNumber_of_pair(number);
        r.setOdd(Boolean.parseBoolean(odd.toLowerCase()));
        r.setType(t);
        r.setTeacher(teacher);
        em.persist(r);
        transaction.commit();
        return r;
    }


    public Rasp addRasp_2(
            String name_univ,
            String name_group,
            String name,
            String odd,
            int number,
            String type
    ) {
        EntityTransaction transaction = em.getTransaction();
        University u = em.createQuery(
                "select u from university u where u.name=:name", University.class
        ).setParameter("name", name_univ).getSingleResult();
        Group g = em.createQuery(
                "select g from group g where g.nameGroup=:name", Group.class
        ).setParameter("name", name_group).getSingleResult();
        Type t = Type.valueOf(type);
        transaction.begin();
        Rasp r = new Rasp();

        r.setGroup(g);
        r.setUniversity(u);
        r.setName_pair(name);
        r.setNumber_of_pair(number);
        r.setOdd(Boolean.parseBoolean(odd.toLowerCase()));
        r.setType(t);

        em.persist(r);
        transaction.commit();
        return r;
    }

    @GET
    @Path("remove")
    @Produces(MediaType.APPLICATION_JSON)
    public String removeRasp(@QueryParam("id") int id) {
        em.getTransaction().begin();
        try {
            em.remove(em.find(Rasp.class, id));
        } catch (Exception e) {
            em.getTransaction().rollback();
            return "Not Removed";
        }
        em.getTransaction().commit();
        /*Query query =em.createQuery("DELETE FROM group g where id="+id);*/
        //if(query.executeUpdate()==0)return "Not Removed";
        return "Removed";
    }
}
