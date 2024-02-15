package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.acme.entities.EntityA;

@ApplicationScoped
@Transactional
public class ServiceA {

    @Inject
    EntityManager em;


    public EntityA createEntityA() {
        EntityA entityA = new EntityA();
        return em.merge(entityA);
    }


    public EntityA doSomething(EntityA entityA) {
        return em.merge(entityA);
    }
}
