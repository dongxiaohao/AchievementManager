package com.lnavm.entity;

import java.util.HashMap;

public class Grades {
    private HashMap<String, String> scoresMap; //成绩信息map，科目-成绩
    private HashMap<String,String> otherMap;  //其他信息map，主要是自考

    /**
     * 设置成绩
     * @param scores
     */
    public void setScores(String scores) {
        this.scoresMap = splitScores(scores);
    }

    /**
     * 将成绩字符串切分为map结构
     * @param scores    成绩拼接字符串
     * @return          科目-成绩的一一映射map
     */
    public static HashMap<String, String> splitScores(String scores) {
        HashMap<String, String> scoresMap = new HashMap<>();

        String[] subjectAndScore;
        String[] scoreArr = scores.split(",");
        String curSubject;
        String curScore;

        for(String eachScore : scoreArr) {
            //非空检验
            if(eachScore == null || "".equals((eachScore=eachScore.trim()))) {
                continue;
            }
            subjectAndScore = eachScore.trim().split(":");
            //不合法,限制不合法显示
            if(subjectAndScore.length < 1) {
                continue;
            }
            else if(subjectAndScore.length == 1) { //可能只有科目，没有成绩
                curSubject = subjectAndScore[0];
                if (curSubject != null && !"".equals((curSubject = curSubject.trim()))) {
                    scoresMap.put(curSubject, null);
                }
            }
            else {
                curSubject = subjectAndScore[0];
                curScore = subjectAndScore[1];
                if (curSubject != null && !"".equals((curSubject = curSubject.trim())) && curScore != null && !"".equals((curScore = curScore.trim()))) {
                    scoresMap.put(curSubject, curScore);
                }
            }
        }
        return scoresMap;
    }

    /**
     *往成绩单上添加其他信息
     * @param xxmc   信息名称
     * @param xxnr   信息内容
     */
    public void addOtherMessage(String xxmc, String xxnr) {
        if(this.otherMap == null) {
            this.otherMap = new HashMap<>();
        }
        this.otherMap.put(xxmc, xxnr);
    }

    public HashMap<String, String> getScoresMap() {
        return scoresMap;
    }

    public HashMap<String, String> getOtherMap() {
        return otherMap;
    }

    public void setOtherMap(HashMap<String, String> otherMap) {
        this.otherMap = otherMap;
    }
}
