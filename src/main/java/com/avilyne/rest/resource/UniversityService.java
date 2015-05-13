package com.avilyne.rest.resource;

import test_test.University;
import test_test.services.Variables;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by azaz on 09.03.15.
 */
@Path("/university")
public class UniversityService {

    private EntityManager em;

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<University> findAllParents() {
        if (em == null) {
            if (Variables.em == null) {
                Variables.em = Persistence.createEntityManagerFactory("JpaBasicsTutorial").createEntityManager();
            }
            em = Variables.em;
        }
        TypedQuery<University> query = em.createQuery("SELECT a FROM  university a", University.class);
        return query.getResultList();
    }



    /*
    public UniversityService(EntityManager em) {
        this.em = em;
    }

    public University createParent(int id, String name) {
        University parent = new University(id, name);
        em.persist(parent);
        return parent;
    }

    public void removeParent(int id) {
        University parent = em.find(University.class, id);

        if (parent != null) {
            em.remove(parent);
        }
    }

    public University changeChild1Name(int id, String name) {
        University parent = em.find(University.class, id);

        if (parent != null) {
            //parent.setCh1Name(name);
        }

        return parent;
    }

    public University findParent(int id) {
        return em.find(University.class, id);
    }

    public List<University> findAllParents() {
        TypedQuery<University> query = em.createQuery("SELECT a FROM university a", University.class);
        return query.getResultList();
    }*/
}
