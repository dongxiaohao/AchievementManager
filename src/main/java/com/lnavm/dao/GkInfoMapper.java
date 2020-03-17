package com.lnavm.dao;

import com.lnavm.pojo.GkInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface GkInfoMapper {
    int deleteByPrimaryKey(BigDecimal gkcjid);

    int insert(GkInfo record);

    int insertSelective(GkInfo record);

    GkInfo selectByPrimaryKey(BigDecimal gkcjid);

    int updateByPrimaryKeySelective(GkInfo record);

    int updateByPrimaryKey(GkInfo record);
    
    //��һ�β鿴��ѯ���صĳɼ�ʱ����sfscpdf״̬Ϊ0
    int updatePDFStatus(@Param("sfscpdf") Integer sfscpdf, @Param("yzbm") String yzbm);

    /* ʹ�����·���*/
    //������֤�����ȡ���Գɼ�
    GkInfo selectByYZBM(@Param("yzbm") String yzbm);
    //����pdf·����ͬʱ����SFSCPDF��PDFTIME�ֶ�
    int savePDF(@Param("sfscpdf") Integer sfscpdf, @Param("pdftime") String pdftime, @Param("pdflj") String pdflj, @Param("yzbm") String yzbm);
    //��ȡpdf·��
    String getPDFLJ(@Param("yzbm") String yzbm);
    //������֤״̬Ϊ1
    int updateCheckStatus(@Param("yzzt") Integer yzzt, @Param("yzbm") String yzbm);
}