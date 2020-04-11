package com.lnavm.Config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lnavm.intercept.LoginIntercept;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.MultipartConfigElement;
import java.nio.charset.Charset;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan
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
                  "/**",
//                "/lib/**",
//                "/static/**",
//                "/temp/**",
        };

        String[] resourceLocation = {
                "classpath:/static/",
//                "classpath:/static/lib/",
//                "classpath:/static/static/",
//                "classpath:/static/temp/",
        };
        registry.addResourceHandler(resource).addResourceLocations(resourceLocation);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //不拦截的url
        String[] exclude = {
                "/login/**",
                "/signOut",
                "/lib/**",
                "/static/**",
                "/temp/**",
                "/admin/isSignin",
        };
        //添加登录拦截器
        registry.addInterceptor(new LoginIntercept()).addPathPatterns("/**").excludePathPatterns(exclude);
    }

    @Bean
    public HttpMessageConverter<String> responseBodyConverter(){
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return converter;
    }
    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }
    @Bean
    public MappingJackson2HttpMessageConverter messageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(getObjectMapper());
        return converter;
    }
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        //解决中文乱码
        converters.add(responseBodyConverter());
        //解决 添加解决中文乱码后 上述配置之后，返回json数据直接报错 500：no convertter for return value of type
        converters.add(messageConverter());
    }
}
