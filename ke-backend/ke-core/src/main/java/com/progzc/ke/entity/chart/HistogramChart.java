package com.progzc.ke.entity.chart;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description 直方图
 * @Author zhaochao
 * @Date 2021/3/22 15:06
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "HistogramChart对象", description = "封装直方图结果")
public class HistogramChart implements Serializable {
    private static final long serialVersionUID = 2617477808677500664L;
    private String xAxisHdata;
    private Long seriesHdata;
}
