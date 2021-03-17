package com.progzc.ke.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description MyBatisPlus配置
 * @Author zhaochao
 * @Date 2021/3/17 16:14
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.progzc.ke.mapper")
public class MyBatisPlusConfig {
}
