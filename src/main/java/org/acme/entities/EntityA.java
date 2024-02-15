package org.acme.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
public class EntityA {

    @Id
    @GeneratedValue
    public Long id;

    @Version
    public Long version;

}
