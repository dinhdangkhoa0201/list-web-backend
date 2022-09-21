package com.cms.listwebbackend.services.impls;

import com.cms.listwebbackend.entities.SystemConstantEntity;
import com.cms.listwebbackend.enums.ObjectResultStatus;
import com.cms.listwebbackend.models.SystemConstantModel;
import com.cms.listwebbackend.repositories.SystemConstantRepository;
import com.cms.listwebbackend.requests.CriteriaRequest;
import com.cms.listwebbackend.requests.SystemConstantRequest;
import com.cms.listwebbackend.results.DataTable;
import com.cms.listwebbackend.results.ObjectResult;
import com.cms.listwebbackend.services.ISystemConstantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SystemConstantService implements ISystemConstantService {

    @Autowired
    private SystemConstantRepository systemConstantRepository;

    @Override
    public ObjectResult<SystemConstantModel> save(SystemConstantRequest request) {
        ObjectResult<SystemConstantModel> result = new ObjectResult<>(ObjectResultStatus.FAILED);
        try {
            SystemConstantEntity entity = new SystemConstantEntity();
            BeanUtils.copyProperties(request, entity);
            entity = systemConstantRepository.save(entity);
            if (entity.getId() != null) {
                SystemConstantModel model = new SystemConstantModel();
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
    public ObjectResult<SystemConstantModel> update(Long id, SystemConstantRequest request) {
        ObjectResult<SystemConstantModel> result = new ObjectResult<>(ObjectResultStatus.FAILED);
        try {
            Optional<SystemConstantEntity> optional = systemConstantRepository.findById(id);
            if (optional.isPresent()) {
                SystemConstantEntity entity = optional.get();
                BeanUtils.copyProperties(request, entity);
                entity = systemConstantRepository.save(entity);
                SystemConstantModel model = new SystemConstantModel();
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
    public ObjectResult<SystemConstantModel> findById(Long id) {
        ObjectResult<SystemConstantModel> result = new ObjectResult<>(ObjectResultStatus.FAILED);
        try {
            Optional<SystemConstantEntity> optional = systemConstantRepository.findById(id);
            if (optional.isPresent()) {
                SystemConstantEntity entity = optional.get();
                SystemConstantModel model = new SystemConstantModel();
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
    public ObjectResult<SystemConstantModel> findAll() {
        ObjectResult<SystemConstantModel> result = new ObjectResult<>(ObjectResultStatus.FAILED);
        try {
            List<SystemConstantEntity> listEntity = systemConstantRepository.findAll();
            List<SystemConstantModel> listModel = new ArrayList<>();
            if (!CollectionUtils.isEmpty(listEntity)) {
                listEntity.forEach(e -> {
                    SystemConstantModel model = new SystemConstantModel();
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
    public ObjectResult<SystemConstantModel> delete(Long id) {
        return null;
    }

    @Override
    public DataTable<SystemConstantModel> findByCriteria(CriteriaRequest request) {
        DataTable<SystemConstantModel> dataTable = new DataTable<>();
        try {
            DataTable<SystemConstantEntity> dataTableEntity = systemConstantRepository.findByCriteria(request.getCriteria(), request.getOrderBy(), request.getPageIndex(), request.getPageSize());
            if (dataTableEntity != null) {
                dataTable.getObjects().addAll(dataTableEntity.getObjects().stream().map(e -> {
                    SystemConstantModel model = new SystemConstantModel();
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
}
