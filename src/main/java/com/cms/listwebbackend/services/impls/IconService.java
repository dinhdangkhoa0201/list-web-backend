package com.cms.listwebbackend.services.impls;

import com.cms.listwebbackend.entities.IconEntity;
import com.cms.listwebbackend.entities.MenuEntity;
import com.cms.listwebbackend.enums.ObjectResultStatus;
import com.cms.listwebbackend.models.IconModel;
import com.cms.listwebbackend.models.MenuModel;
import com.cms.listwebbackend.repositories.IconRepository;
import com.cms.listwebbackend.requests.CriteriaRequest;
import com.cms.listwebbackend.results.DataTable;
import com.cms.listwebbackend.results.ObjectResult;
import com.cms.listwebbackend.services.IIconService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IconService implements IIconService {

    @Autowired
    private IconRepository iconRepository;

    @Override
    public DataTable<IconModel> findByCriteria(CriteriaRequest request) {
        DataTable<IconModel> dataTable = new DataTable<>();
        try {
            DataTable<IconEntity> dataTableEntity = iconRepository.findByCriteria(request.getCriteria(), request.getOrderBy(), request.getPageIndex(), request.getPageSize());
            if (dataTableEntity != null) {
                dataTable.getObjects().addAll(dataTableEntity.getObjects().stream().map(e -> {
                    IconModel model = new IconModel();
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
    public ObjectResult<IconModel> findAll() {
        ObjectResult<IconModel> result = new ObjectResult<>(ObjectResultStatus.FAILED);
        try {
            List<IconEntity> listEntity = iconRepository.findAll();
            List<IconModel> listModel = new ArrayList<>();
            if (!CollectionUtils.isEmpty(listEntity)) {
                listModel.addAll(listEntity.stream().map(e -> {
                    IconModel model = new IconModel();
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
