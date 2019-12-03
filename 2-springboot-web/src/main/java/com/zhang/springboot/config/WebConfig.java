package com.zhang.springboot.config;

import com.zhang.springboot.interceptor.LoginInterceptor;
import com.zhang.springboot.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Zhangkj
 * @date 2019-05-04-18:24
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 添加拦截器
     * @param registry
     */
   /* @Override
    public void addInterceptors(InterceptorRegistry registry) {

        String[] pathPatterns = {
           "/**"
        };

        String[] excludePathPatterns ={

                "/boot/hello",
                "/boot/config"
        };

        registry.addInterceptor(new LoginInterceptor()).addPathPatterns(pathPatterns).excludePathPatterns(excludePathPatterns);


    }
*/



    /**
     * 注册自定义的servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean heServletRegistrationBean(){
        ServletRegistrationBean registration = new ServletRegistrationBean(new MyServlet(), "/myservlet","/Heservlet");
        return registration;
    }


   /* //注册spring提供的字符编码过滤器filter
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setForceEncoding(true);//强制编码
        characterEncodingFilter.setEncoding("UTF-8");
        registrationBean.setFilter(characterEncodingFilter);
        registrationBean.addUrlPatterns("/*");//要过滤的所有的路径
        return registrationBean;
    }*/

}
