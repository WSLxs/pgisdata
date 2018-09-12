package com.xinghuo.pgisdata.service;

import com.xinghuo.pgisdata.VO.TransferUtil;
import com.xinghuo.pgisdata.dao.FieldDao;
import com.xinghuo.pgisdata.VO.FieldEntityVO;
import com.xinghuo.pgisdata.dao.FieldEntityDao;
import com.xinghuo.pgisdata.entity.FieldEntity;
import com.xinghuo.pgisdata.entity.TableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FieldService {

    @Autowired
    private FieldDao fieldDao;
    @Autowired
    private FieldEntityDao fieldEntityDao;

    public List<FieldEntityVO> getFields(String tableName) throws Exception {
        //根据表名查出表中含有的所有字段
        List<Object[]> objects = fieldDao.getAllFieldsByTableName(tableName);
        List<FieldEntityVO> fields = TransferUtil.castEntity(objects,FieldEntityVO.class);
//        List<String> fieldNames = fields.stream().map(FieldEntityVO::getColumnName).collect(Collectors.toList());
//        //在一一查出每个字段的备注和内容描述
//        List<FieldEntity> fieldEntities = fieldDao.findAllByFieldNameIn(fieldNames);


        return fields;
    }

    public List<FieldEntityVO> getTcFields(String tableName) throws Exception {
        //根据表名查出表中含有的所有字段
        List<Object[]> objects = fieldEntityDao.getAllFieldsByTableName(tableName);
        List<FieldEntityVO> fields = TransferUtil.castEntity(objects,FieldEntityVO.class);

        return fields;
    }




}
