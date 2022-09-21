package com.cms.listwebbackend.repositories;

import com.cms.listwebbackend.entities.SystemConstantEntity;
import com.cms.listwebbackend.repositories.customs.SystemConstantRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemConstantRepository extends JpaRepository<SystemConstantEntity, Long>, SystemConstantRepositoryCustom {
}
