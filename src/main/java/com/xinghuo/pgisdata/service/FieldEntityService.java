package com.xinghuo.pgisdata.service;

import com.xinghuo.pgisdata.VO.ExcelReader;
import com.xinghuo.pgisdata.VO.FieldEntityVO;
import com.xinghuo.pgisdata.VO.TransferUtil;
import com.xinghuo.pgisdata.dao.FieldDao;
import com.xinghuo.pgisdata.dao.FieldEntityDao;
import com.xinghuo.pgisdata.entity.FieldEntity;
import com.xinghuo.pgisdata.entity.TableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class FieldEntityService {

    @Autowired
    private FieldEntityDao fieldEntityDao;

    @PersistenceContext
    protected EntityManager em;

    public FieldEntity addField(FieldEntity fieldEntity) throws Exception {
        //根据表名查出表中含有的所有字段
        return fieldEntityDao.save(fieldEntity);
    }

    @Transactional
    public void saveAllField(){
        try {
//            List<FieldEntity> fieldEntities = ExcelReader.excelTransToFieldEntity("C:/Users/LiuXS/Desktop/数据信息/数据字段-2.xlsx");
//            batchInsert(fieldEntities);

            List<TableEntity> tableEntities = ExcelReader.excelTransToTableEntity();
            batchInsert(tableEntities);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void batchInsert(List list) {
        for (int i = 0; i < list.size(); i++) {
            em.persist(list.get(i));
            if (i % 30 == 0) {
                em.flush();
                em.clear();
            }
        }
    }

    @Transactional
    public FieldEntity updateTable(FieldEntity fieldEntity){
        return fieldEntityDao.save(fieldEntity);
    }

    @Transactional
    public void saveField(FieldEntity fieldEntity){
        fieldEntityDao.save(fieldEntity);
    }

    @Transactional
    public void deleteField(FieldEntity fieldEntity){
        fieldEntityDao.delete(fieldEntity);
    }

    public FieldEntity getEntityByZdmc(String zdmc){
        return fieldEntityDao.findTopByZdmc(zdmc);
    }

    public List<FieldEntity> getAllFields() throws Exception {
        //查出表中含有的所有字段
        List<FieldEntity> fieldEntities = fieldEntityDao.findAll();
        return fieldEntities;
    }

}
