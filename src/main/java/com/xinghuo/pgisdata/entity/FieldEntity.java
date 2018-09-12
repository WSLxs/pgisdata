package com.xinghuo.pgisdata.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FieldEntity {

    @Id
    @GeneratedValue(generator="system_uuid")
    @GenericGenerator(name="system_uuid",strategy="uuid")
    private String Id;

    private String zdmc;
    private String ssdl;
    private String sszl;
    private String sxmc;
    private String zdlx;
    private String zddx;
    private String sfbx;


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getZdmc() {
        return zdmc;
    }

    public void setZdmc(String zdmc) {
        this.zdmc = zdmc;
    }

    public String getSsdl() {
        return ssdl;
    }

    public void setSsdl(String ssdl) {
        this.ssdl = ssdl;
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

    public String getZdlx() {
        return zdlx;
    }

    public void setZdlx(String zdlx) {
        this.zdlx = zdlx;
    }

    public String getZddx() {
        return zddx;
    }

    public void setZddx(String zddx) {
        this.zddx = zddx;
    }

    public String getSfbx() {
        return sfbx;
    }

    public void setSfbx(String sfbx) {
        this.sfbx = sfbx;
    }
}
