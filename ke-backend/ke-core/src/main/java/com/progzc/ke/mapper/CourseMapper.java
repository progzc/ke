package com.progzc.ke.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.progzc.ke.entity.Course;
import com.progzc.ke.entity.chart.HistogramChart;
import com.progzc.ke.entity.chart.LineChart;
import com.progzc.ke.entity.chart.WordCloud;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description Course DAO层接口
 * @Author zhaocho
 * @Date 2021/3/17 15:37
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */
@Mapper
public interface CourseMapper extends BaseMapper<Course> {

    List<LineChart> queryListByIdOfMode(Integer id, Integer count);

    List<HistogramChart> querySellingSumByIdOfMenu(Integer menuId, Integer count);

    List<WordCloud> querySellingSumByGroup(Integer count);

    List<WordCloud> queryViewSumByGroup(Integer count);

    List<HistogramChart> queryViewSumByIdOfMenu(Integer menuId, Integer count);
}
