package com.cms.listwebbackend.services.impls;

import com.cms.listwebbackend.models.CrawlModel;
import com.cms.listwebbackend.requests.CrawlRequest;
import com.cms.listwebbackend.results.ObjectResult;
import com.cms.listwebbackend.services.ICrawlService;
import org.springframework.stereotype.Service;

@Service
public class CrawlService implements ICrawlService {
    @Override
    public ObjectResult<CrawlModel> save(CrawlRequest request) {
        return null;
    }

    @Override
    public ObjectResult<CrawlModel> update(CrawlRequest request) {
        return null;
    }

    @Override
    public ObjectResult<CrawlModel> findAll() {
        return null;
    }

    @Override
    public ObjectResult<Object> delete(Long id) {
        return null;
    }
}
