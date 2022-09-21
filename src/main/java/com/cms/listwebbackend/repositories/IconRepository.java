package com.cms.listwebbackend.repositories;

import com.cms.listwebbackend.entities.IconEntity;
import com.cms.listwebbackend.repositories.customs.IconRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IconRepository extends JpaRepository<IconEntity, Long>, IconRepositoryCustom {
}
