package com.cms.listwebbackend.services.impls;

import com.cms.listwebbackend.entities.CollectionEntity;
import com.cms.listwebbackend.entities.UserCollectionEntity;
import com.cms.listwebbackend.enums.ObjectResultStatus;
import com.cms.listwebbackend.models.CollectionModel;
import com.cms.listwebbackend.repositories.CollectionRepository;
import com.cms.listwebbackend.repositories.customs.UserCollectionRepository;
import com.cms.listwebbackend.requests.CollectionRequest;
import com.cms.listwebbackend.requests.CriteriaRequest;
import com.cms.listwebbackend.results.DataTable;
import com.cms.listwebbackend.results.ObjectResult;
import com.cms.listwebbackend.services.ICollectionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CollectionService implements ICollectionService {

    @Autowired
    private CollectionRepository collectionRepository;

    @Autowired
    private UserCollectionRepository userCollectionRepository;

    @Override
    public ObjectResult<CollectionModel> save(CollectionRequest request) {
        ObjectResult<CollectionModel> result = new ObjectResult<>(ObjectResultStatus.FAILED);
        try {
            CollectionEntity entity = new CollectionEntity();
            BeanUtils.copyProperties(request, entity);
            entity = collectionRepository.save(entity);
            if (entity.getId() != null) {
                CollectionModel model = new CollectionModel();
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
    public ObjectResult<CollectionModel> update(Long id, CollectionRequest request) {
        ObjectResult<CollectionModel> result = new ObjectResult<>(ObjectResultStatus.FAILED);
        try {
            Optional<CollectionEntity> optional = collectionRepository.findById(id);
            if (optional.isPresent()) {
                CollectionEntity entity = optional.get();
                BeanUtils.copyProperties(request, entity);
                entity = collectionRepository.save(entity);

                CollectionModel model = new CollectionModel();
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
    public ObjectResult<CollectionModel> findById(Long id) {
        ObjectResult<CollectionModel> result = new ObjectResult<>(ObjectResultStatus.FAILED);
        try {
            Optional<CollectionEntity> optional = collectionRepository.findById(id);
            if (optional.isPresent()) {
                CollectionEntity entity = optional.get();
                CollectionModel model = new CollectionModel();
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
    public ObjectResult<CollectionModel> findAll() {
        ObjectResult<CollectionModel> result = new ObjectResult<>(ObjectResultStatus.FAILED);
        try {
            List<CollectionEntity> listEntity = collectionRepository.findAll();
            List<CollectionModel> listModel = new ArrayList<>();
            if (!CollectionUtils.isEmpty(listEntity)) {
                listEntity.forEach(e -> {
                    CollectionModel model = new CollectionModel();
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
    public DataTable<CollectionModel> findByCriteria(CriteriaRequest request) {
        DataTable<CollectionModel> dataTable = new DataTable<>();
        try {
            DataTable<CollectionEntity> dataTableEntity;
            dataTableEntity = collectionRepository.findByCriteria(request.getCriteria(), request.getOrderBy(), request.getPageIndex(), request.getPageSize());
            if (dataTableEntity != null) {
                dataTable.setObjects(dataTableEntity.getObjects().stream().map(e -> {
                    CollectionModel model = new CollectionModel();
                    BeanUtils.copyProperties(e, model);
                    return model;
                }).collect(Collectors.toList()));
                dataTable.setPageIndex(dataTableEntity.getPageIndex());
                dataTable.setPageSize(dataTableEntity.getPageSize());
                dataTable.setTotal(dataTableEntity.getTotal());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataTable;
    }

    @Override
    public ObjectResult<CollectionModel> delete(Long id) {
        return null;
    }

    @Override
    public ObjectResult<CollectionModel> findByUser(Long userId) {
        ObjectResult<CollectionModel> result = new ObjectResult<>(ObjectResultStatus.FAILED);
        try {
            List<UserCollectionEntity> listEntity = userCollectionRepository.findByUser(userId);
            List<CollectionModel> listModel = new ArrayList<>();
            if (!CollectionUtils.isEmpty(listEntity)) {
                listModel.addAll(listEntity.stream().map(UserCollectionEntity::getCollection).map(e -> {
                    CollectionModel model = new CollectionModel();
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
