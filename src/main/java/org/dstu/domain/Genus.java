package org.dstu.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Genus {
    private int id;
    private String name;
    private Set<Mammal> mammals = new LinkedHashSet<>();
    private Set<Bird> birds =new LinkedHashSet<>();

    @Basic
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


    @OneToMany(mappedBy = "genus")
    public Set<Mammal> getMammals() {
        return mammals;
    }

    public void setMammals(Set<Mammal> mammals) {
        this.mammals = mammals;
    }

    @OneToMany(mappedBy = "genus")
    public Set<Bird> getBirds() {
        return birds;
    }

    public void setBirds(Set<Bird> birds) {
        this.birds = birds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genus genus = (Genus) o;
        return id == genus.id && name.equals(genus.name) && Objects.equals(mammals, genus.mammals) && Objects.equals(birds, genus.birds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mammals, birds);
    }
}
