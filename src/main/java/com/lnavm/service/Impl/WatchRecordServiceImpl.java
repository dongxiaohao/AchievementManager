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
        if(kslx==null || starttime==null || endtime==null || yhsjh==null)
            list=cxbInfoMapper.queryByAll(order,page);
        else
            list=cxbInfoMapper.queryByKslx(kslx,starttime,endtime,order,yhsjh,page);
        System.out.println(list.size());
        return list;
    }
}
