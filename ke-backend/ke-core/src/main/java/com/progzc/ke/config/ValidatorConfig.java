package com.progzc.ke.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 * @Description 校验配置类
 * @Author zhaochao
 * @Date 2021/3/17 16:31
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */
@Configuration
public class ValidatorConfig {

    @Bean
    public Validator validatorTemplate() {
        return Validation.buildDefaultValidatorFactory().getValidator();
    }
}
