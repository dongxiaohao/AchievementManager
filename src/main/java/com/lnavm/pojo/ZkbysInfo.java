package com.lnavm.pojo;

import java.math.BigDecimal;

public class ZkbysInfo {
    private BigDecimal zkbybid;

    private String zkzh;

    private String sfzh;

    private String xm;

    private String zydm;

    private String zymc;

    private String zid;

    private String zkyx;

    private String zycc;

    private String bysj;

    private Short yzzt;

    private String yzbm;

    private String yzscsj;

    private Short sfscpdf;

    private String pdftime;

    private String pdflj;

    public BigDecimal getZkbybid() {
        return zkbybid;
    }

    public void setZkbybid(BigDecimal zkbybid) {
        this.zkbybid = zkbybid;
    }

    public String getZkzh() {
        return zkzh;
    }

    public void setZkzh(String zkzh) {
        this.zkzh = zkzh == null ? null : zkzh.trim();
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

    public String getZydm() {
        return zydm;
    }

    public void setZydm(String zydm) {
        this.zydm = zydm == null ? null : zydm.trim();
    }

    public String getZymc() {
        return zymc;
    }

    public void setZymc(String zymc) {
        this.zymc = zymc == null ? null : zymc.trim();
    }

    public String getZid() {
        return zid;
    }

    public void setZid(String zid) {
        this.zid = zid == null ? null : zid.trim();
    }

    public String getZkyx() {
        return zkyx;
    }

    public void setZkyx(String zkyx) {
        this.zkyx = zkyx == null ? null : zkyx.trim();
    }

    public String getZycc() {
        return zycc;
    }

    public void setZycc(String zycc) {
        this.zycc = zycc == null ? null : zycc.trim();
    }

    public String getBysj() {
        return bysj;
    }

    public void setBysj(String bysj) {
        this.bysj = bysj == null ? null : bysj.trim();
    }

    public Short getYzzt() {
        if(yzzt == null) {
            return 0;
        }
        return yzzt;
    }

    public void setYzzt(Short yzzt) {
        this.yzzt = yzzt;
    }

    public String getYzbm() {
        return yzbm;
    }

    public void setYzbm(String yzbm) {
        this.yzbm = yzbm == null ? null : yzbm.trim();
    }

    public String getYzscsj() {
        return yzscsj;
    }

    public void setYzscsj(String yzscsj) {
        this.yzscsj = yzscsj == null ? null : yzscsj.trim();
    }

    public Short getSfscpdf() {
        if(sfscpdf == null) {
            return  0;
        }
        return sfscpdf;
    }

    public void setSfscpdf(Short sfscpdf) {
        this.sfscpdf = sfscpdf;
    }

    public String getPdftime() {
        return pdftime;
    }

    public void setPdftime(String pdftime) {
        this.pdftime = pdftime == null ? null : pdftime.trim();
    }

    public String getPdflj() {
        return pdflj;
    }

    public void setPdflj(String pdflj) {
        this.pdflj = pdflj == null ? null : pdflj.trim();
    }
}