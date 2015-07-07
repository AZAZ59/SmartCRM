package CRM.rest;/**
 * Created by azaz on 07.07.15.
 */

import CRM.Variables;
import CRM.model.User;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class UserREST {
    private EntityManager em = Variables.getInstance().em;

    @GET
    @Path("all")//TODO set a methodName
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> list() {
        return em.createQuery("from user").getResultList();
    }

    @GET
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    public String create(
            @QueryParam("name")String name,
            @QueryParam("login")String login,
            @QueryParam("password")String password,
            @QueryParam("userType")String userType
    ){
        return "nullll";
    }


}