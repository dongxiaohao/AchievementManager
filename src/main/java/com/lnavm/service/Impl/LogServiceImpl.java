package com.lnavm.service.Impl;

import com.lnavm.dao.GlyrzInfoMapper;
import com.lnavm.dao.GlyxxInfoMapper;
import com.lnavm.pojo.GlyrzInfo;
import com.lnavm.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    GlyrzInfoMapper glyrzInfoMapper;

    @Override
    public void save(GlyrzInfo glyrzInfo) {
        glyrzInfoMapper.insertSelective(glyrzInfo);
    }
}
