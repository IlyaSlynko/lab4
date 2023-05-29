package org.dstu.dao;

import org.dstu.domain.Bird;

public class BirdDao extends BaseDaoImpl <Bird, Integer> {
    public BirdDao() {
        super(Bird.class);
    }
}
