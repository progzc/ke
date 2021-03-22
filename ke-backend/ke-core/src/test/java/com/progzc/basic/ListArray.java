package com.progzc.basic;

import com.progzc.ke.entity.chart.WordCloud;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description List和Array打印效果测试
 * @Author zhaochao
 * @Date 2021/3/22 11:01
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */
public class ListArray {

    @Test
    public void test1() {
        WordCloud[] wordClouds = {
                new WordCloud("春夏", 10L),
                new WordCloud("秋冬", 12L)
        };
        // [WordCloud(name=春夏, value=10), WordCloud(name=秋冬, value=12)]
        System.out.println(Arrays.toString(wordClouds));
        System.out.println("----------------------------分割线------------------------------");
        List<WordCloud> list = new LinkedList<WordCloud>() {
            private static final long serialVersionUID = -812961283878373423L;

            {
                add(new WordCloud("春夏", 10L));
                add(new WordCloud("秋冬", 12L));
            }
        };
        // [WordCloud(name=春夏, value=10), WordCloud(name=秋冬, value=12)]
        System.out.println(list);
    }
}
