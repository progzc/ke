package com.progzc.ke.entity.chart;

import com.progzc.ke.entity.Course;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description 折线图
 * @Author zhaochao
 * @Date 2021/3/22 17:33
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "LineChart对象", description = "封装折线图结果")
public class LineChart implements Serializable {
    private static final long serialVersionUID = 8584488215006330243L;
    private Integer row;
    private Course course;
    private String courseName;
}
