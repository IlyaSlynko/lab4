package org.dstu.dao;

import org.dstu.domain.Genus;
import org.dstu.domain.Mammal;
import org.hibernate.query.Query;

import java.util.List;

public class MammalDao extends BaseDaoImpl<Mammal, Integer> {
    public MammalDao() {
        super(Mammal.class);
    }

    public List<Mammal> getAllByGroup(Genus genus) {
        Query q = getSession().createQuery("FROM Mammal WHERE Mammal.genus = \"" + genus + "\"");
        return q.list();
    }
}
