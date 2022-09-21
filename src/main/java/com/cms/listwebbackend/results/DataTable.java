package com.cms.listwebbackend.results;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DataTable<T> {
    private List<T> objects;
    private int total;
    private int pageIndex;
    private int pageSize;

    public DataTable() {
        objects = new ArrayList<>();
    }
}
