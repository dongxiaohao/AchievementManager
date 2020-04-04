package com.lnavm.dao;

import com.lnavm.pojo.CxRecord;
import com.lnavm.pojo.CxbInfo;
import com.lnavm.pojo.XtrzInfo;
import com.lnavm.thirdutils.Page;
import org.apache.ibatis.annotations.Param;

import javax.annotation.security.PermitAll;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public interface CxbInfoMapper {
    int deleteByPrimaryKey(BigDecimal cxid);

    int insert(CxbInfo record);

    int insertSelective(CxbInfo record);

    CxbInfo selectByPrimaryKey(BigDecimal cxid);

    int updateByPrimaryKeySelective(CxbInfo record);

    int updateByPrimaryKey(CxbInfo record);
    
    /**
     * ��ѯָ���ֻ��ŵĲ�ѯ��¼
     * @param sjh       �ֻ���
     * @param page   ��ҳ���ݣ�mapper�в��ÿ��ǣ�ͨ������������
     * @return          ָ���ֻ��ŵĲ�ѯ��¼�б�
     */
    List<CxbInfo> queryBySjh(@Param("sjh") String sjh, Page<CxbInfo> page);


    int setYHStatus(@Param("yhsfck") Integer yhsfck, @Param("yhcksj") String yhcksj, @Param("cxid") BigDecimal cxid);

    /**
     * 基于cxbinfo实体中的考试类型、姓名、身份证号、考试年份、考试年内标识进行查询，判断记录是否在里面
     * @param cxbInfo     查询表信息
     * @return            数据库中的结果
     */
    List<CxbInfo> selectCondition(@Param("cxbInfo") CxbInfo cxbInfo);

    List<CxbInfo> queryBySjhWithOldResult(@Param("sjh") String sjh, Page<CxbInfo> page);

    List<CxbInfo> queryBySjhWithNewResult(@Param("sjh") String sjh, Page<CxbInfo> page);

    List<CxbInfo> queryBySjhWithQuerying(@Param("sjh") String sjh, Page<CxbInfo> page);

    List<CxbInfo> queryBySjhWithNoResult(@Param("sjh") String sjh, Page<CxbInfo> page);
    List<CxRecord> queryByKslx(@Param("kslx") String kslx, @Param("starttime") String starttime, @Param("endtime") String endtime, @Param("order") String order, @Param("sjh") String sjh, Page<CxRecord> page);
//    List<CxRecord> queryByKslx(@Param("kslx") String kslx, @Param("starttime") Timestamp starttime, @Param("endtime") Timestamp endtime, @Param("order") String order, @Param("sjh") String sjh, Page<CxRecord> page);
    List<CxRecord> queryByAll( @Param("order") String order, Page<CxRecord> page);
    Integer countByKslx(@Param("kslx") String kslx, @Param("starttime") String starttime, @Param("endtime") String endtime, @Param("sjh") String sjh);
    Integer countAll();

    int statisticByKslx(@Param("kslx") String kslx, @Param("starttime") String starttime, @Param("endtime") String endtime);
}