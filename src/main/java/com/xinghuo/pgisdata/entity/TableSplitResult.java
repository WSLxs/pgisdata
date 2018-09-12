package com.xinghuo.pgisdata.entity;

import java.io.Serializable;

public class TableSplitResult<T> implements Serializable {

    private  Integer page;
    private Long total;
    private T rows;


    public TableSplitResult() {
    }

    public TableSplitResult(Integer page, Long total, T rows) {
        this.page = page;
        this.total = total;
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public T getRows() {
        return rows;
    }

    public void setRows(T rows) {
        this.rows = rows;
    }
}
