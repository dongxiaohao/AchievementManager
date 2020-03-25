package com.lnavm.service.Impl;

import com.lnavm.dao.YhxxInfoMapper;
import com.lnavm.dao.YhztInfoMapper;
import com.lnavm.entity.Resultentity;
import com.lnavm.pojo.YhrecordInfo;
import com.lnavm.pojo.YhxxInfo;
import com.lnavm.pojo.YhztInfo;
import com.lnavm.service.UserService;
import com.lnavm.statusenum.Status;
import com.lnavm.thirdutils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    YhxxInfoMapper yhxxInfoMapper;
    @Autowired
    YhztInfoMapper yhztInfoMapper;

    /**
     *
     * @param SfzhorSjh 为空表示，查询全部用户
     * @param page
     * @return
     */
    @Override
    public List<YhrecordInfo> QueryUser(String SfzhorSjh, Page<YhrecordInfo> page) {
        List<YhrecordInfo> result=new ArrayList<>();
        if(SfzhorSjh.length()==0 || SfzhorSjh.equals("")){
            result=yhxxInfoMapper.selectUserBysjh(page,null,null);
        }else if(SfzhorSjh.length()== 11){
            result=yhxxInfoMapper.selectUserBysjh(page,SfzhorSjh,null);
//            result.add(yhxxInfoMapper.selectBySJH(SfzhorSjh));
        }else if(SfzhorSjh.length()==15 || SfzhorSjh.length()==18){
            result=yhxxInfoMapper.selectUserBysjh(page,null,SfzhorSjh);
//            result.add(yhxxInfoMapper.selectBySJH(SfzhorSjh));
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
            case FAIL_BAN:
                resultentity.setMessage(Status.FAIL_BAN_MAG);
        }
        return resultentity;
    }

    @Override
    public Status updataUserBan(String yhid, int Banbz) {
        try {
            if (yhztInfoMapper.selectZTByYHID(new BigDecimal(yhid)) == null) {
                if (insertYHZT(new BigDecimal(yhid), Banbz) > 0) {
                    return Status.OK;
                } else
                    return Status.FAIL_BAN;
            }else {
                if (yhztInfoMapper.updataZTBYYHIH(new BigDecimal(yhid),Banbz)>0)
                    return Status.OK;
                return Status.FAIL_BAN;
            }
        }catch (Exception e){
            return Status.ERROR;
        }
    }

    @Override
    public int insertYHZT(BigDecimal yhid,int Banbz) {
        YhztInfo yhztInfo = new YhztInfo();
        yhztInfo.setYhid(yhid);
        yhztInfo.setZtbz(Banbz);
        System.out.println(yhid);
        if(yhztInfoMapper.insertSelective(yhztInfo)>0)
            return 1;
        return 0;
    }
}
