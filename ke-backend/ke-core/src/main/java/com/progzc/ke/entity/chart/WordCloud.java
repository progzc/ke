package com.progzc.ke.entity.chart;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description 词云
 * @Author zhaochao
 * @Date 2021/3/20 9:13
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "WordCloud对象", description = "封装词云结果")
public class WordCloud implements Serializable {
    private static final long serialVersionUID = -247629682917624014L;

    private String name;
    private Long value;
}
