package com.progzc.ke.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.progzc.ke.entity.Course;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description Course DAO层接口
 * @Author zhaocho
 * @Date 2021/3/17 15:37
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */
@Mapper
public interface CourseMapper extends BaseMapper<Course> {
}
