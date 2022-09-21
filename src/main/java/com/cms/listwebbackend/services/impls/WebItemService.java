package com.cms.listwebbackend.services.impls;

import com.cms.listwebbackend.entities.CollectionWebItemEntity;
import com.cms.listwebbackend.entities.TopicEntity;
import com.cms.listwebbackend.entities.TopicWebItemEntity;
import com.cms.listwebbackend.entities.WebItemEntity;
import com.cms.listwebbackend.enums.ObjectResultStatus;
import com.cms.listwebbackend.models.WebItemModel;
import com.cms.listwebbackend.repositories.CollectionWebItemRepository;
import com.cms.listwebbackend.repositories.TopicRepository;
import com.cms.listwebbackend.repositories.TopicWebItemRepository;
import com.cms.listwebbackend.repositories.WebItemRepository;
import com.cms.listwebbackend.requests.CriteriaRequest;
import com.cms.listwebbackend.requests.WebItemRequest;
import com.cms.listwebbackend.results.DataTable;
import com.cms.listwebbackend.results.ObjectResult;
import com.cms.listwebbackend.services.IWebItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WebItemService implements IWebItemService {

    @Autowired
    private WebItemRepository webItemRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private TopicWebItemRepository topicWebItemRepository;

    @Autowired
    private CollectionWebItemRepository collectionWebItemRepository;

    @Override
    public ObjectResult<WebItemModel> save(WebItemRequest request) {
        ObjectResult<WebItemModel> result = new ObjectResult<>(ObjectResultStatus.FAILED);
        try {
            WebItemEntity entity = new WebItemEntity();
            BeanUtils.copyProperties(request, entity);
            entity = webItemRepository.save(entity);
            if (entity.getId() != null) {
                WebItemModel model = new WebItemModel();
                BeanUtils.copyProperties(entity, model);
                result = new ObjectResult<>(model, ObjectResultStatus.SUCCESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @Override
    public ObjectResult<WebItemModel> update(Long id, WebItemRequest request) {
        ObjectResult<WebItemModel> result = new ObjectResult<>(ObjectResultStatus.FAILED);
        try {
            Optional<WebItemEntity> optional = webItemRepository.findById(id);
            if (optional.isPresent()) {
                WebItemEntity entity = optional.get();
                BeanUtils.copyProperties(request, entity);
                entity = webItemRepository.save(entity);
                WebItemModel model = new WebItemModel();
                BeanUtils.copyProperties(entity, model);
                result = new ObjectResult<>(model, ObjectResultStatus.SUCCESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @Override
    public ObjectResult<WebItemModel> findById(Long id) {
        ObjectResult<WebItemModel> result = new ObjectResult<>(ObjectResultStatus.FAILED);
        try {
            Optional<WebItemEntity> optional = webItemRepository.findById(id);
            if (optional.isPresent()) {
                WebItemEntity entity = optional.get();
                WebItemModel model = new WebItemModel();
                BeanUtils.copyProperties(entity, model);
                result = new ObjectResult<>(model, ObjectResultStatus.SUCCESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @Override
    public ObjectResult<WebItemModel> findAll() {
        ObjectResult<WebItemModel> result = new ObjectResult<>(ObjectResultStatus.FAILED);
        try {
            List<WebItemEntity> listEntity = webItemRepository.findAll();
            List<WebItemModel> listModel = new ArrayList<>();
            if (!CollectionUtils.isEmpty(listEntity)) {
                listEntity.forEach(e -> {
                    WebItemModel model = new WebItemModel();
                    BeanUtils.copyProperties(e, model);
                    listModel.add(model);
                });
            }
            result = new ObjectResult<>(listModel, ObjectResultStatus.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @Override
    public ObjectResult<WebItemModel> delete(Long id) {
        return null;
    }

    @Override
    public DataTable<WebItemModel> findByCriteria(CriteriaRequest request) {
        DataTable<WebItemModel> dataTable = new DataTable<>();
        try {
            DataTable<WebItemEntity> dataTableEntity = webItemRepository.findByCriteria(request.getCriteria(), request.getOrderBy(), request.getPageIndex(), request.getPageSize());
            if (dataTableEntity != null) {
                dataTable.getObjects().addAll(dataTableEntity.getObjects().stream().map(e -> {
                    WebItemModel model = new WebItemModel();
                    BeanUtils.copyProperties(e, model);
                    return model;
                }).collect(Collectors.toList()));
                dataTable.setPageIndex(dataTable.getPageIndex());
                dataTable.setPageSize(dataTable.getPageSize());
                dataTable.setTotal(dataTable.getTotal());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataTable;
    }

    @Override
    public ObjectResult<WebItemModel> findByTopicId(Long topicId) {
        ObjectResult<WebItemModel> result = new ObjectResult<>(ObjectResultStatus.FAILED);
        try {
            Optional<TopicEntity> optional = topicRepository.findById(topicId);
            if (optional.isPresent()) {
                List<TopicWebItemEntity> list = topicWebItemRepository.findByTopicId(topicId);
                if (!CollectionUtils.isEmpty(list)) {
                    List<WebItemModel> listModel = list.stream().map(TopicWebItemEntity::getWebItem).map(e -> {
                        WebItemModel model = new WebItemModel();
                        BeanUtils.copyProperties(e, model);
                        return model;
                    }).collect(Collectors.toList());
                    result = new ObjectResult<>(listModel, ObjectResultStatus.SUCCESS);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @Override
    public ObjectResult<WebItemModel> findByCollectionId(Long collectionId) {
        ObjectResult<WebItemModel> result = new ObjectResult<>(ObjectResultStatus.FAILED);
        try {
            List<CollectionWebItemEntity> list = collectionWebItemRepository.findByCollection(collectionId);
            List<WebItemModel> listModel = new ArrayList<>();
            if (!CollectionUtils.isEmpty(list)) {
                listModel.addAll(list.stream().map(CollectionWebItemEntity::getWebItem).map(e -> {
                    WebItemModel model = new WebItemModel();
                    BeanUtils.copyProperties(e, model);
                    return model;
                }).collect(Collectors.toList()));
            }
            result = new ObjectResult<>(listModel, ObjectResultStatus.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getMessage());
        }
        return result;
    }
}
