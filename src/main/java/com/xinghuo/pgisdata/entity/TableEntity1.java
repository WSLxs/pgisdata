package com.xinghuo.pgisdata.entity;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class TableEntity1 {

    @Id
    @GeneratedValue
    private String tableName;
    private String remark;
    private String content;


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
