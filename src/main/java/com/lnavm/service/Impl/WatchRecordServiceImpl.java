package com.lnavm.service.Impl;

import com.lnavm.Config.ExaminationToCode;
import com.lnavm.dao.CxbInfoMapper;
import com.lnavm.dao.DlrzInfoMapper;
import com.lnavm.dao.XtrzInfoMapper;
import com.lnavm.pojo.CxRecord;
import com.lnavm.pojo.CxbInfo;
import com.lnavm.pojo.DlrzInfo;
import com.lnavm.pojo.XtrzInfo;
import com.lnavm.service.WatchRecordService;
import com.lnavm.thirdutils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

@Service
public class WatchRecordServiceImpl implements WatchRecordService {
//    XtrzInfoMapper xtrzInfoMapper
    @Autowired
    CxbInfoMapper cxbInfoMapper;
    @Autowired
    ExaminationToCode examinationToCode;
    @Autowired
    DlrzInfoMapper dlrzInfoMapper;

    @Override
    public List<CxRecord> QueryRecoed(String kslx, String starttime, String endtime, String order, String yhsjh , Page<CxRecord> page) {
        System.out.println("系统日志查询...");
        List<CxRecord> list;
        //默认降序
        if(order==null || "".equals(order) || order.equals("0"))
            order="desc";
        else
            order="asc";
        if(kslx!=null && kslx.equals("0"))
            kslx=null;
        if(yhsjh==null || yhsjh.trim().length()==0)
            yhsjh=null;
//        starttime = GuifanTime(starttime,0);
//        endtime = GuifanTime(endtime,1);
        if((kslx==null || kslx.trim().length()==0) &&( starttime==null||starttime.trim().length()==0 )&&
                (endtime==null || endtime.trim().length()==0) &&( yhsjh==null || yhsjh.trim().length()==0))
        {
            System.out.println("统计全部");
            list=cxbInfoMapper.queryByAll(order,page);
        } else{
            System.out.println("部分查询");
            starttime=this.Guifan(starttime,0);
            endtime=this.Guifan(endtime,1);
        //            list=cxbInfoMapper.queryByKslx(kslx,startstringToTimpstamp(starttime,0),startstringToTimpstamp(endtime,1),order,yhsjh,page);
            list=cxbInfoMapper.queryByKslx(kslx,starttime,endtime,order,yhsjh,page);
        }

        //添加考试名称
        for(CxRecord cxRecord:list){
            String str=""+cxRecord.getKslx();
            cxRecord.setKsm(examinationToCode.getExaminationMap().get(str));

//            System.out.println(examinationToCode.getExaminationMap().get(str));
        }
//        System.out.println(list.size());
        return list;
    }

    @Override
    public int countRecord(String kslx, String starttime, String endtime,  String yhsjh) {
        System.out.println("统计日志数量...");
        //默认降序
        int result=0;
//        starttime = startstringToTimpstamp(starttime,0);
//        endtime = startstringToTimpstamp(endtime,1);
        if(kslx!=null && kslx.equals("0"))
            kslx=null;
        if(yhsjh==null && yhsjh.trim().length()==0)
            yhsjh=null;
        if((kslx==null || kslx.trim().length()==0) && ( starttime==null||starttime.trim().length()==0 )&&
                (endtime==null || endtime.trim().length()==0) &&( yhsjh==null || yhsjh.trim().length()==0))
            result=cxbInfoMapper.countAll();
        else{
            starttime=this.Guifan(starttime,0);
            endtime=this.Guifan(endtime,1);
            result=cxbInfoMapper.countByKslx(kslx,starttime,endtime,yhsjh);
        }

        System.out.println("总数量"+result);
        return result;
    }

    /**
     *
     * @param starttime
     * @param endtime
     * @return
     */
    @Override
    public HashMap<String,String> StatisticRecord(String starttime, String endtime) {
        System.out.println("统计考试查询数量...");
        //设置任务开始时间
//        if (!starttime.equals("")){
//            starttime = starttime + " 00:00:00";
//        }
//        else starttime=null;
        //设置任务截止时间
//        if (!endtime.equals("")){
//            endtime = endtime + " 23:59:59";
//        }
//        else endtime=null;
        starttime = Guifan(starttime,0);
        endtime = Guifan(endtime,1);
        HashMap<String,String> hash=new HashMap<>();
        for(String kslx: examinationToCode.getExaminationMap().keySet()) {
            int recordcount = cxbInfoMapper.statisticByKslx(kslx,starttime,endtime);
            switch (kslx){
                case "13":
                    hash.put("crgk",""+recordcount);
                    break;
                case "14":
                    hash.put("zkby",""+recordcount);
                    break;
                case "15":
                    hash.put("xysp",""+recordcount);
                    break;
                case "16":
                    hash.put("dksx",""+recordcount);
                    break;
                case "11":
                    hash.put("gk",""+recordcount);
                    break;
                case "18":
                    hash.put("zxks",""+recordcount);
                    break;
            }

        }

        return hash;
    }

    public String Guifan(String time,int flag){
        if(time==null || time.trim().length()==0)
            return null;
        switch (flag){
            case 0:
                time = time + " 00:00:00";
                break;
            case 1:
                time = time + " 23:59:59";
                break;
        }
        return time.trim();
    }

    @Override
    public List<DlrzInfo> getJournal(String starttime, String endtime, String order, String yhsjh, Page<DlrzInfo> page) {
        System.out.println("查看用户操作...");
        List<DlrzInfo> list;
        if(yhsjh==null || yhsjh.trim().length()==0)
            yhsjh=null;
        starttime=Guifan(starttime,0);
        endtime=Guifan(endtime,1);
        if(order==null || "".equals(order) || order.equals("0"))
            order="desc";
        else
            order="asc";
        if(( starttime==null||starttime.trim().length()==0 )&& (endtime==null || endtime.trim().length()==0)
                &&( yhsjh==null || yhsjh.trim().length()==0)){
            list = dlrzInfoMapper.listAll(order,page);
        }else {
            list = dlrzInfoMapper.queryWithCom(starttime,endtime,yhsjh,order,page);
        }
        return list;
    }

    @Override
    public int countJournal(String starttime, String endtime, String yhsjh) {
        System.out.println("统计用户操作...");
        int count=0;
        if(yhsjh==null || yhsjh.trim().length()==0)
            yhsjh=null;
        starttime=Guifan(starttime,0);
        endtime=Guifan(endtime,1);
        if(( starttime==null||starttime.trim().length()==0 )&& (endtime==null || endtime.trim().length()==0)
                &&( yhsjh==null || yhsjh.trim().length()==0)){
            count = dlrzInfoMapper.countAll();
        }else {
            count = dlrzInfoMapper.countWithCom(starttime,endtime,yhsjh);
        }
        return count;
    }
}
