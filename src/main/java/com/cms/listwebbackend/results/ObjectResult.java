package com.cms.listwebbackend.results;

import com.cms.listwebbackend.enums.ObjectResultStatus;
import lombok.Data;

import java.util.List;

@Data
public class ObjectResult<T> {
    private T object;
    private List<T> objects;
    private String message;
    private ObjectResultStatus status;

    public ObjectResult(ObjectResultStatus status) {
        this.status = status;
    }

    public ObjectResult(T object, ObjectResultStatus status) {
        this.object = object;
        this.status = status;
    }

    public ObjectResult(List<T> objects, ObjectResultStatus status) {
        this.objects = objects;
        this.status = status;
    }
}


