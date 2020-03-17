package com.lnavm.dao;

import com.lnavm.pojo.ZkbysInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface ZkbysInfoMapper {
    int deleteByPrimaryKey(BigDecimal zkbybid);

    int insert(ZkbysInfo record);

    int insertSelective(ZkbysInfo record);

    ZkbysInfo selectByPrimaryKey(BigDecimal zkbybid);

    int updateByPrimaryKeySelective(ZkbysInfo record);

    int updateByPrimaryKey(ZkbysInfo record);
    
    //��һ�β鿴��ѯ���صĳɼ�ʱ����sfscpdf״̬Ϊ0
    int updatePDFStatus(@Param("sfscpdf") Integer sfscpdf, @Param("yzbm") String yzbm);

    /* ʹ�����·���*/
    //������֤�����ȡ���Գɼ�
    ZkbysInfo selectByYZBM(@Param("yzbm") String yzbm);
    //����pdf·����ͬʱ����SFSCPDF��PDFTIME�ֶ�
    int savePDF(@Param("sfscpdf") Integer sfscpdf, @Param("pdftime") String pdftime, @Param("pdflj") String pdflj, @Param("yzbm") String yzbm);
    //��ȡpdf·��
    String getPDFLJ(@Param("yzbm") String yzbm);
    //������֤״̬Ϊ1
    int updateCheckStatus(@Param("yzzt") Integer yzzt, @Param("yzbm") String yzbm);
}