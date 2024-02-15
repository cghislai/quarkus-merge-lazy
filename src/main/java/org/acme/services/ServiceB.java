package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.acme.entities.EntityA;
import org.acme.entities.EntityBEager;
import org.acme.entities.EntityBLazy;

@ApplicationScoped
@Transactional
public class ServiceB {


    @Inject
    EntityManager em;

    public EntityBEager createEntityBEager(EntityA entityA) {
        EntityBEager entityBEager = new EntityBEager();
        entityBEager.setEagerEntityA(entityA);
        return em.merge(entityBEager);
    }

    public EntityBLazy createEntityBLazy(EntityA entityA) {
        EntityBLazy entityBLazy = new EntityBLazy();
        entityBLazy.setLazyEntityA(entityA);
        return em.merge(entityBLazy);
    }

    public EntityBEager doSomething(EntityBEager entityBEager) {
        return em.merge(entityBEager);
    }

    public EntityBLazy doSomething(EntityBLazy entityBLazy) {
        return em.merge(entityBLazy);
    }
}
