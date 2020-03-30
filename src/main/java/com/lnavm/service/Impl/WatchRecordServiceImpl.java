package com.lnavm.service.Impl;

import com.lnavm.dao.CxbInfoMapper;
import com.lnavm.dao.XtrzInfoMapper;
import com.lnavm.pojo.CxRecord;
import com.lnavm.pojo.CxbInfo;
import com.lnavm.pojo.XtrzInfo;
import com.lnavm.service.WatchRecordService;
import com.lnavm.thirdutils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchRecordServiceImpl implements WatchRecordService {
//    XtrzInfoMapper xtrzInfoMapper
    @Autowired
    CxbInfoMapper cxbInfoMapper;

    @Override
    public List<CxRecord> QueryRecoed(String kslx, String starttime, String endtime, String order, String yhsjh , Page<CxRecord> page) {
        System.out.println("系统日志查询...");
        List<CxRecord> list;
        //默认降序
        if(order==null || "".equals(order) || order.equals("0"))
            order="desc";
        else
            order="asc";
        if(kslx.equals("0"))
            kslx="";
        if((kslx==null && starttime==null && endtime==null && yhsjh==null)||
                (kslx.trim().length()==0 && starttime.trim().length()==0 && endtime.trim().length()==0 && yhsjh.trim().length()==0)){
            System.out.println("统计全部");
            list=cxbInfoMapper.queryByAll(order,page);
        } else{
            System.out.println("部分查询");
            System.out.println(yhsjh);
            list=cxbInfoMapper.queryByKslx(kslx,starttime,endtime,order,yhsjh,page);
        }

        System.out.println(list.size());
        return list;
    }

    @Override
    public int countRecord(String kslx, String starttime, String endtime,  String yhsjh) {
        System.out.println("统计日志数量...");
        //默认降序
        int result=0;
        if(kslx==null || starttime==null || endtime==null || yhsjh==null)
            result=cxbInfoMapper.countAll();
        else
            result=cxbInfoMapper.countByKslx(kslx,starttime,endtime,yhsjh);
        System.out.println("总数量"+result);
        return result;
    }

    @Override
    public int StatisticRecord(String kslx, String starttime, String endtime) {
        System.out.println("统计考试查询数量...");
        //设置任务开始时间
        if (!starttime.equals("")){
            starttime = starttime + " 00:00:00";
        }
        else starttime=null;
        //设置任务截止时间
        if (!endtime.equals("")){
            endtime = endtime + " 23:59:59";
        }
        else endtime=null;
        return cxbInfoMapper.statisticByKslx(kslx,starttime,endtime);
    }
}
