package com.cms.listwebbackend.services;

import com.cms.listwebbackend.models.WebItemModel;
import com.cms.listwebbackend.requests.CriteriaRequest;
import com.cms.listwebbackend.requests.WebItemRequest;
import com.cms.listwebbackend.results.DataTable;
import com.cms.listwebbackend.results.ObjectResult;

public interface IWebItemService {
    ObjectResult<WebItemModel> save(WebItemRequest request);

    ObjectResult<WebItemModel> update(Long id, WebItemRequest request);

    ObjectResult<WebItemModel> findById(Long id);

    ObjectResult<WebItemModel> findAll();

    ObjectResult<WebItemModel> delete(Long id);

    DataTable<WebItemModel> findByCriteria(CriteriaRequest request);

    ObjectResult<WebItemModel> findByTopicId(Long topicId);

    ObjectResult<WebItemModel> findByCollectionId(Long collectionId);
}
