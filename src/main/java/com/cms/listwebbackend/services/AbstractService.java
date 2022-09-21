package com.cms.listwebbackend.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractService {

    @PersistenceContext
    protected EntityManager entityManager;
}
