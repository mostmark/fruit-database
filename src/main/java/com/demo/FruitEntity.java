package com.demo;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Cacheable
public class FruitEntity extends PanacheEntityBase {

    @Id
    @SequenceGenerator(
            name = "fruitSequence",
            sequenceName = "fruit_id_seq",
            allocationSize = 1,
            initialValue = 4)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fruitSequence")
    public Long id;

    @Column(length = 40, unique = true)
    public String name;

    public FruitEntity() {
    }

    public FruitEntity(String name) {
        this.name = name;
    }
}
