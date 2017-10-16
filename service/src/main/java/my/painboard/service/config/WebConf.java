package my.painboard.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"my.painboard.service.controller", "my.painboard.service.filesystem"})
public class WebConf extends WebMvcConfigurerAdapter {
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {"classpath:/static/"};

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }

//    @Bean
//    public StringHttpMessageConverter stringHttpMessageConverter(){
//        return new StringHttpMessageConverter();
//    }
//
//    @Bean
//    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
//        return new MappingJackson2HttpMessageConverter();
//    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/index.html");
    }

//    @Bean
//    public DispatcherServlet dispatcherServlet() {
//        return new DispatcherServlet();
//    }

//    @Bean
//    public MultipartConfigElement multipartConfigElement(@Value("${upload.max_archive_size}") long maxUploadSize) {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        factory.setMaxRequestSize(maxUploadSize);
//        factory.setMaxFileSize(maxUploadSize);
//        return factory.createMultipartConfig();
//    }

//    @Bean
//    public ServletRegistrationBean dispatcherServletRegistration() {
//        ServletRegistrationBean servletBean = new ServletRegistrationBean();
//        servletBean.addUrlMappings("/*");
////        servletBean.setMultipartConfig(multipartConfig);
//        servletBean.setLoadOnStartup(1);
//        servletBean.setServlet(dispatcherServlet());
//        return servletBean;
//
//    }
}
