package com.avilyne.rest.resource;

import test_test.University;
import test_test.User;
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
@Path("/user")
public class UserService {

    private EntityManager em;

    @GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserByName(
/*            @PathParam ("name"    ) String name,
            @QueryParam("password") String pass*/
    ) {
        if (em == null) {
            if (Variables.em == null) {
                Variables.em = Persistence.createEntityManagerFactory("JpaBasicsTutorial").createEntityManager();
            }
            em = Variables.em;
        }
        TypedQuery<User> query = em.createQuery("FROM user where name='AZAZ'", User.class);
        User u = query.getSingleResult();
        if (u.getPassword().equals("123")) {
            return u;
        } else return null;
        //return em.find(User.class, name);
    }


    public University findParent(int id) {
        return em.find(University.class, id);
    }

    public List<University> findAllParents() {
        TypedQuery<University> query = em.createQuery("SELECT a FROM university a", University.class);
        return query.getResultList();
    }
}
