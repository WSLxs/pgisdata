package com.xinghuo.pgisdata.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TableEntity {

    @Id
    @GeneratedValue(generator="system_uuid")
    @GenericGenerator(name="system_uuid",strategy="uuid")
    private String Id;

    private String cdm;
    private String dl;
    private String tcmc;
    private String kjtp;
    private String ysmc;
    private String tcxx;
    private String yslb;


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCdm() {
        return cdm;
    }

    public void setCdm(String cdm) {
        this.cdm = cdm;
    }

    public String getDl() {
        return dl;
    }

    public void setDl(String dl) {
        this.dl = dl;
    }

    public String getTcmc() {
        return tcmc;
    }

    public void setTcmc(String tcmc) {
        this.tcmc = tcmc;
    }

    public String getKjtp() {
        return kjtp;
    }

    public void setKjtp(String kjtp) {
        this.kjtp = kjtp;
    }

    public String getYsmc() {
        return ysmc;
    }

    public void setYsmc(String ysmc) {
        this.ysmc = ysmc;
    }

    public String getTcxx() {
        return tcxx;
    }

    public void setTcxx(String tcxx) {
        this.tcxx = tcxx;
    }

    public String getYslb() {
        return yslb;
    }

    public void setYslb(String yslb) {
        this.yslb = yslb;
    }
}
