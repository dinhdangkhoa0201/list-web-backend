package com.cms.listwebbackend.repositories;

import com.cms.listwebbackend.entities.CollectionWebItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionWebItemRepository extends JpaRepository<CollectionWebItemEntity, Long> {
    @Query(value = "SELECT c FROM CollectionWebItemEntity  c WHERE c.collection.id = :collectionId")
    List<CollectionWebItemEntity> findByCollection(@Param("collectionId") Long collectionId);
}
