package com.cms.listwebbackend.repositories.customs.impls;

import com.cms.listwebbackend.entities.TopicEntity;
import com.cms.listwebbackend.repositories.customs.AbstractRepository;
import com.cms.listwebbackend.repositories.customs.TopicRepositoryCustom;
import com.cms.listwebbackend.results.DataTable;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class TopicRepositoryCustomImpl extends AbstractRepository implements TopicRepositoryCustom {

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
    public DataTable<TopicEntity> findByCriteria(HashMap<String, Object> criteria, String[] orderBy, int pageIndex, int pageSize) {
        String selectSql = "SELECT (t) FROM TopicEntity t";
        Query query = entityManager.createQuery(selectSql + buildCriteria(criteria, orderBy), TopicEntity.class);
        for (Map.Entry<String, Object> entry : criteria.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        DataTable<TopicEntity> dataTable = new DataTable<>();
        dataTable.setObjects(query.setFirstResult(pageSize * pageIndex).setMaxResults(pageSize).getResultList());
        dataTable.setPageIndex(pageIndex);
        dataTable.setPageSize(pageSize);

        String countSql = "SELECT COUNT(t) FROM TopicEntity t";
        query = entityManager.createQuery(countSql + buildCriteria(criteria, orderBy), Long.class);
        for (Map.Entry<String, Object> entry : criteria.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        dataTable.setTotal(Integer.parseInt(query.getSingleResult().toString()));
        return dataTable;
    }
}
