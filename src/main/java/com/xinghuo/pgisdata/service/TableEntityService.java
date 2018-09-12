package com.xinghuo.pgisdata.service;

import com.xinghuo.pgisdata.dao.TableDao;
import com.xinghuo.pgisdata.dao.TableEntityDao;
import com.xinghuo.pgisdata.entity.TableEntity;
import com.xinghuo.pgisdata.entity.TableEntity1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TableEntityService {

    @Autowired
    private TableDao tableDao;

    @Autowired
    private TableEntityDao tableEntityDao;

    public Page<TableEntity1> getTables(Pageable pageable){
        Page page = tableDao.findAll(pageable);
        return page;
    }

    public Page<TableEntity> getTcs(Pageable pageable){
        Page page = tableEntityDao.findAll(pageable);
        return page;
    }

    public TableEntity1 tableDetail(String tableName){
        return tableDao.findTopByTableName(tableName);
    }

    public TableEntity tcDetail(String tableName){
        return tableEntityDao.findTopByYsmc(tableName);
    }

    public Page<TableEntity1> findPageData(Specification<TableEntity1> specification,
                                           Pageable pageable) {
        // TODO Auto-generated method stub
        return tableDao.findAll(specification,pageable);
    }

    public Page<TableEntity> findPageTC(Specification<TableEntity> specification,
                                           Pageable pageable) {
        // TODO Auto-generated method stub
        return tableEntityDao.findAll(specification,pageable);
    }

    @Transactional
    public TableEntity updateTable(TableEntity tableEntity){

        return tableEntityDao.save(tableEntity);
    }

    @Transactional
    public void deletaTable(TableEntity tableEntity){
        tableEntityDao.delete(tableEntity);
    }

    @Transactional
    public void saveTable(TableEntity tableEntity){
        tableEntityDao.save(tableEntity);
    }


}
