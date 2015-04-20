package com.avilyne.rest.resource;

import test_test.Group;
import test_test.services.Variables;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by Grand on 09.04.2015.
 */

@Path("/group")
public class GroupService {
    private EntityManager em;

    //public GroupService(EntityManager em) {
    //    this.em = em;
    //}

    @GET
    @Path("all")
    @Produces("application/json")
    //@Produces(MediaType)
    public List<Group> findAllParents() {
        if (em == null) {
            if (Variables.em == null) {
                Variables.em = Persistence.createEntityManagerFactory("JpaBasicsTutorial").createEntityManager();
            }
            em = Variables.em;
        }
        System.out.println("ASDASDASD");
        //Query q = em.createQuery("select from Group");
        TypedQuery<Group> query = em.createQuery("SELECT a FROM  group a", Group.class);

        return query.getResultList();
    }

    /*public Group createGroup(int id, String name, String genre) {

    }

    public void removeGroup(int id) {

    }

    public Group changeGroupGenre(int id, String genre) {

    }

    public Group findGroup(int id) {

    }

    public List<Group> findAllGroups() {
        
    }*/
}
