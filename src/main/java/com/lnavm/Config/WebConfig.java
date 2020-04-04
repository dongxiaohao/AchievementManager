package com.lnavm.Config;

import com.lnavm.intercept.LoginIntercept;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.MultipartConfigElement;

//@Configuration
//@EnableWebMvc
//@ComponentScan
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * 配置上传文件大小的配置
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  单个数据大小
        factory.setMaxFileSize("102400KB");
        /// 总上传数据大小
        factory.setMaxRequestSize("102400KB");
        return factory.createMultipartConfig();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置静态资源
        String[] resource = {
                "/lib/**",
                "/static/**",
                "/temp/**",
        };

        String[] resourceLocation = {
                "classpath:/static/lib/",
                "classpath:/static/static/",
                "classpath:/static/temp/",
        };
        registry.addResourceHandler(resource).addResourceLocations(resourceLocation);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //不拦截的url
        String[] exclude = {
                "/errorPage",
                "/login/**",
                "/signOut",
                "/lib/**",
                "/static/**",
                "/temp/**",
        };
        //添加登录拦截器
        registry.addInterceptor(new LoginIntercept()).excludePathPatterns(exclude);
    }
}
