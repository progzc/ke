package com.progzc.ke.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.progzc.ke.entity.Course;
import com.progzc.ke.mapper.CourseMapper;
import com.progzc.ke.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description Course服务实现类
 * @Author zhaochao
 * @Date 2021/3/17 15:49
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */
@Service
@Slf4j
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Resource
    private CourseMapper courseMapper;

    @Override
    public List<Course> queryListByCourseId(Integer id, Integer count) {
        return courseMapper.queryListByCourseId(id, count);

    }

    @Override
    public Long querySellingSumByCourseIds(List<Integer> idList, Integer count) {
        return courseMapper.querySellingSumByCourseIds(idList, count);
    }

    @Override
    public Long queryViewSumByCourseIds(List<Integer> idList, Integer count) {
        return courseMapper.queryViewSumByCourseIds(idList, count);
    }
}
