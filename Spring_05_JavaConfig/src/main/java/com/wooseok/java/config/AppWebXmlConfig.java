package com.wooseok.java.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppWebXmlConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    // <context-param>에 설정한 root-context.xml 을 초기화할 method
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    // <servlet>에 설정한 servlet-context.xml 을 초기화할 method
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ServletConfig.class, MyBatisConfig.class};

    }

    // resources mapping 에 설정한 static 폴더들에 대한 초기화할 method
    // servlet-mapping 에 설정한 url-pattern 을 초기화할 method
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}