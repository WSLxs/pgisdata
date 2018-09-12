package com.xinghuo.pgisdata.dao;

import com.xinghuo.pgisdata.entity.FieldEntity1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FieldDao extends JpaRepository<FieldEntity1,Integer>,JpaSpecificationExecutor<FieldEntity1> {

    public List<FieldEntity1> findAllByFieldNameIn(List<String> FieldNames);

    @Query(value="select A.COLUMN_NAME,B.REMARK,B.CONTENT,A.DATA_TYPE,A.DATA_LENGTH" +
            " from user_tab_columns A INNER JOIN FIELD_ENTITY B ON A.COLUMN_NAME = B.FIELD_NAME where TABLE_NAME=:tableName"
            ,nativeQuery = true)
    List<Object[]> getAllFieldsByTableName(@Param("tableName")String tableName);
}
