package com.lnavm.pojo;

import java.math.BigDecimal;

public class ZkkscjInfo {
    private BigDecimal zkcjid;

    private String zkzh;

    private String sfzh;

    private String xm;

    private String score;

    private Short yzzt;

    private String yzbm;

    private String yzscsj;

    private Short sfscpdf;

    private String pdftime;

    private String pdflj;

    public BigDecimal getZkcjid() {
        return zkcjid;
    }

    public void setZkcjid(BigDecimal zkcjid) {
        this.zkcjid = zkcjid;
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
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
            return 0;
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