package com.lnavm.dao;

import com.lnavm.pojo.SjsfzglInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface SjsfzglInfoMapper {
    int deleteByPrimaryKey(BigDecimal glid);

    int insert(SjsfzglInfo sjsfzglInfo);

    int insertSelective(SjsfzglInfo record);

    SjsfzglInfo selectByPrimaryKey(@Param("glid") BigDecimal glid);

    BigDecimal queryGLIDBySfzh(@Param("sfzh") String sfzh, @Param("sjh") String sjh);

    int updateByPrimaryKeySelective(SjsfzglInfo record);

    int updateByPrimaryKey(SjsfzglInfo record);


    //List<SjsfzglInfo> queryBySjh(@Param("sjh") String sjh, Page<DlrzInfo> page);
    List<SjsfzglInfo> queryBySjh(@Param("sjh") String sjh);

    //List<String> querySFZHBySjh(@Param("sjh") String sjh, Page<DlrzInfo> page);
    List<String> querySFZHBySjh(@Param("sjh") String sjh);

    int deleteBySJHAndSFZH(@Param("sjh") String sjh, @Param("sfzh") String sfzh);
}