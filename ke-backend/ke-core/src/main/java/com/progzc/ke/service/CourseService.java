package com.progzc.ke.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.progzc.ke.entity.Course;
import com.progzc.ke.entity.chart.HistogramChart;
import com.progzc.ke.entity.chart.LineChart;
import com.progzc.ke.entity.chart.WordCloud;

import java.util.List;

/**
 * @Description Course服务接口
 * @Author zhaocho
 * @Date 2021/3/17 15:43
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */
public interface CourseService extends IService<Course> {

    List<LineChart> queryListByIdOfMode(Integer id, Integer count);

    List<HistogramChart> querySellingSumByIdOfMenu(Integer menuId, Integer count);

    List<HistogramChart> queryViewSumByIdOfMenu(Integer menuId, Integer count);

    List<WordCloud> querySellingSumByGroup(Integer count);

    List<WordCloud> queryViewSumByGroup(Integer count);
}
