package com.lnavm.service;

import com.lnavm.pojo.CxRecord;
import com.lnavm.pojo.CxbInfo;
import com.lnavm.pojo.DlrzInfo;
import com.lnavm.pojo.XtrzInfo;
import com.lnavm.thirdutils.Page;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public interface WatchRecordService {
    /**
     *
     * @param kslx
     * @param starttime
     * @param endtime
     * @param order
     * @return
     */
    List<CxRecord> QueryRecoed(String kslx, String starttime, String endtime, String order , String yhsjh, Page<CxRecord> page);

    /**
     *
     * @param kslx
     * @param starttime
     * @param endtime
     * @param yhsjh
     * @return
     */
    int countRecord(String kslx, String starttime, String endtime, String yhsjh);

    /**
     * 统计一段时间内的各类考试数量
     * @param starttime
     * @param endtime
     * @return
     */
    HashMap<String,String> StatisticRecord(String starttime, String endtime);

    /**
     * 规范时间格式，将yyyy-mm-dd格式的时间转化为 yyyy-mm-dd hh：mm：ss的格式
     * @param time
     * @param flag
     * @return
     */
    String Guifan(String time,int flag);

    /**
     * 显示登录日志，注：登录日志记载了除用户查询之外的全部操作
     * @param starttime
     * @param endtime
     * @param order
     * @param yhsjh
     * @param page
     * @return
     */
    List<DlrzInfo> getJournal(String starttime, String endtime, String order, String yhsjh, Page<DlrzInfo>page);

    /**
     * 统计符合条件的登录日志的数量
     * @param starttime
     * @param endtime
     * @param yhsjh
     * @return
     */
    int countJournal(String starttime,String endtime,String yhsjh);
}
