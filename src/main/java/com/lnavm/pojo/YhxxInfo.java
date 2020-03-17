package com.lnavm.pojo;

import java.math.BigDecimal;

public class YhxxInfo {
    private BigDecimal yhid;

    private String sjh;

    private String mm;

    private String sfzh;

    private String xm;

    private String yhm;

    private String yx;

    public BigDecimal getYhid() {
        return yhid;
    }

    public void setYhid(BigDecimal yhid) {
        this.yhid = yhid;
    }

    public String getSjh() {
        return sjh;
    }

    public void setSjh(String sjh) {
        this.sjh = sjh == null ? null : sjh.trim();
    }

    public String getMm() {
        return mm;
    }

    public void setMm(String mm) {
        this.mm = mm == null ? null : mm.trim();
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
        this.xm = xm == null ? null : xm.trim();
    }

    public String getYhm() {
        return yhm;
    }

    public void setYhm(String yhm) {
        this.yhm = yhm == null ? null : yhm.trim();
    }

    public String getYx() {
        return yx;
    }

    public void setYx(String yx) {
        this.yx = yx == null ? null : yx.trim();
    }
}