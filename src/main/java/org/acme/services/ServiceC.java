package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.acme.entities.EntityBLazy;
import org.acme.entities.EntityC;

@ApplicationScoped
@Transactional
public class ServiceC {


    @Inject
    EntityManager em;
    @Inject
    ServiceB serviceB;

    public EntityC createEntityC(EntityBLazy entityBLazy) {
        EntityC entityC = new EntityC();
        entityC.setEntityBLazy(entityBLazy);
        return em.merge(entityC);
    }

    public EntityC doSomething(EntityC entityC) {
        EntityC managedEntityC = em.merge(entityC);

        serviceB.doSomething(managedEntityC.getEntityBLazy());

        return managedEntityC;
    }
}
