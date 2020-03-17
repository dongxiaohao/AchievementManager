package com.lnavm.pojo;

import java.math.BigDecimal;

public class SjsfzglInfo {

    private BigDecimal glid;

    private String sjh;

    private String sfzh;

    private String xm;


    public BigDecimal getGlid() {
        return glid;
    }

    public void setGlid(BigDecimal glid) {
        this.glid = glid;
    }

    public String getSjh() {
        return sjh;
    }

    public void setSjh(String sjh) {
        this.sjh = sjh == null ? null : sjh.trim();
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh == null ? null : sfzh.trim();
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
//        System.out.println("setxm:"+this.xm);
    }
}