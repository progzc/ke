package com.progzc.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description 测试Stream流的分组查询
 * @Author zhaochao
 * @Date 2021/3/22 17:05
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */
public class StreamGroup {

    @Test
    public void test1() {
        List<Foo> fooList = new ArrayList<>();
        fooList.add(new Foo("A", "san", 1.0, 2));
        fooList.add(new Foo("A", "nas", 13.0, 1));
        fooList.add(new Foo("B", "san", 112.0, 3));
        fooList.add(new Foo("C", "san", 43.0, 5));
        fooList.add(new Foo("B", "nas", 77.0, 7));
        List<List<Foo>> groupList = new ArrayList<>();
        fooList.stream().collect(Collectors.groupingBy(Foo::getName, Collectors.toList()))
                .forEach((name, fooListByName) -> {
                    groupList.add(fooListByName);
                });
        System.out.println(groupList);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = false)
    static class Foo implements Serializable {
        private static final long serialVersionUID = -863081123849006987L;
        private String name;
        private String type;
        private Double typeValue;
        private Integer count;
    }
}
