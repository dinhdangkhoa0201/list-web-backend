package com.cms.listwebbackend.repositories.customs.impls;

import com.cms.listwebbackend.entities.AccountEntity;
import com.cms.listwebbackend.repositories.customs.*;
import com.cms.listwebbackend.results.DataTable;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class AccountRepositoryCustomImpl extends AbstractRepository implements AccountRepositoryCustom {

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
    public DataTable<AccountEntity> findByCriteria(HashMap<String, Object> criteria, String[] orderBy, int pageIndex, int pageSize) {
        String selectQuery = "SELECT e FROM AccountEntity e";

        Query query = entityManager.createQuery(selectQuery + buildCriteria(criteria, orderBy), AccountEntity.class);
        for (Map.Entry<String, Object> entry : criteria.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        DataTable<AccountEntity> dataTable = new DataTable<>();
        dataTable.setObjects(query.setFirstResult(pageSize * pageIndex).setMaxResults(pageSize).getResultList());
        dataTable.setPageSize(pageSize);
        dataTable.setPageIndex(pageIndex);

        String countQuery = "SELECT COUNT(e) FROM AccountEntity e";
        query = entityManager.createQuery(countQuery + buildCriteria(criteria, orderBy), Long.class);
        for (Map.Entry<String, Object> entry : criteria.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        dataTable.setTotal(Integer.parseInt(query.getSingleResult().toString()));
        return dataTable;
    }
}
