package com.progzc.ke.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.progzc.ke.entity.Course;
import com.progzc.ke.entity.chart.HistogramChart;
import com.progzc.ke.entity.chart.LineChart;
import com.progzc.ke.entity.chart.WordCloud;
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
    public List<LineChart> queryListByIdOfMode(Integer id, Integer count) {
        return courseMapper.queryListByIdOfMode(id, count);
    }

    @Override
    public List<HistogramChart> querySellingSumByIdOfMenu(Integer menuId, Integer count) {
        return courseMapper.querySellingSumByIdOfMenu(menuId, count);
    }

    @Override
    public List<HistogramChart> queryViewSumByIdOfMenu(Integer menuId, Integer count) {
        return courseMapper.queryViewSumByIdOfMenu(menuId, count);
    }


    @Override
    public List<WordCloud> querySellingSumByGroup(Integer count) {
        return courseMapper.querySellingSumByGroup(count);
    }

    @Override
    public List<WordCloud> queryViewSumByGroup(Integer count) {
        return courseMapper.queryViewSumByGroup(count);
    }
}
