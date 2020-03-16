package com.xinghuo.pgisdata.dao;

import com.xinghuo.pgisdata.entity.TableEntity;
import com.xinghuo.pgisdata.entity.TableEntity1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TableEntityDao extends JpaRepository<TableEntity,Integer>,JpaSpecificationExecutor<TableEntity> {
     TableEntity findTopByYsmc(String tableName);


     int  getIn(String in);
}
