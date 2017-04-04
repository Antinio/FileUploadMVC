package com.antinio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@EnableWebMvc
@Configuration
@ComponentScan({"com.antinio"})
public class SpringWebMvcConfig extends WebMvcConfigurerAdapter {

    private int maxUploadSizeInMb = 5 * 1024 * 1024; // 5 Mb

    @Bean
    public InternalResourceViewResolver viewResolver(){

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver(){

        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(maxUploadSizeInMb * 2);
        commonsMultipartResolver.setMaxUploadSizePerFile(maxUploadSizeInMb); //bytes
        return commonsMultipartResolver;

    }

}
