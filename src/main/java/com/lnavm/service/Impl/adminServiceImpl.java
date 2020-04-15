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

import java.math.BigDecimal;
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
        if(username==null||username.trim().length()==0 )
            return Status.EMPTY_USERNAME;
        if( password==null || password.trim().length()==0 )
            return Status.EMPTY_PASSWORD;
        try {
            GlyxxInfo glyxxInfo=getGlyxxInfo(username);
            if (glyxxInfo == null)
                return Status.ERROR_USERNAME;
            if (MD5Utils.getSaltverifyMD5(password, glyxxInfo.getMm())){
                if(glyxxInfo.getBm() == "0")
                    return Status.BAN_ADMIN;
                return Status.OK;
            }

            return Status.EMPTY_PASSWORD;
        }catch (Exception e){
            System.out.println(e.toString());
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
            case EMPTY_ADMINID:
                resultentity.setMessage(Status.EMPTY_ADMINID_MAG);
                break;
            case FAIL_UPDATAADMIN:
                resultentity.setMessage(Status.FAIL_UPDATAADMIN_MAG);
                break;
            case FAIL_UPDATAADMINSTU:
                resultentity.setMessage(Status.FAIL_UPDATAADMINSTU_MAG);
                break;
            case BAN_ADMIN:
                resultentity.setMessage(Status.BAN_ADMIN_MAG);
                break;
            case SAME_ADMIN:
                resultentity.setMessage(Status.SAME_ADMIN_MAG);
                break;
            case VALID_ADMIN_SMALL:
                resultentity.setMessage(Status.VALID_ADMIN_SMALL_MAG);
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
        if(username == null || username.trim().length()==0)
            return Status.EMPTY_USERNAME;
        if(password == null || password.trim().length() ==0)
            return Status.EMPTY_PASSWORD;
        GlyxxInfo glyxxInfo=new GlyxxInfo();
        String pwdAfterSalt = MD5Utils.getSaltMD5(password.trim());
        glyxxInfo.setMm(pwdAfterSalt);
        glyxxInfo.setGlyzh(username);
        glyxxInfo.setBm("1");
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

    @Override
    public Status MotifyAdmin(String glyid,String username, String password) {
        GlyxxInfo glyxxInfo=new GlyxxInfo();
        if(glyid == null || glyid.trim().length()==0)
            return Status.EMPTY_ADMINID;
        if(username == null || username.trim().length()==0)
            return Status.EMPTY_USERNAME;
        if(password == null || password.trim().length() ==0)
            return Status.EMPTY_PASSWORD;
        glyxxInfo.setGlyzh(username);
        glyxxInfo.setGlyid(new BigDecimal(glyid));
        glyxxInfo.setMm(MD5Utils.getSaltMD5(password));
        try{
            if(glyxxInfoMapper.updateByPrimaryKeySelective(glyxxInfo)>0)
                return Status.OK;
            return Status.FAIL_UPDATAADMIN;
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return Status.ERROR;
    }

    @Override
    public Status adminZT(String glyid, Integer ToStatus) {

        if(glyid == null || glyid.trim().length()==0)
            return Status.EMPTY_ADMINID;
        try{
            if(glyxxInfoMapper.updateBMByGlyid(glyid,ToStatus.toString())>0)
                return Status.OK;
            return Status.FAIL_UPDATAADMINSTU;
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return Status.ERROR;
    }

    @Override
    public int countValidAdmin(int Status) {
        return glyxxInfoMapper.countAdminStatus(Status+"");
    }
}
