package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.acme.entities.EntityA;
import org.acme.entities.EntityBEager;
import org.acme.entities.EntityBLazy;
import org.acme.entities.EntityC;
import org.acme.services.ServiceA;
import org.acme.services.ServiceB;
import org.acme.services.ServiceC;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
class LazyLoadingTest {

    @Inject
    ServiceA serviceA;
    @Inject
    ServiceB serviceB;
    @Inject
    ServiceC serviceC;

    @Test
    void testSingleEntity() {
        EntityA entityA = serviceA.createEntityA();
        entityA = serviceA.doSomething(entityA);

        Assertions.assertNotNull(entityA);
    }

    @Test
    void testEntityBHasEagerA() {
        EntityA entityA = serviceA.createEntityA();
        entityA = serviceA.doSomething(entityA);

        EntityBEager entityBEager = serviceB.createEntityBEager(entityA);
        entityBEager = serviceB.doSomething(entityBEager);

        Assertions.assertNotNull(entityBEager);
    }

    @Test
    void testEntityBHasLazyA() {
        EntityA entityA = serviceA.createEntityA();
        entityA = serviceA.doSomething(entityA);

        EntityBLazy entityBLazy = serviceB.createEntityBLazy(entityA);
        entityBLazy = serviceB.doSomething(entityBLazy);

        Assertions.assertNotNull(entityBLazy);
    }

    @Test
    void testEntityCHasEagerBHasLazyA() {
        EntityA entityA = serviceA.createEntityA();
        entityA = serviceA.doSomething(entityA);

        EntityBLazy entityBLazy = serviceB.createEntityBLazy(entityA);

        EntityC entityC = serviceC.createEntityC(entityBLazy);
        entityC = serviceC.doSomething(entityC);

        Assertions.assertNotNull(entityC);
    }

}
