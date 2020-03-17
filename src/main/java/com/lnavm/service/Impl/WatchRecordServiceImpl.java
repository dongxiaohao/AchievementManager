package com.lnavm.service.Impl;

import com.lnavm.dao.CxbInfoMapper;
import com.lnavm.dao.XtrzInfoMapper;
import com.lnavm.pojo.CxbInfo;
import com.lnavm.pojo.XtrzInfo;
import com.lnavm.service.WatchRecordService;
import com.lnavm.thirdutils.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchRecordServiceImpl implements WatchRecordService {
//    XtrzInfoMapper xtrzInfoMapper
    CxbInfoMapper cxbInfoMapper;
    @Override
    public List<CxbInfo> QueryRecoed(String kslx, String starttime, String endtime, String order,String yhsjh , Page<CxbInfo> page) {
        return cxbInfoMapper.queryByKslx(kslx,starttime,endtime,order,yhsjh,page);
    }
}
