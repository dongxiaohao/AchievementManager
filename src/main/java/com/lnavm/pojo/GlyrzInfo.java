package com.lnavm.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class GlyrzInfo implements Serializable {
    private BigDecimal glyrzid;

    private String xm;

    private String dlzh;

    private String bm;

    private String ipdz;

    private String cxsfzh;

    private Short cxkslx;

    private String qqff;

    private Short czjg;

    private String czsj;

    private String operate;

    public BigDecimal getGlyrzid() {
        return glyrzid;
    }

    public void setGlyrzid(BigDecimal glyrzid) {
        this.glyrzid = glyrzid;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public String getDlzh() {
        return dlzh;
    }

    public void setDlzh(String dlzh) {
        this.dlzh = dlzh == null ? null : dlzh.trim();
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm == null ? null : bm.trim();
    }

    public String getIpdz() {
        return ipdz;
    }

    public void setIpdz(String ipdz) {
        this.ipdz = ipdz == null ? null : ipdz.trim();
    }

    public String getCxsfzh() {
        return cxsfzh;
    }

    public void setCxsfzh(String cxsfzh) {
        this.cxsfzh = cxsfzh == null ? null : cxsfzh.trim();
    }

    public Short getCxkslx() {
        return cxkslx;
    }

    public void setCxkslx(Short cxkslx) {
        this.cxkslx = cxkslx;
    }

    public String getQqff() {
        return qqff;
    }

    public void setQqff(String qqff) {
        this.qqff = qqff == null ? null : qqff.trim();
    }

    public Short getCzjg() {
        return czjg;
    }

    public void setCzjg(Short czjg) {
        this.czjg = czjg;
    }

    public String getCzsj() {
        return czsj;
    }

    public void setCzsj(String czsj) {
        this.czsj = czsj == null ? null : czsj.trim();
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate == null ? null : operate.trim();
    }
}