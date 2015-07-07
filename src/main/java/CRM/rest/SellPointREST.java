package CRM.rest;/**
 * Created by azaz on 07.07.15.
 */

import CRM.Variables;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/SellPoint")
public class SellPointREST {
    private EntityManager em = Variables.getInstance().em;

    @GET
    @Path("all")//TODO set a methodName
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> methodName() {
        return null;
    }

    @GET
    @Path("start")
    @Produces(MediaType.APPLICATION_JSON)
    public String start(
            @QueryParam("SellPointName")String SellPointName,
            @QueryParam("BaristoName") String BaristoName
    ){

        em.getTransaction().begin();

        em.getTransaction().commit();
        return "null -1-1-1-1-1-";
    }



}