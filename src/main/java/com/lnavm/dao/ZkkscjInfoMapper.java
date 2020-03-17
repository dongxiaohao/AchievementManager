package com.lnavm.dao;

import com.lnavm.pojo.ZkkscjInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface ZkkscjInfoMapper {
    int deleteByPrimaryKey(BigDecimal zkcjid);

    int insert(ZkkscjInfo record);

    int insertSelective(ZkkscjInfo record);

    ZkkscjInfo selectByPrimaryKey(BigDecimal zkcjid);

    int updateByPrimaryKeySelective(ZkkscjInfo record);

    int updateByPrimaryKey(ZkkscjInfo record);
    
    //��һ�β鿴��ѯ���صĳɼ�ʱ����sfscpdf״̬Ϊ0
    int updatePDFStatus(@Param("sfscpdf") Integer sfscpdf, @Param("yzbm") String yzbm);

    /* ʹ�����·���*/
    //������֤�����ȡ���Գɼ�
    ZkkscjInfo selectByYZBM(@Param("yzbm") String yzbm);
    //����pdf·����ͬʱ����SFSCPDF��PDFTIME�ֶ�
    int savePDF(@Param("sfscpdf") Integer sfscpdf, @Param("pdftime") String pdftime, @Param("pdflj") String pdflj, @Param("yzbm") String yzbm);
    //��ȡpdf·��
    String getPDFLJ(@Param("yzbm") String yzbm);
    //������֤״̬Ϊ1
    int updateCheckStatus(@Param("yzzt") Integer yzzt, @Param("yzbm") String yzbm);
}