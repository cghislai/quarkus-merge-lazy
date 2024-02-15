package org.acme.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EntityBLazy {

    @Id
    @GeneratedValue
    public Long id;

    @Version
    public Long version;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    public EntityA lazyEntityA;

}
