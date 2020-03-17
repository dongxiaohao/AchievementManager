package com.lnavm.Config;

/**
 * 每类考试元信息
 */
public class Examination {
    private String name;            //考试名字
    private int scoreCols;          //每列显示几颗成绩
    private String engName;         //考试英文缩写
    private int code;               //考试编码
    private int startYear;          //考试起始年份，-1代表没有起始年份
    private int stopYear;           //考试结束年份，-1代表没有结束年份
    private String timeList;        //每年考试月份，如果为-1，则不存在月份信息
    private String pdfTemplate;     //pdf模板

    public String getName() {
        return name;
    }

    public int getScoreCols() {
        return scoreCols;
    }

    public void setScoreCols(int scoreCols) {
        this.scoreCols = scoreCols;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getStopYear() {
        return stopYear;
    }

    public void setStopYear(int stopYear) {
        this.stopYear = stopYear;
    }

    public String getTimeList() {
        return timeList;
    }

    public void setTimeList(String timeList) {
        this.timeList = timeList;
    }

    public String getPdfTemplate() {
        return pdfTemplate;
    }

    public void setPdfTemplate(String pdfTemplate) {
        this.pdfTemplate = pdfTemplate;
    }
}
