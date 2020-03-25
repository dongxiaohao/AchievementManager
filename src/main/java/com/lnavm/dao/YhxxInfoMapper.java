package com.lnavm.dao;

import com.lnavm.pojo.YhrecordInfo;
import com.lnavm.pojo.YhxxInfo;
import com.lnavm.thirdutils.Page;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface YhxxInfoMapper {
    int deleteByPrimaryKey(BigDecimal yhid);

    int insert(YhxxInfo record);

    int insertSelective(YhxxInfo record);

    YhxxInfo selectByPrimaryKey(BigDecimal yhid);

    int updateByPrimaryKeySelective(YhxxInfo record);

    int updateByPrimaryKey(YhxxInfo record);
    
    YhxxInfo selectBySJH(@Param("sjh") String sjh);

    String selectMMBySJH(@Param("sjh") String sjh);

    YhxxInfo selectByYHM(@Param("yhm") String yhm);

    String selectMMByYHM(@Param("yhm") String yhm);

    String selectMMBySFZH(@Param("sfzh") String sfzh);

    String selectMMByYX(@Param("yx") String yx);

    YhxxInfo selectBySFZH(@Param("sfzh") String sfzh);

    YhxxInfo selectByYX(@Param("yx") String yx);

    String selectSJHbySFZH(@Param("sfzh") String sfzh);

    String selectSJHbyYX(@Param("yx") String yx);

    String selectSJHbyYHM(@Param("yhm") String yhm);

    List<YhrecordInfo> selectAll(Page<YhxxInfo> page);

    List<YhrecordInfo> selectUserBysjh(Page<YhrecordInfo> page,@Param("sjh") String sjh, @Param("sfzh") String sfzh);

    int updateSJHbyYHID(@Param("yhid") String yhid, @Param("sjh") String sjh);
}