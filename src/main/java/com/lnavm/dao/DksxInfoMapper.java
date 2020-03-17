package com.lnavm.dao;

import com.lnavm.pojo.DksxInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface DksxInfoMapper {
    int deleteByPrimaryKey(BigDecimal dksxid);

    int insert(DksxInfo record);

    int insertSelective(DksxInfo record);

    DksxInfo selectByPrimaryKey(BigDecimal dksxid);

    int updateByPrimaryKeySelective(DksxInfo record);

    int updateByPrimaryKey(DksxInfo record);
    
    //��һ�β鿴��ѯ���صĳɼ�ʱ����sfscpdf״̬Ϊ0
    int updatePDFStatus(@Param("sfscpdf") Integer sfscpdf, @Param("yzbm") String yzbm);

    /* ʹ�����·���*/
    //������֤�����ȡ���Գɼ�
    DksxInfo selectByYZBM(@Param("yzbm") String yzbm);
    //����pdf·����ͬʱ����SFSCPDF��PDFTIME�ֶ�
    int savePDF(@Param("sfscpdf") Integer sfscpdf, @Param("pdftime") String pdftime, @Param("pdflj") String pdflj, @Param("yzbm") String yzbm);
    //��ȡpdf·��
    String getPDFLJ(@Param("yzbm") String yzbm);
    //������֤״̬Ϊ1
    int updateCheckStatus(@Param("yzzt") Integer yzzt, @Param("yzbm") String yzbm);
}