package com.cms.listwebbackend.repositories.customs;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractRepository {

    @PersistenceContext
    protected EntityManager entityManager;
}
