package com.xinghuo.pgisdata.VO;

import java.math.BigDecimal;

public class FieldEntityVO1 {

    private String columnName;
    private String sszl;
    private String sxmc;
    private String dataType;
    private BigDecimal dataLength;


    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getSszl() {
        return sszl;
    }

    public void setSszl(String sszl) {
        this.sszl = sszl;
    }

    public String getSxmc() {
        return sxmc;
    }

    public void setSxmc(String sxmc) {
        this.sxmc = sxmc;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public BigDecimal getDataLength() {
        return dataLength;
    }

    public void setDataLength(BigDecimal dataLength) {
        this.dataLength = dataLength;
    }
}
