package com.lnavm.pojo;

import java.math.BigDecimal;

public class GlyxxInfo {
    private BigDecimal glyid;

    private String glyzh;

    private String mm;

    private String sfzh;

    private String xm;

    private String gh;

    private String bm;

    private String yx;

    public BigDecimal getGlyid() {
        return glyid;
    }

    public void setGlyid(BigDecimal glyid) {
        this.glyid = glyid;
    }

    public String getGlyzh() {
        return glyzh;
    }

    public void setGlyzh(String glyzh) {
        this.glyzh = glyzh == null ? null : glyzh.trim();
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

    public String getGh() {
        return gh;
    }

    public void setGh(String gh) {
        this.gh = gh == null ? null : gh.trim();
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm == null ? null : bm.trim();
    }

    public String getYx() {
        return yx;
    }

    public void setYx(String yx) {
        this.yx = yx == null ? null : yx.trim();
    }
}