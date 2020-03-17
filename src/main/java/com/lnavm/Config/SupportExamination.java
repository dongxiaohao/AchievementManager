package com.lnavm.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统支持的考试类型配置
 */
@Component()
@ConfigurationProperties(prefix = "supportExamination")
public class SupportExamination {
    private int defaultStartYear;
    private String defaultPdfTemplate;
    private List<Examination> examinations ;

    public SupportExamination() {
        this.examinations = new ArrayList<>();
    }

    public SupportExamination(List<Examination> examinations) {
        this.examinations = examinations;
    }

    public String getDefaultPdfTemplate() {
        return defaultPdfTemplate;
    }

    public void setDefaultPdfTemplate(String defaultPdfTemplate) {
        this.defaultPdfTemplate = defaultPdfTemplate;
    }

    public List<Examination> getExaminations() {
        return examinations;
    }

    public void setExaminations(List<Examination> examinations) {
        this.examinations = examinations;
    }

    public int getDefaultStartYear() {
        return defaultStartYear;
    }

    public void setDefaultStartYear(int defaultStartYear) {
        this.defaultStartYear = defaultStartYear;
    }
}
