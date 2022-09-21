package com.cms.listwebbackend.services;

import com.cms.listwebbackend.models.CrawlModel;
import com.cms.listwebbackend.requests.CrawlRequest;
import com.cms.listwebbackend.results.ObjectResult;

public interface ICrawlService {
    ObjectResult<CrawlModel> save(CrawlRequest request);

    ObjectResult<CrawlModel> update(CrawlRequest request);

    ObjectResult<CrawlModel> findAll();

    ObjectResult<Object> delete(Long id);
}
