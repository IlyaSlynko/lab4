package org.dstu.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Bird {
    private int id;
    private String name;
    private Integer age;
    private Boolean isMale;
    private Boolean isFlying;
    private Boolean isMigrating;
    private Genus genus;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genus_id")
    public Genus getGenus() {
        return genus;
    }

    public void setGenus(Genus genus) {
        this.genus = genus;
    }


    @Basic
    @Column(name = "is_migrating")
    public Boolean getMigrating() {
        return isMigrating;
    }

    public void setMigrating(Boolean migrating) {
        isMigrating = migrating;
    }

    @Basic
    @Column(name = "is_male")
    public Boolean getMale() {
        return isMale;
    }

    public void setMale(Boolean isMale) {
        this.isMale = isMale;
    }

    @Basic
    @Column(name = "is_flying")
    public Boolean getFlying() {
        return isFlying;
    }

    public void setFlying(Boolean isFlying) {
        this.isFlying = isFlying;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bird bird = (Bird) o;
        return id == bird.id && name.equals(bird.name) && age.equals(bird.age) && isMale.equals(bird.isMale) && isFlying.equals(bird.isFlying) && isMigrating.equals(bird.isMigrating) && genus.equals(bird.genus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, isMale, isFlying, isMigrating);
    }
}