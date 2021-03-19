package com.progzc.ke.entity.chart;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description Sery实体类
 * @Author zhaochao
 * @Date 2021/3/19 19:23
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Sery对象", description = "封装折线图结果")
public class Sery implements Serializable {

    private static final long serialVersionUID = -6089738342207009937L;

    private String name;
    private String type;
    private Integer[] data;
}
