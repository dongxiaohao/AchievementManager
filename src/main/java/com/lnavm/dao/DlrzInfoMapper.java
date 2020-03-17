package com.lnavm.dao;

import com.lnavm.pojo.DlrzInfo;
import com.lnavm.thirdutils.Page;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface DlrzInfoMapper {
    int deleteByPrimaryKey(BigDecimal dlrzid);

    int insert(DlrzInfo record);

    int insertSelective(DlrzInfo record);

    DlrzInfo selectByPrimaryKey(BigDecimal dlrzid);

    int updateByPrimaryKeySelective(DlrzInfo record);

    int updateByPrimaryKey(DlrzInfo record);
    
    /**
     * ��ѯָ���ֻ��ŵĵ�¼���
     * @param sjh    �ֻ���
     * @param page   ��ҳ���ݣ�mapper�в��ÿ��ǣ�ͨ������������
     * @return       �뵱ǰ�ֻ��Ű󶨵ĵ�¼��־�б�
     */
    List<DlrzInfo> queryBySjh(@Param("sjh") String sjh, Page<DlrzInfo> page);
}