package test_test.services;

import test_test.University;
import test_test.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by azaz on 09.03.15.
 */
@Path("/user")
public class UserService {

    private EntityManager em;

    public UserService(EntityManager em) {
        this.em = em;
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserByName(@PathParam("name") String name) {
        if (this.em != null) em = Variables.em;
        return em.find(User.class, name);
    }

    /*@GET
    @Path("/{parameter}")
    public Response responseMsg( @PathParam("parameter") String parameter,
                                 @DefaultValue("Nothing to say") @QueryParam("value") String value) {

        String output = "Hello from: " + parameter + " : " + value;

        return Response.status(200).entity(output).build();
    }*/

    public University findParent(int id) {
        return em.find(University.class, id);
    }

    public List<University> findAllParents() {
        TypedQuery<University> query = em.createQuery("SELECT a FROM university a", University.class);
        return query.getResultList();
    }
}
