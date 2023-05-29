package org.dstu.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Mammal {
    private int id;
    private String name;
    private Integer age;
    private Boolean isMale;
    private Boolean isUpRight;
    private Boolean isSeasonHibernation;
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
    @Column(name = "is_male")
    public Boolean getMale() {
        return isMale;
    }

    public void setMale(Boolean isMale) {
        this.isMale = isMale;
    }

    @Basic
    @Column(name = "is_up_right")
    public Boolean getUpRight() {
        return isUpRight;
    }

    public void setUpRight(Boolean isUpRight) {
        this.isUpRight = isUpRight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mammal mammal = (Mammal) o;
        return id == mammal.id && name.equals(mammal.name) && age.equals(mammal.age) && isMale.equals(mammal.isMale) && isUpRight.equals(mammal.isUpRight) && isSeasonHibernation.equals(mammal.isSeasonHibernation) && genus.equals(mammal.genus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, isMale, isUpRight, isSeasonHibernation);
    }
    @Basic
    @Column(name = "is_season_hibernation")
    public Boolean getSeasonHibernation() {
        return isSeasonHibernation;
    }

    public void setSeasonHibernation(Boolean seasonHibernation) {
        isSeasonHibernation = seasonHibernation;
    }
}



