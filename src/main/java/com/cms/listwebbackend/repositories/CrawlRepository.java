package com.cms.listwebbackend.repositories;

import com.cms.listwebbackend.entities.CrawlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrawlRepository extends JpaRepository<CrawlEntity, Long> {
}
