package com.lnavm.pojo;

import java.math.BigDecimal;

public class XyspInfo {
    private BigDecimal xyspid;

    private String ksh;

    private String ksnf;

    private String sfzh;

    private String xm;

    private String xjh;

    private String byzxmc;

    private String score;

    private String deletebk;

    private Short yzzt;

    private String yzbm;

    private String yzscsj;

    private Short sfscpdf;

    private String pdftime;

    private String pdflj;

    public BigDecimal getXyspid() {
        return xyspid;
    }

    public void setXyspid(BigDecimal xyspid) {
        this.xyspid = xyspid;
    }

    public String getKsh() {
        return ksh;
    }

    public void setKsh(String ksh) {
        this.ksh = ksh == null ? null : ksh.trim();
    }

    public String getKsnf() {
        return ksnf;
    }

    public void setKsnf(String ksnf) {
        this.ksnf = ksnf == null ? null : ksnf.trim();
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

    public String getXjh() {
        return xjh;
    }

    public void setXjh(String xjh) {
        this.xjh = xjh == null ? null : xjh.trim();
    }

    public String getByzxmc() {
        return byzxmc;
    }

    public void setByzxmc(String byzxmc) {
        this.byzxmc = byzxmc == null ? null : byzxmc.trim();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public String getDeletebk() {
        return deletebk;
    }

    public void setDeletebk(String deletebk) {
        this.deletebk = deletebk == null ? null : deletebk.trim();
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