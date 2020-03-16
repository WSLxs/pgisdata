package com.xinghuo.pgisdata.dao;

import com.xinghuo.pgisdata.VO.FieldEntityVO;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class TableEntityDaoImpl {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    public int getIn(String in){
        String sql = "select A.COLUMN_NAME as \"columnName\",B.sszl as \"sszl\" ,B.sxmc as \"content\",A.DATA_TYPE as \"dataType\",A.DATA_LENGTH as \"dataLength\" from user_tab_columns A LEFT JOIN FIELD_ENTITY B ON A.COLUMN_NAME = B.zdmc where TABLE_NAME=?1";
        Query query = em.createNativeQuery(sql);
        query.setParameter(1,in);
        List<FieldEntityVO> list = query.unwrap(NativeQueryImpl.class)
                .setResultTransformer(Transformers.aliasToBean(FieldEntityVO.class)).list();
        return 0;
    };
}
