package com.cms.listwebbackend.repositories.customs;

import com.cms.listwebbackend.entities.UserCollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserCollectionRepository extends JpaRepository<UserCollectionEntity, Long> {

    @Query(value = "SELECT uc FROM UserCollectionEntity uc WHERE uc.user.id = :userId")
    List<UserCollectionEntity> findByUser(@Param("userId") Long userId);
}
