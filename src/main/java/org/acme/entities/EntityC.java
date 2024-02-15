package org.acme.entities;

import jakarta.persistence.Entity;
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
public class EntityC {

    @Id
    @GeneratedValue
    public Long id;

    @Version
    public Long version;

    @JoinColumn
    @ManyToOne
    public EntityBLazy entityBLazy;

}
