package org.com.hrq.config;

import org.com.hrq.Interceptor.SecurityInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.*;

/**
 * <pre>
 *     拦截器，资源路径配置
 * </pre>
 *
 * @author : menoly
 * @date : 2019/2/15 下午5:08
 */
@Slf4j
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.com.hrq.controller")
@PropertySource(value = "classpath:application.yaml", ignoreResourceNotFound = true, encoding = "UTF-8")
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    SecurityInterceptor securityInterceptor() {
        return new SecurityInterceptor();
    }

//    /**
//     * 配置静态资源路径
//     *
//     * @param registry registry
//     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/templates/home/")
//                .addResourceLocations("classpath:/robots.txt");
//        registry.addResourceHandler("/upload/**")
//                .addResourceLocations("file:///" + System.getProperties().getProperty("user.home") + "/sens/upload/");
//        registry.addResourceHandler("/favicon.ico")
//                .addResourceLocations("classpath:/static/images/favicon.ico");
//        registry.addResourceHandler("/backup/**")
//                .addResourceLocations("file:///" + System.getProperties().getProperty("user.home") + "/sens/backup/");
//    }
//

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截器按照顺序执行
        registry.addInterceptor(securityInterceptor())
                .addPathPatterns("/api/message/**" , "/api/server1/**")
                .excludePathPatterns("/api/user/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("*");
    }

}
