package com.progzc.ke.constants;

/**
 * @Description 定义Redis缓存空间
 * @Author zhaochao
 * @Date 2021/3/17 16:43
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */
public class RedisCacheNames {
    /**
     * 缓存空间统一前缀
     */
    public final static String PREFIX = "KE:";

    /**
     * 菜单缓存空间
     */
    public final static String MENU = PREFIX + "MENU";

    /**
     * 课程信息缓存空间
     */
    public final static String INFO = PREFIX + "INFO";

    /**
     * 课程销售信息缓存空间
     */
    public final static String COURSE = PREFIX + "COURSE";

}
