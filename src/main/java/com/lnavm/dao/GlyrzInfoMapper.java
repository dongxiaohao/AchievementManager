package com.lnavm.dao;

import com.lnavm.pojo.GlyrzInfo;

import java.math.BigDecimal;

public interface GlyrzInfoMapper {
    int deleteByPrimaryKey(BigDecimal glyrzid);

    int insert(GlyrzInfo record);

    int insertSelective(GlyrzInfo record);

    GlyrzInfo selectByPrimaryKey(BigDecimal glyrzid);

    int updateByPrimaryKeySelective(GlyrzInfo record);

    int updateByPrimaryKey(GlyrzInfo record);
}