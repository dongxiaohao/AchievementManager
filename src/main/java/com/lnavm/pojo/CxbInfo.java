package com.lnavm.pojo;

import java.math.BigDecimal;

public class CxbInfo {
    private BigDecimal cxid;

    private String sjh;

    private Short kslx;

    private String sfzh;

    private String xm;

    private String ksnf;

    private Short nnksbs;

    private String tjcxsj;

    private Short cxbzw;

    private String fhcxsj;

    private Short cxjgzt;

    private String yzbm;

    private Short yhsfck;

    private String yhcksj;

    public BigDecimal getCxid() {
        return cxid;
    }

    public void setCxid(BigDecimal cxid) {
        this.cxid = cxid;
    }

    public String getSjh() {
        return sjh;
    }

    public void setSjh(String sjh) {
        this.sjh = sjh == null ? null : sjh.trim();
    }

    public Short getKslx() {
        return kslx;
    }

    public void setKslx(Short kslx) {
        this.kslx = kslx;
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

    public String getKsnf() {
        return ksnf;
    }

    public void setKsnf(String ksnf) {
        this.ksnf = ksnf == null ? null : ksnf.trim();
    }

    public Short getNnksbs() {
        if(nnksbs == null) {
            return 0;
        }
        return nnksbs;
    }

    public void setNnksbs(Short nnksbs) {
        this.nnksbs = nnksbs;
    }

    public String getTjcxsj() {
        return tjcxsj;
    }

    public void setTjcxsj(String tjcxsj) {
        this.tjcxsj = tjcxsj == null ? null : tjcxsj.trim();
    }

    public Short getCxbzw() {
        if(cxbzw == null) {
            return 0;
        }
        return cxbzw;
    }

    public void setCxbzw(Short cxbzw) {
        this.cxbzw = cxbzw;
    }

    public String getFhcxsj() {
        return fhcxsj;
    }

    public void setFhcxsj(String fhcxsj) {
        this.fhcxsj = fhcxsj == null ? null : fhcxsj.trim();
    }

    public Short getCxjgzt() {
        if(cxjgzt == null) {
            return 0;
        }
        return cxjgzt;
    }

    public void setCxjgzt(Short cxjgzt) {
        this.cxjgzt = cxjgzt;
    }

    public String getYzbm() {
        return yzbm;
    }

    public void setYzbm(String yzbm) {
        this.yzbm = yzbm == null ? null : yzbm.trim();
    }

    public Short getYhsfck() {
        if(yhsfck == null) {
            return 0;
        }
        return yhsfck;
    }

    public void setYhsfck(Short yhsfck) {
        this.yhsfck = yhsfck;
    }

    public String getYhcksj() {
        return yhcksj;
    }

    public void setYhcksj(String yhcksj) {
        this.yhcksj = yhcksj == null ? null : yhcksj.trim();
    }
}