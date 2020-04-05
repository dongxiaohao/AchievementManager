package com.lnavm.service;

import com.lnavm.entity.Resultentity;
import com.lnavm.pojo.GlyxxInfo;
import com.lnavm.statusenum.Status;
import com.lnavm.thirdutils.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface adminService {
    /**
     *
     * @param username
     * @param password
     * @return
     */
    Status loginin(String username, String password);

    /**
     *
     * @param username
     * @return
     */
    GlyxxInfo getGlyxxInfo(String username);

    Resultentity<String> getAdminState(Status status);

    List<GlyxxInfo> listAll(Page<GlyxxInfo> page);

    Status addadmin(String username,String password);

    Status MotifyAdmin(String glyid,String username,String password);

    Status adminZT(String glyid,Integer ToStatus);

}
