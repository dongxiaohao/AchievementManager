package com.lnavm.service;

import com.lnavm.entity.Grades;
import org.springframework.stereotype.Service;

@Service
public interface GradeService {
    Grades getGrade(String yzbm,String kslx);
}
