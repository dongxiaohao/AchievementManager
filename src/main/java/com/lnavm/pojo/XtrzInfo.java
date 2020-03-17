package com.lnavm.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class XtrzInfo implements Serializable {
    private BigDecimal rzid;

    private String yhip;

    private String yhsjh;

    private String cxsfzh;

    private Short cxkslx;

    private String fwurl;

    private String qqff;

    private Short czjg;

    private String fwsj;

    private String operate;

    public BigDecimal getRzid() {
        return rzid;
    }

    public void setRzid(BigDecimal rzid) {
        this.rzid = rzid;
    }

    public String getYhip() {
        return yhip;
    }

    public void setYhip(String yhip) {
        this.yhip = yhip == null ? null : yhip.trim();
    }

    public String getYhsjh() {
        return yhsjh;
    }

    public void setYhsjh(String yhsjh) {
        this.yhsjh = yhsjh == null ? null : yhsjh.trim();
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

    public String getFwurl() {
        return fwurl;
    }

    public void setFwurl(String fwurl) {
        this.fwurl = fwurl == null ? null : fwurl.trim();
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

    public String getFwsj() {
        return fwsj;
    }

    public void setFwsj(String fwsj) {
        this.fwsj = fwsj == null ? null : fwsj.trim();
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate == null ? null : operate.trim();
    }
}