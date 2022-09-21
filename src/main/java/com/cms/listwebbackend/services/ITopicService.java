package com.cms.listwebbackend.services;

import com.cms.listwebbackend.models.TopicModel;
import com.cms.listwebbackend.requests.CriteriaRequest;
import com.cms.listwebbackend.requests.TopicRequest;
import com.cms.listwebbackend.results.DataTable;
import com.cms.listwebbackend.results.ObjectResult;

public interface ITopicService {
    ObjectResult<TopicModel> save(TopicRequest request);

    ObjectResult<TopicModel> update(Long id, TopicRequest request);

    ObjectResult<TopicModel> findById(Long id);

    ObjectResult<TopicModel> findAll();

    DataTable<TopicModel> findByCriteria(CriteriaRequest request);

    ObjectResult<TopicModel> delete(Long id);
}
