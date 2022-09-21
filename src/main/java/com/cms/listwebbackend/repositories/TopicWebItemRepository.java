package com.cms.listwebbackend.repositories;

import com.cms.listwebbackend.entities.TopicWebItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicWebItemRepository extends JpaRepository<TopicWebItemEntity, Long> {

    @Query(value = "SELECT t FROM TopicWebItemEntity t WHERE t.topic.id = :topicId")
    List<TopicWebItemEntity> findByTopicId(@Param("topicId") Long topicId);
}
