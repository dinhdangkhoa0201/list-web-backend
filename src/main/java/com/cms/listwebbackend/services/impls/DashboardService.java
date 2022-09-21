package com.cms.listwebbackend.services.impls;

import com.cms.listwebbackend.enums.ObjectResultStatus;
import com.cms.listwebbackend.results.ObjectResult;
import com.cms.listwebbackend.services.AbstractService;
import com.cms.listwebbackend.services.IDashboardService;
import org.springframework.stereotype.Service;

import javax.persistence.Query;

@Service
public class DashboardService extends AbstractService implements IDashboardService {
    @Override
    public ObjectResult<Integer> count(String object) {
        ObjectResult<Integer> result = new ObjectResult<>(ObjectResultStatus.FAILED);
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT COUNT(o) FROM ");
            sb.append(object);
            sb.append(" o");

            Query query = entityManager.createQuery(sb.toString());
            Integer count = Integer.parseInt(query.getSingleResult().toString());
            result = new ObjectResult<>(count, ObjectResultStatus.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
