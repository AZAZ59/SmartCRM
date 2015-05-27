package com.avilyne.rest.resource;

import test_test.Group;
import test_test.User;
import test_test.UserRights;
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

@Path("/user")
public class UserService {
    private EntityManager em = Variables.em;

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> findAllParents() {
        TypedQuery<User> query = em.createQuery("SELECT a FROM  user a", User.class);
        return query.getResultList();
    }

    @GET
    @Path("byId")
    @Produces(MediaType.APPLICATION_JSON)
    public User findUser(@QueryParam("id") int id) {
        TypedQuery<User> query = em.createQuery("SELECT a FROM  user a where id=" + id, User.class);
        return query.getSingleResult();
    }

    @GET
    @Path("byName")
    @Produces(MediaType.APPLICATION_JSON)
    public User findUserByName(@QueryParam("name") String name) {
        TypedQuery<User> query = em.createQuery("SELECT a FROM  user a where a.name like \'" + name + "\'", User.class);
        return query.getSingleResult();
    }

    @GET
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    public User createUser(
            @QueryParam("name") String name,
            @QueryParam("pass") String pass,
            @QueryParam("rights") int rights,
            @QueryParam("id_group") int id
    ) {
        EntityTransaction transaction = em.getTransaction();
        Group g = em.find(Group.class, id);
        UserRights ur = new UserRights();
        User user = new User();

        transaction.begin();
        {
            ur.setRights(rights);
            ur.setUser(user);
            user.setName(name);
            user.setPassword(pass);
            user.setGroup(g);
            user.setRights(ur);

            em.persist(ur);
            em.persist(user);
        }
        transaction.commit();
        return user;
    }

    @GET
    @Path("createOut")
    @Produces(MediaType.APPLICATION_JSON)
    public User createUser(
            @QueryParam("name") String name,
            @QueryParam("pass") String pass
    ) {
        EntityTransaction transaction = em.getTransaction();
        Group g = em.find(Group.class, 1);
        UserRights ur = new UserRights();
        User user = new User();

        transaction.begin();
        {
            ur.setUser(user);
            user.setName(name);
            user.setPassword(pass);
            user.setGroup(g);
            user.setRights(ur);

            em.persist(ur);
            em.persist(user);
        }
        transaction.commit();
        return user;
    }



    @GET
    @Path("remove")
    @Produces(MediaType.APPLICATION_JSON)
    public String removeUser(@QueryParam("id") int id) {
        em.getTransaction().begin();
        try {
            em.remove(em.find(User.class, id));
        } catch (Exception e) {
            em.getTransaction().rollback();
            return "Not Removed";
        }
        em.getTransaction().commit();
        return "Removed";
    }
}
