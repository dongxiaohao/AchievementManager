package com.lnavm.service.Impl;

import com.lnavm.Config.ExaminationToCode;
import com.lnavm.dao.CxbInfoMapper;
import com.lnavm.dao.XtrzInfoMapper;
import com.lnavm.pojo.CxRecord;
import com.lnavm.pojo.CxbInfo;
import com.lnavm.pojo.XtrzInfo;
import com.lnavm.service.WatchRecordService;
import com.lnavm.thirdutils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class WatchRecordServiceImpl implements WatchRecordService {
//    XtrzInfoMapper xtrzInfoMapper
    @Autowired
    CxbInfoMapper cxbInfoMapper;
    @Autowired
    ExaminationToCode examinationToCode;

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
        starttime = GuifanTime(starttime,0);
        endtime = GuifanTime(endtime,1);
        if((kslx==null || kslx.trim().length()==0) &&( starttime==null||starttime.trim().length()==0 )&&
                (endtime==null || endtime.trim().length()==0) &&( yhsjh==null || yhsjh.trim().length()==0))
        {
            System.out.println("统计全部");
            list=cxbInfoMapper.queryByAll(order,page);
        } else{
            System.out.println("部分查询");
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
        starttime = GuifanTime(starttime,0);
        endtime = GuifanTime(endtime,1);
        if(kslx!=null && kslx.equals("0"))
            kslx=null;
        if((kslx==null || kslx.trim().length()==0) &&( starttime==null||starttime.trim().length()==0 )&&
                (endtime==null || endtime.trim().length()==0) &&( yhsjh==null || yhsjh.trim().length()==0))
            result=cxbInfoMapper.countAll();
        else
            result=cxbInfoMapper.countByKslx(kslx,starttime,endtime,yhsjh);
//        System.out.println("总数量"+result);
        return result;
    }

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
        starttime = GuifanTime(starttime,0);
        endtime = GuifanTime(endtime,1);
        HashMap<String,String> hash=new HashMap<>();
        for(String kslx: examinationToCode.getExaminationMap().keySet()) {
            int recordcount = cxbInfoMapper.statisticByKslx(kslx,starttime,endtime);
            hash.put(examinationToCode.getExaminationMap().get(kslx),""+recordcount);
        }

        return hash;
    }

    /**
     * 将时间变为标准格式
     * @param time 输入格式：xxxx-xx-xx
     * @param flag 0 起始时间 1 截止时间
     * @return
     */
    public String GuifanTime(String time,int flag){
        if(time != null && time.trim().length()!=0){
            if(flag == 0)
                return time+" 00:00:00";
            else
                return time+ " 23:59:59";
        }
        return null;
    }
}
