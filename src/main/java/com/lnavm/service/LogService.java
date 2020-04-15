package com.lnavm.service;

import com.lnavm.pojo.GlyrzInfo;
import org.springframework.stereotype.Service;

@Service
public interface LogService {
    void save(GlyrzInfo glyrzInfo);
}
