package com.lnavm.service;

import com.lnavm.entity.Resultentity;
import com.lnavm.pojo.YhxxInfo;
import com.lnavm.statusenum.Status;
import com.lnavm.thirdutils.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    /**
     * 查询用户信息
     * @param SfzhorSjh 为空表示，查询全部用户
     * @param page
     * @return
     */
    List<YhxxInfo> QueryUser(String SfzhorSjh, Page<YhxxInfo> page);

    /**
     * 通过用户id修改手机号
     * @param yhid
     * @param sjh
     * @return
     */
    Status MatifyUserSJH(String yhid,String sjh);

    Resultentity<String> getUserState(Status status);

}
