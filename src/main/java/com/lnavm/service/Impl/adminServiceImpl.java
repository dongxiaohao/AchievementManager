package com.lnavm.service.Impl;

import com.lnavm.dao.GlyxxInfoMapper;
import com.lnavm.entity.Resultentity;
import com.lnavm.pojo.GlyxxInfo;
import com.lnavm.service.adminService;
import com.lnavm.statusenum.Status;
import com.lnavm.thirdutils.Page;
import com.lnavm.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class adminServiceImpl implements adminService {
    @Autowired
    GlyxxInfoMapper glyxxInfoMapper;

    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    @Override
    public Status loginin(String username, String password) {
        //空校验
        if(username.length()==0|| username.equals(""))
            return Status.EMPTY_USERNAME;
        if(password.length()==0 || password.equals(""))
            return Status.EMPTY_PASSWORD;
        try {
            String right_password = glyxxInfoMapper.selectPASSByGLYM(username);
            if (right_password.length() == 0 || right_password.equals(""))
                return Status.ERROR_USERNAME;
            if (MD5Utils.getSaltverifyMD5(password, right_password))
                return Status.OK;
            return Status.EMPTY_PASSWORD;
        }catch (Exception e){
            return Status.ERROR;
        }
    }

    /**
     * 通过管理员名查看管理员信息
     * @param username
     * @return
     */
    @Override
    public GlyxxInfo getGlyxxInfo(String username) {
        return glyxxInfoMapper.selectByGLYM(username);
    }

    /**
     * 将各种状态信息转化为返回实体信息
     * @return
     */
    @Override
    public Resultentity<String> getAdminState(Status status) {
        Resultentity<String> resultentity=new Resultentity<String>();
        resultentity.setResult(0-status.ordinal());//0 状态为成功，其他状态都为负数代表失败,不同的负值具有不同的意义
        switch(status){
            case OK:
                resultentity.setMessage(Status.OK_MAG);
                break;
            case EMPTY_PASSWORD:
                resultentity.setMessage(Status.EMPTY_PASSWORD_MAG);
                break;
            case EMPTY_USERNAME:
                resultentity.setMessage(Status.EMPTY_USERNAME_MAG);
                break;
            case ERROR_PASSWORD:
                resultentity.setMessage(Status.ERROR_PASSWORD_MAG);
                break;
            case ERROR_USERNAME:
                resultentity.setMessage(Status.ERROR_USERNAME_MAG);
                break;
            case ERROR:
                resultentity.setMessage(Status.ERROR_MAG);
                break;

        }

        return resultentity;
    }

    /**
     * 展示所有管理员信息
     * @return
     */
    @Override
    public List<GlyxxInfo> listAll(Page<GlyxxInfo> page) {
        System.out.println("查看全部管理员");
        try {
            return glyxxInfoMapper.selectAll(page);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Status addadmin(String username,String password) {
        System.out.println("添加管理员...");
        GlyxxInfo glyxxInfo=new GlyxxInfo();
        String pwdAfterSalt = MD5Utils.getSaltMD5(password.trim());
        glyxxInfo.setMm(pwdAfterSalt);
        glyxxInfo.setGlyzh(username);
       // Resultentity resultentity=new Resultentity();
        try {
            if(glyxxInfoMapper.insertSelective(glyxxInfo)>0)
                return Status.OK;
            else
                return Status.FAIL_ADDADMIN;

        }catch (Exception e){
            System.out.println(e.toString());
                return Status.ERROR;
        }
    }

}
