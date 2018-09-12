package com.xinghuo.pgisdata.dao;

import com.xinghuo.pgisdata.entity.FieldEntity;
import com.xinghuo.pgisdata.entity.FieldEntity1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FieldEntityDao extends JpaRepository<FieldEntity,Integer>,JpaSpecificationExecutor<FieldEntity> {

    @Query(value="select A.COLUMN_NAME,B.sszl,B.sxmc,A.DATA_TYPE,A.DATA_LENGTH" +
            " from user_tab_columns A INNER JOIN FIELD_ENTITY B ON A.COLUMN_NAME = B.zdmc where TABLE_NAME=:tableName"
            ,nativeQuery = true)
    List<Object[]> getAllFieldsByTableName(@Param("tableName")String tableName);


    FieldEntity findTopByZdmc(String zdmc);
}
