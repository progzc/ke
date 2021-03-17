package com.progzc.basic;

import org.junit.Test;

import java.sql.Date;

/**
 * @Description java.sql.Date测试
 * @Author zhaochao
 * @Date 2021/3/17 15:25
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */
public class SqlDate {

    @Test
    public void test1() {
        long l = System.currentTimeMillis();
        Date date = new Date(l);
        System.out.println(date);
    }
}
