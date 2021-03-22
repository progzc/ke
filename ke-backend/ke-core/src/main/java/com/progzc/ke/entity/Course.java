package com.progzc.ke.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.sql.Date;

/**
 * @Description 课程销售情况表
 * @Author zhaochao
 * @Date 2021/3/17 15:13
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Course对象", description = "课程销售情况表")
public class Course implements Serializable {

    private static final long serialVersionUID = -1864643611634880458L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    @Id
    private Integer id;

    @ApiModelProperty(value = "课程id")
    private Integer courseId;

    @ApiModelProperty(value = "浏览数")
    private Integer pageView;

    @ApiModelProperty(value = "出售的数量")
    private Integer sellingQuantity;

    @ApiModelProperty(value = "日期")
    private Date logDate;

}
