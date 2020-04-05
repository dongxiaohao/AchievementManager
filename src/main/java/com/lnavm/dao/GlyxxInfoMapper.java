package com.lnavm.dao;

import com.lnavm.pojo.GlyxxInfo;
import com.lnavm.thirdutils.Page;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface GlyxxInfoMapper {
    int deleteByPrimaryKey(BigDecimal glyid);

    int insert(GlyxxInfo record);

    int insertSelective(GlyxxInfo record);

    GlyxxInfo selectByPrimaryKey(BigDecimal glyid);

    int updateByPrimaryKeySelective(GlyxxInfo record);

    int updateByPrimaryKey(GlyxxInfo record);

    String selectPASSByGLYM(@Param("selectPASSByGLYM") String glyzh);

    GlyxxInfo selectByGLYM(@Param("glyzh") String glyzh);

    List<GlyxxInfo> selectAll(Page<GlyxxInfo> page);
    int updateBMByGlyid(@Param("glyid") String glyid,@Param("bm") String bm);
}