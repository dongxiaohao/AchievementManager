package com.lnavm.service.Impl;

import com.lnavm.Config.ExaminationToCode;
import com.lnavm.dao.*;
import com.lnavm.entity.Grades;
import com.lnavm.pojo.*;
import com.lnavm.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    ExaminationToCode examinationToCode;

    @Autowired
    private CrgkInfoMapper crgkInfoMapper;
    @Autowired
    private DksxInfoMapper dksxInfoMapper;
    @Autowired
    private GkInfoMapper gkInfoMapper;
    @Autowired
    private XyspInfoMapper xyspInfoMapper;
    @Autowired
    private ZkkscjInfoMapper zkkscjInfoMapper;
    @Autowired
    private ZkbysInfoMapper zkbysInfoMapper;

    @Override
    public Grades getGrade(String yzbm, String kslx) {
        Grades grades=new Grades();

        switch (kslx){
            case "11":
                GkInfo gkInfo=gkInfoMapper.selectByYZBM(yzbm);
                grades.setScores(gkInfo.getScore());
                break;
            case "13":
                CrgkInfo crgkInfo=crgkInfoMapper.selectByYZBM(yzbm);
                grades.setScores(crgkInfo.getScore());
                break;
            case"14":
                ZkbysInfo zkbysInfo=zkbysInfoMapper.selectByYZBM(yzbm);
                grades.addOtherMessage("zydm", zkbysInfo.getZydm());
                grades.addOtherMessage("zymc", zkbysInfo.getZymc());
                grades.addOtherMessage("zid", zkbysInfo.getZid());
                grades.addOtherMessage("zkyx", zkbysInfo.getZkyx());
                grades.addOtherMessage("zycc", zkbysInfo.getZycc());
                grades.addOtherMessage("bysj", zkbysInfo.getBysj());
                break;
            case"18":
                ZkkscjInfo zkkscjInfo=zkkscjInfoMapper.selectByYZBM(yzbm);
                grades.setScores(zkkscjInfo.getScore());
                break;
            case "15":
                XyspInfo xyspInfo=xyspInfoMapper.selectByYZBM(yzbm);
                grades.setScores(xyspInfo.getScore());
                break;
            case "16":
                DksxInfo dksxInfo=dksxInfoMapper.selectByYZBM(yzbm);
                grades.setScores(dksxInfo.getScore());
                break;
        }
//        if (kslx.equals("11")) {
//            GkInfo gkInfo=gkInfoMapper.selectByYZBM(yzbm);
//            grades.setScores(gkInfo.getScore());
//        }else  if (kslx.equals("13")) {
//            CrgkInfo crgkInfo=crgkInfoMapper.selectByYZBM(yzbm);
//            grades.setScores(crgkInfo.getScore());
//        }else if (kslx.equals("14")) {
//            ZkbysInfo zkbysInfo=zkbysInfoMapper.selectByYZBM(yzbm);
//
//        }else if (kslx.equals("18")) {
//            ZkkscjInfo zkkscjInfo=zkkscjInfoMapper.selectByYZBM(yzbm);
//            grades.setScores(zkkscjInfo.getScore());
//        }else if (kslx.equals("15")) {
//            XyspInfo xyspInfo=xyspInfoMapper.selectByYZBM(yzbm);
//            grades.setScores(xyspInfo.getScore());
//        }else if (kslx.equals("16")) {
//            DksxInfo dksxInfo=dksxInfoMapper.selectByYZBM(yzbm);
//            grades.setScores(dksxInfo.getScore());
//        }
       // System.out.println(grades.getScoresMap().size());
        return grades;
    }
}
