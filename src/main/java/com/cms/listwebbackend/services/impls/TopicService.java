package com.cms.listwebbackend.services.impls;

import com.cms.listwebbackend.entities.TopicEntity;
import com.cms.listwebbackend.enums.ObjectResultStatus;
import com.cms.listwebbackend.models.TopicModel;
import com.cms.listwebbackend.repositories.TopicRepository;
import com.cms.listwebbackend.requests.CriteriaRequest;
import com.cms.listwebbackend.requests.TopicRequest;
import com.cms.listwebbackend.results.DataTable;
import com.cms.listwebbackend.results.ObjectResult;
import com.cms.listwebbackend.services.ITopicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TopicService implements ITopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public ObjectResult<TopicModel> save(TopicRequest request) {
        ObjectResult<TopicModel> result = new ObjectResult<>(ObjectResultStatus.FAILED);
        try {
            TopicEntity entity = new TopicEntity();
            BeanUtils.copyProperties(request, entity);
            entity = topicRepository.save(entity);
            if (entity.getId() != null) {
                TopicModel model = new TopicModel();
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
    public ObjectResult<TopicModel> update(Long id, TopicRequest request) {
        ObjectResult<TopicModel> result = new ObjectResult<>(ObjectResultStatus.FAILED);
        try {
            Optional<TopicEntity> optional = topicRepository.findById(id);
            if (optional.isPresent()) {
                TopicEntity entity = optional.get();
                BeanUtils.copyProperties(request, entity);
                entity = topicRepository.save(entity);

                TopicModel model = new TopicModel();
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
    public ObjectResult<TopicModel> findById(Long id) {
        ObjectResult<TopicModel> result = new ObjectResult<>(ObjectResultStatus.FAILED);
        try {
            Optional<TopicEntity> optional = topicRepository.findById(id);
            if (optional.isPresent()) {
                TopicEntity entity = optional.get();
                TopicModel model = new TopicModel();
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
    public ObjectResult<TopicModel> findAll() {
        ObjectResult<TopicModel> result = new ObjectResult<>(ObjectResultStatus.FAILED);
        try {
            List<TopicEntity> listEntity = topicRepository.findAll();
            List<TopicModel> listModel = new ArrayList<>();
            if (!CollectionUtils.isEmpty(listEntity)) {
                listEntity.forEach(e -> {
                    TopicModel model = new TopicModel();
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
    public DataTable<TopicModel> findByCriteria(CriteriaRequest request) {
        log.info("[findByCriteria] -> Executed");
        DataTable<TopicModel> dataTable = new DataTable<>();
        try {
            DataTable<TopicEntity> dataTableEntity = topicRepository.findByCriteria(request.getCriteria(), request.getOrderBy(), request.getPageIndex(), request.getPageSize());
            if (dataTableEntity != null) {
                dataTable.getObjects().addAll(dataTableEntity.getObjects().stream().map(e -> {
                    TopicModel model = new TopicModel();
                    BeanUtils.copyProperties(e, model);
                    return model;
                }).collect(Collectors.toList()));
                dataTable.setPageSize(dataTableEntity.getPageSize());
                dataTable.setPageIndex(dataTableEntity.getPageIndex());
                dataTable.setTotal(dataTableEntity.getTotal());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataTable;
    }

    @Override
    public ObjectResult<TopicModel> delete(Long id) {
        return null;
    }
}
