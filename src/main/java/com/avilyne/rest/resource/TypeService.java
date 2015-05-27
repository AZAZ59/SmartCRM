package com.avilyne.rest.resource;

import test_test.Type;
import test_test.services.Variables;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Grand on 09.04.2015.
 */

@Path("/type")
public class TypeService {
    private EntityManager em = Variables.em;

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> findAllParents() {
        Type[] a = Type.values();
        List<String> out = new ArrayList<String>();
        for (Type t : a) {
            out.add(t.toString());
        }
        return out;
    }

}
