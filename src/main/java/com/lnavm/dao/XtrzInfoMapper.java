package com.lnavm.dao;

import com.lnavm.pojo.XtrzInfo;
import com.lnavm.thirdutils.Page;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface XtrzInfoMapper {
    int deleteByPrimaryKey(BigDecimal rzid);

    int insert(XtrzInfo record);

    int insertSelective(XtrzInfo record);

    XtrzInfo selectByPrimaryKey(BigDecimal rzid);

    int updateByPrimaryKeySelective(XtrzInfo record);

    int updateByPrimaryKey(XtrzInfo record);
    
    /**
     * ��ѯָ���ֻ��ŵĲ�����־
     * @param yhsjh   �û��ֻ���
     * @param page   ��ҳ���ݣ�mapper�в��ÿ��ǣ�ͨ������������
     * @return       ���ֻ��Ű󶨵���־�б�
     */
    List<XtrzInfo> queryByYhsjh(@Param("yhsjh") String yhsjh, Page<XtrzInfo> page);
    List<XtrzInfo> queryByKslx(@Param("kslx") String kslx,String starttime,String endtime,String order,String yhsjh,Page<XtrzInfo> page);
}