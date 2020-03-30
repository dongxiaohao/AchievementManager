package com.lnavm.dao;

import com.lnavm.pojo.YhztInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface YhztInfoMapper {
    Integer selectZTByYHID(@Param("yhid") BigDecimal yhid);
    int updataZTBYYHIH(@Param("yhid") BigDecimal yhid, @Param("ztbz") int ztbz);
    int insertSelective(YhztInfo record);
}
