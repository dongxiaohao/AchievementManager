package com.lnavm.service.Impl;

import com.lnavm.dao.YhxxInfoMapper;
import com.lnavm.entity.Resultentity;
import com.lnavm.pojo.YhxxInfo;
import com.lnavm.service.UserService;
import com.lnavm.statusenum.Status;
import com.lnavm.thirdutils.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    YhxxInfoMapper yhxxInfoMapper;

    /**
     *
     * @param SfzhorSjh 为空表示，查询全部用户
     * @param page
     * @return
     */
    @Override
    public List<YhxxInfo> QueryUser(String SfzhorSjh, Page<YhxxInfo> page) {
        List<YhxxInfo> result=new ArrayList<>();
        if(SfzhorSjh.length()==0 || SfzhorSjh.equals("")){
            result=yhxxInfoMapper.selectAll(page);
        }else if(SfzhorSjh.length()== 11){
            result.add(yhxxInfoMapper.selectBySJH(SfzhorSjh));
        }else if(SfzhorSjh.length()==15 || SfzhorSjh.length()==18){
            result.add(yhxxInfoMapper.selectBySJH(SfzhorSjh));
        }

        return result;
    }

    /**
     *
     * @param yhid
     * @param sjh
     * @return
     */
    @Override
    public Status MatifyUserSJH(String yhid,String sjh) {
        if(sjh.length() != 11) {
            return Status.ERROR_SJH;
        }
        try {
            if (yhxxInfoMapper.updateSJHbyYHID(yhid, sjh) > 0)
                return Status.OK;
            else
                return  Status.FAIL_MOTIFYSJH;
        }catch (Exception e){
                return Status.ERROR;
        }
    }

    /**
     *
     * @param status
     * @return
     */
    @Override
    public Resultentity<String> getUserState(Status status) {
        Resultentity<String> resultentity=new Resultentity<String>();
        resultentity.setResult(0-status.ordinal());
        switch (status){
            case OK:
                resultentity.setMessage(Status.OK_MAG);
                break;
            case FAIL_MOTIFYSJH:
                resultentity.setMessage(Status.FAIL_MOTIFYSJH_MAG);
                break;
            case ERROR_SJH:
                resultentity.setMessage(Status.ERROR_MAG);
                break;
            case ERROR:
                resultentity.setMessage(Status.ERROR_MAG);
                break;
        }
        return resultentity;
    }
}
