package com.lnavm.dao;

import com.lnavm.pojo.CrgkInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface CrgkInfoMapper {
    int deleteByPrimaryKey(BigDecimal crgkid);

    int insert(CrgkInfo record);

    int insertSelective(CrgkInfo record);

    CrgkInfo selectByPrimaryKey(BigDecimal crgkid);

    int updateByPrimaryKeySelective(CrgkInfo record);

    int updateByPrimaryKey(CrgkInfo record);
    
    /* ʹ�����·���*/
    //������֤�����ȡ���Գɼ�
    CrgkInfo selectByYZBM(@Param("yzbm") String yzbm);
    //����pdf·����ͬʱ����SFSCPDF��PDFTIME�ֶ�
    int savePDF(@Param("sfscpdf") Integer sfscpdf, @Param("pdftime") String pdftime, @Param("pdflj") String pdflj, @Param("yzbm") String yzbm);
    //��ȡpdf·��
    String getPDFLJ(@Param("yzbm") String yzbm);
    //������֤״̬Ϊ1
    int updateCheckStatus(@Param("yzzt") Integer yzzt, @Param("yzbm") String yzbm);
}