package com.lnavm.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component()
@ConfigurationProperties(prefix = "examinationToCode")
public class ExaminationToCode {
    HashMap<String,String> codeMap;
    HashMap<String,String> examinationMap;

    public HashMap<String, String> getCodeMap() {
        return codeMap;
    }

    public void setCodeMap(HashMap<String, String> codeMap) {
        this.codeMap = codeMap;
    }

    public HashMap<String, String> getExaminationMap() {
        return examinationMap;
    }

    public void setExaminationMap(HashMap<String, String> examinationMap) {
        this.examinationMap = examinationMap;
    }
}
