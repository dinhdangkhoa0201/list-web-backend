package com.cms.listwebbackend.services.impls;

import com.cms.listwebbackend.entities.MenuEntity;
import com.cms.listwebbackend.enums.ObjectResultStatus;
import com.cms.listwebbackend.models.MenuModel;
import com.cms.listwebbackend.repositories.MenuRepository;
import com.cms.listwebbackend.requests.CriteriaRequest;
import com.cms.listwebbackend.requests.MenuRequest;
import com.cms.listwebbackend.results.DataTable;
import com.cms.listwebbackend.results.ObjectResult;
import com.cms.listwebbackend.services.IMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MenuService implements IMenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public ObjectResult<MenuModel> save(MenuRequest request) {
        ObjectResult<MenuModel> result = new ObjectResult<>(ObjectResultStatus.FAILED);
        try {
            MenuEntity entity = new MenuEntity();
            BeanUtils.copyProperties(request, entity);
            entity = menuRepository.save(entity);
            if (entity.getId() != null) {
                MenuModel model = new MenuModel();
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
    public ObjectResult<MenuModel> update(Long id, MenuRequest request) {
        ObjectResult<MenuModel> result = new ObjectResult<>(ObjectResultStatus.FAILED);
        try {
            Optional<MenuEntity> optional = menuRepository.findById(id);
            if (optional.isPresent()) {
                MenuEntity entity = optional.get();
                BeanUtils.copyProperties(request, entity);
                entity = menuRepository.save(entity);

                MenuModel model = new MenuModel();
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
    public ObjectResult<MenuModel> delete(Long id) {
        return null;
    }

    @Override
    public ObjectResult<MenuModel> findAll() {
        ObjectResult<MenuModel> result = new ObjectResult<>(ObjectResultStatus.FAILED);
        try {
            List<MenuEntity> listEntity = menuRepository.findAll();
            List<MenuModel> listModel = new ArrayList<>();
            if (!CollectionUtils.isEmpty(listEntity)) {
                listModel.addAll(listEntity.stream().map(e -> {
                    MenuModel model = new MenuModel();
                    BeanUtils.copyProperties(e, model);
                    return model;
                }).collect(Collectors.toList()));
                listModel.sort(Comparator.comparing(MenuModel::getIndexId));
            }
            result = new ObjectResult<>(listModel, ObjectResultStatus.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @Override
    public DataTable<MenuModel> findByCriteria(CriteriaRequest request) {
        DataTable<MenuModel> dataTable = new DataTable<>();
        try {
            DataTable<MenuEntity> dataTableEntity = menuRepository.findByCriteria(request.getCriteria(), request.getOrderBy(), request.getPageIndex(), request.getPageSize());
            if (dataTableEntity != null) {
                dataTable.getObjects().addAll(dataTableEntity.getObjects().stream().map(e -> {
                    MenuModel model = new MenuModel();
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
    public ObjectResult<MenuModel> findByCode(String code) {
        ObjectResult<MenuModel> result = new ObjectResult<>(ObjectResultStatus.FAILED);
        try {
            MenuEntity entity = menuRepository.findByCode(code);
            if (entity != null) {
                MenuModel model = new MenuModel();
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
    public ObjectResult<Integer> saveByOrder(HashMap<Long, Integer> mapIndexId) {
        ObjectResult<Integer> result = new ObjectResult<>(ObjectResultStatus.FAILED);
        try {
            int count = 0;
            for (Map.Entry<Long, Integer> entry : mapIndexId.entrySet()) {
                count += menuRepository.updateIndexIdById(entry.getKey(), entry.getValue());
            }
            result = new ObjectResult<>(count, ObjectResultStatus.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getMessage());
        }
        return result;
    }
}
