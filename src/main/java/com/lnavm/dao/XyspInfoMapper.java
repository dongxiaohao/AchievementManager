package com.lnavm.dao;

import com.lnavm.pojo.XyspInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface XyspInfoMapper {
    int deleteByPrimaryKey(BigDecimal xyspid);

    int insert(XyspInfo record);

    int insertSelective(XyspInfo record);

    XyspInfo selectByPrimaryKey(BigDecimal xyspid);

    int updateByPrimaryKeySelective(XyspInfo record);

    int updateByPrimaryKey(XyspInfo record);
    
    //��һ�β鿴��ѯ���صĳɼ�ʱ����sfscpdf״̬Ϊ0
    int updatePDFStatus(@Param("sfscpdf") Integer sfscpdf, @Param("yzbm") String yzbm);

    /* ʹ�����·���*/
    //������֤�����ȡ���Գɼ�
    XyspInfo selectByYZBM(@Param("yzbm") String yzbm);
    //����pdf·����ͬʱ����SFSCPDF��PDFTIME�ֶ�
    int savePDF(@Param("sfscpdf") Integer sfscpdf, @Param("pdftime") String pdftime, @Param("pdflj") String pdflj, @Param("yzbm") String yzbm);
    //��ȡpdf·��
    String getPDFLJ(@Param("yzbm") String yzbm);
    //������֤״̬Ϊ1
    int updateCheckStatus(@Param("yzzt") Integer yzzt, @Param("yzbm") String yzbm);
}