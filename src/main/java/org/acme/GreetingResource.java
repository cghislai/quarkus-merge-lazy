package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.entities.EntityA;
import org.acme.entities.EntityBEager;
import org.acme.entities.EntityBLazy;
import org.acme.entities.EntityC;
import org.acme.services.ServiceA;
import org.acme.services.ServiceB;
import org.acme.services.ServiceC;

@Path("/hello")
public class GreetingResource {

    @Inject
    ServiceA serviceA;
    @Inject
    ServiceB serviceB;
    @Inject
    ServiceC serviceC;

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        EntityA entityA = serviceA.createEntityA();
        entityA = serviceA.doSomething(entityA);

        EntityBEager entityBEager = serviceB.createEntityBEager(entityA);
        entityBEager = serviceB.doSomething(entityBEager);

        EntityBLazy entityBLazy = serviceB.createEntityBLazy(entityA);
//        entityBLazy = serviceB.doSomething(entityBLazy);

        EntityC entityC = serviceC.createEntityC(entityBLazy);
        entityC = serviceC.doSomething(entityC);

        return "ok";
    }
}
