package com.lnavm.service;

import com.lnavm.pojo.CxRecord;
import com.lnavm.pojo.CxbInfo;
import com.lnavm.thirdutils.Page;
import org.springframework.stereotype.Service;

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
}
