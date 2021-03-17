package com.progzc.ke.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description 跨域配置
 * @Author zhaochao
 * @Date 2021/3/17 16:08
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 表示对所有发往控制器的请求都放行
        registry.addMapping("/**")
                // *表示对所有的地址都可以访问
                .allowedOrigins("*")
                // 可以携带cookie，最终的结果是可以 在跨域请求的时候获取同一个session
                .allowCredentials(true)
                // 允许提交GET/POST/PUT/DELETE/OPTIONS请求
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                // 准备响应前的缓存持续的最大时间为3600s
                .maxAge(3600);
    }
}
