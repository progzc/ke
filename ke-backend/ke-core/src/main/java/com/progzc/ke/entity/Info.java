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

/**
 * @Description 信息表
 * @Author zhaochao
 * @Date 2021/3/17 15:05
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Info对象", description = "课程信息")
public class Info implements Serializable {

    private static final long serialVersionUID = 4604281656118592126L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    @Id
    private Integer id;

    @ApiModelProperty(value = "菜单id")
    private Integer menuId;

    @ApiModelProperty(value = "课程名称")
    private String courseName;

    @ApiModelProperty(value = "授课老师姓名")
    private String teacherName;

    @ApiModelProperty(value = "售价")
    private Integer sale;
}
