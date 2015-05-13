package com.avilyne.rest.resource;

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

@Path("/university")
public class UniversityService {
    private EntityManager em = Variables.em;
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<University> findAllParents() {
        TypedQuery<University> query = em.createQuery("SELECT a FROM  university a", University.class);
        return query.getResultList();
    }

    @GET
    @Path("byId")
    @Produces(MediaType.APPLICATION_JSON)
    public University findUniversity(@QueryParam("id") int id) {
        TypedQuery<University> query = em.createQuery("SELECT a FROM  university a where id=" + id, University.class);
        return query.getSingleResult();
    }

    @GET
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    public University createUniversity(@QueryParam("name") String name) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        University g = new University();
        g.setName(name);
        em.persist(g);
        transaction.commit();
        return g;
    }

    @GET
    @Path("remove")
    @Produces(MediaType.APPLICATION_JSON)
    public String removeUniversity(@QueryParam("id") int id) {
        em.getTransaction().begin();
        try {
            em.remove(em.find(University.class, id));
        } catch (Exception e) {
            em.getTransaction().rollback();
            return "Not Removed";
        }
        em.getTransaction().commit();
        return "Removed";
    }
}
