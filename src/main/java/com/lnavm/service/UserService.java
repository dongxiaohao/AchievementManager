package com.lnavm.service;

import com.lnavm.entity.Resultentity;
import com.lnavm.pojo.YhrecordInfo;
import com.lnavm.pojo.YhxxInfo;
import com.lnavm.statusenum.Status;
import com.lnavm.thirdutils.Page;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface UserService {

    /**
     * 查询用户信息
     * @param SfzhorSjh 为空表示，查询全部用户
     * @param page
     * @return
     */
    List<YhrecordInfo> QueryUser(String SfzhorSjh, Page<YhrecordInfo> page);

    /**
     * 返回符合条件的用户数量
     * @return
     */
    int CountUserCon(String SfzhorSjh);

    /**
     * 通过用户id修改手机号
     * @param yhid
     * @param sjh
     * @return
     */
    Status MatifyUserSJH(String yhid,String sjh);

    Resultentity<String> getUserState(Status status);


    /**
     * 修改用户登录标志位
     * @param yhid 用户id
     * @param Banbz 修改之后的用户登录标志
     * @return
     */
    Status updataUserBan(String yhid,int Banbz);

    int insertYHZT(BigDecimal yhid,int Banbz);

}
