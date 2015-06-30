package CRM.resource;

import CRM.Variables.Variables;
import CRM.model.Group;

import javax.persistence.EntityManager;
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

@Path("/group")
public class GroupService {
    private EntityManager em = Variables.em;

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Group> findAllParents() {
        //em = Variables.em;
        TypedQuery<Group> query = em.createQuery("SELECT a FROM  group a", Group.class);
        return query.getResultList();
    }

    @GET
    @Path("byId")
    @Produces(MediaType.APPLICATION_JSON)
    public Group findGroup(@QueryParam("id") int id) {
        TypedQuery<Group> query = em.createQuery("SELECT a FROM  group a where id=" + id, Group.class);
        return query.getSingleResult();
    }

    @GET
    @Path("byName")
    @Produces(MediaType.APPLICATION_JSON)
    public Group findGroup(@QueryParam("name") String name) {
        TypedQuery<Group> query = em.createQuery("SELECT a FROM group a where nameGroup like \'" + name + "\'", Group.class);
        return query.getSingleResult();
    }
    @GET
    @Path("remove")
    @Produces(MediaType.APPLICATION_JSON)
    public String removeGroup(@QueryParam("id") int id) {
        em.getTransaction().begin();
        try {
            em.remove(em.find(Group.class, id));
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
