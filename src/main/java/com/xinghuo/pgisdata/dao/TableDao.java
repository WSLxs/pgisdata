package com.xinghuo.pgisdata.dao;

import com.xinghuo.pgisdata.entity.TableEntity1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TableDao extends JpaRepository<TableEntity1,Integer>,JpaSpecificationExecutor<TableEntity1> {

    public List<TableEntity1> findByContent(String content);

    public TableEntity1 findTopByTableName(String tableName);
}
