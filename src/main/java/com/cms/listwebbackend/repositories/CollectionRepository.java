package com.cms.listwebbackend.repositories;

import com.cms.listwebbackend.entities.CollectionEntity;
import com.cms.listwebbackend.repositories.customs.CollectionRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionRepository extends JpaRepository<CollectionEntity, Long>, CollectionRepositoryCustom {
}
