package com.progzc.ke.config;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description Swagger配置
 * @Author zhaochao
 * @Date 2021/3/17 16:16
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */
@Slf4j
@Configuration
// 启用Swagger
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
    /**
     * 加载Swagger的默认UI界面
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * 配置Swagger的Docket的Bean实例：
     * 每一个Docket的Bean实例对应于一个分组，这样可以方便协同开发
     * @param environment
     * @return
     */
    @Bean
    public Docket restApiGroup1(Environment environment) {
        // 设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev", "test");
        // 获取项目的环境
        boolean isDevAndTest = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // 是否启动Swagger，若为false，则Swagger不能在浏览器中访问
                // 可以控制Swagger在开发及测试环境中使用，在生产环境不使用
                .enable(isDevAndTest)
                .select()
                // 配置要扫描接口的方式
                // RequestHandlerSelectors.basePackage("包名")：扫描指定的包
                // RequestHandlerSelectors.any()：扫描全部
                // RequestHandlerSelectors.none()：不扫描
                // RequestHandlerSelectors.withMethodAnnotation(注解.class)：扫描方法上的注解
                // RequestHandlerSelectors.withClassAnnotation(注解.class)：扫描类上的注解
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 过滤映射路径
                // PathSelectors.any()：放行所有路径
                // PathSelectors.ant("/article")：只放行/article路径
                .paths(PathSelectors.any())
                .build()
                .groupName("Ke");
    }

    /**
     * 配置网站相关信息
     * @return
     */
    private ApiInfo apiInfo() {
        // 作者信息
        Contact contact = new Contact("Ke", "https://ke.qq.com/", "zcprog@foxmail.com");
        return new ApiInfoBuilder()
                .title("Monitor System for Ke of qq.")
                .description("腾讯课堂的监控系统")
                .termsOfServiceUrl("https://ke.qq.com/")
                .version("v1.0")
                .contact(contact)
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
}
