package com.avilyne.rest.resource;

import test_test.Group;
import test_test.Message;
import test_test.services.Variables;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

/**
 * Created by Grand on 09.04.2015.
 */

@Path("/message")
public class MessageService {
    private EntityManager em = Variables.em;

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> findAllParents() {
        //em = Variables.em;
        TypedQuery<Message> query = em.createQuery("SELECT a FROM  message a", Message.class);
        return query.getResultList();
    }

    @GET
    @Path("byId")
    @Produces(MediaType.APPLICATION_JSON)
    public Message findMessage(@QueryParam("id") int id) {
        TypedQuery<Message> query = em.createQuery("SELECT a FROM  message a where id=" + id, Message.class);
        return query.getSingleResult();
    }

    @GET
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    public Message createMessage(@QueryParam("text") String message, @QueryParam("group_id") int group_id) {
        EntityTransaction transaction = em.getTransaction();
        //University u = em.createQuery("select u from university u where id=" + univ_id, University.class).getSingleResult();
        Group group = em.find(Group.class, group_id);
        transaction.begin();
        Message m = new Message();
        m.setGroup(group);
        m.setMessage(message);
        m.setDateField(new Date());
        m.setTimeField(new Date());
        em.persist(m);
        transaction.commit();
        return m;
    }

    @GET
    @Path("remove")
    @Produces(MediaType.APPLICATION_JSON)
    public String removeMessage(@QueryParam("id") int id) {
        em.getTransaction().begin();
        try {
            em.remove(em.find(Message.class, id));
        } catch (Exception e) {
            em.getTransaction().rollback();
            return "Not Removed";
        }
        em.getTransaction().commit();
        /*Query query =em.createQuery("DELETE FROM message g where id="+id);*/
        //if(query.executeUpdate()==0)return "Not Removed";
        return "Removed";
    }
}
