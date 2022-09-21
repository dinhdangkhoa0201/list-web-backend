package com.cms.listwebbackend.repositories;

import com.cms.listwebbackend.entities.TopicEntity;
import com.cms.listwebbackend.repositories.customs.TopicRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<TopicEntity, Long>, TopicRepositoryCustom {
}
