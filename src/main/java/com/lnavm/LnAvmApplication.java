package com.lnavm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.lnavm.**.dao")
public class LnAvmApplication extends SpringBootServletInitializer {
    public static void main(String[] args){
        SpringApplication.run(LnAvmApplication.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }

//    @Scheduled(fixedRate = 2000)
//    public void fixedRate() {
//        System.out.println("fixedRate>>>"+new Date());
//    }
//    @Scheduled(fixedDelay = 2000)
//    public void fixedDelay() {
//        System.out.println("fixedDelay>>>"+new Date());
//    }
//    @Scheduled(initialDelay = 2000,fixedDelay = 2000)
//    public void initialDelay() {
//        System.out.println("initialDelay>>>"+new Date());
//    }
}
