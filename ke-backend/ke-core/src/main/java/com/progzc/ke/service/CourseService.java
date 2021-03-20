package com.progzc.ke.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.progzc.ke.entity.Course;

import java.util.List;

/**
 * @Description Course服务接口
 * @Author zhaocho
 * @Date 2021/3/17 15:43
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */
public interface CourseService extends IService<Course> {
    List<Course> queryListByCourseId(Integer id, Integer count);

    Long querySellingSumByCourseIds(List<Integer> idList, Integer count);

    Long queryViewSumByCourseIds(List<Integer> idList, Integer count);

    Long querySellingSumByCourseId(Integer id, Integer count);

    Long queryViewSumByCourseId(Integer id, Integer count);
}
