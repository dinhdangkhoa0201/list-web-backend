package com.cms.listwebbackend.repositories;

import com.cms.listwebbackend.entities.WebItemEntity;
import com.cms.listwebbackend.repositories.customs.WebItemRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebItemRepository extends JpaRepository<WebItemEntity, Long>, WebItemRepositoryCustom {
}
