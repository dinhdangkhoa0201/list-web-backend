package com.cms.listwebbackend.repositories;

import com.cms.listwebbackend.entities.MenuEntity;
import com.cms.listwebbackend.repositories.customs.MenuRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Long>, MenuRepositoryCustom {
    MenuEntity findByCode(String code);

    @Query(value = "UPDATE MenuEntity m SET m.indexId = :indexId WHERE m.id = :id")
    int updateIndexIdById(@Param("id") Long id, @Param("indexId") int indexId);

}
