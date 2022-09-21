package com.cms.listwebbackend.repositories.customs.impls;

import com.cms.listwebbackend.entities.CollectionEntity;
import com.cms.listwebbackend.repositories.customs.AbstractRepository;
import com.cms.listwebbackend.repositories.customs.CollectionRepositoryCustom;
import com.cms.listwebbackend.results.DataTable;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class CollectionRepositoryCustomImpl extends AbstractRepository implements CollectionRepositoryCustom {

    private String buildCriteria(HashMap<String, Object> criteria, String[] orderBy) {
        StringBuilder sb = new StringBuilder();
        sb.append(" WHERE 1=1 ");
        if (criteria.containsKey("name")) {
            sb.append("name = :name ");
        }

        if (orderBy.length > 0) {
            StringBuilder sorting = new StringBuilder();
            for (String str : orderBy) {
                sorting.append(",").append(str);
            }
            sb.append(" order by ").append(sorting.substring(1));
        }

        return sb.toString();
    }

    @Override
    public DataTable<CollectionEntity> findByCriteria(HashMap<String, Object> criteria, String[] orderBy, int pageIndex, int pageSize) {
        String selectSql = "SELECT c FROM CollectionEntity c";
        Query query = entityManager.createQuery(selectSql + buildCriteria(criteria, orderBy), CollectionEntity.class);
        for (Map.Entry<String, Object> entry : criteria.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        DataTable<CollectionEntity> dataTable = new DataTable<>();
        dataTable.setObjects(query.setFirstResult(pageSize * pageIndex).setMaxResults(pageSize).getResultList());
        dataTable.setPageSize(pageSize);
        dataTable.setPageIndex(pageIndex);

        String countSql = "SELECT COUNT(c) FROM CollectionEntity c";
        query = entityManager.createQuery(countSql + buildCriteria(criteria, orderBy), CollectionEntity.class);
        for (Map.Entry<String, Object> entry : criteria.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        dataTable.setTotal(Integer.parseInt(query.getSingleResult().toString()));
        return dataTable;
    }
}
