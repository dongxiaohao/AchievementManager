package com.lnavm.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class DlrzInfo implements Serializable {
    private BigDecimal dlrzid;

    private String sjh;

    private String dlzh;

    private Short dlfs;

    private String ipdz;

    private String dlsj;

    private String operate;

    public BigDecimal getDlrzid() {
        return dlrzid;
    }

    public void setDlrzid(BigDecimal dlrzid) {
        this.dlrzid = dlrzid;
    }

    public String getSjh() {
        return sjh;
    }

    public void setSjh(String sjh) {
        this.sjh = sjh == null ? null : sjh.trim();
    }

    public String getDlzh() {
        return dlzh;
    }

    public void setDlzh(String dlzh) {
        this.dlzh = dlzh == null ? null : dlzh.trim();
    }

    public Short getDlfs() {
        return dlfs;
    }

    public void setDlfs(Short dlfs) {
        this.dlfs = dlfs;
    }

    public String getIpdz() {
        return ipdz;
    }

    public void setIpdz(String ipdz) {
        this.ipdz = ipdz == null ? null : ipdz.trim();
    }

    public String getDlsj() {
        return dlsj;
    }

    public void setDlsj(String dlsj) {
        this.dlsj = dlsj == null ? null : dlsj.trim();
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate == null ? null : operate.trim();
    }
}