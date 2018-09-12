package com.xinghuo.pgisdata.VO;

import java.math.BigDecimal;

public class FieldEntityVO {

    private String columnName;
    private String sszl;
    private String content;
    private String dataType;
    private BigDecimal dataLength;

    public FieldEntityVO(String columnName, String sszl, String content, String dataType, BigDecimal dataLength){
        this.columnName = columnName;
        this.sszl = sszl;
        this.content = content;
        this.dataType = dataType;
        this.dataLength = dataLength;
    }

    public FieldEntityVO(){}

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
