package org.dstu.dao;

import org.dstu.domain.Genus;

public class GenusDao extends BaseDaoImpl<Genus, Integer> {
    public GenusDao() {
        super(Genus.class);
    }
}
