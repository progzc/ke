package com.progzc.ke.controller;

import com.progzc.ke.common.Result;
import com.progzc.ke.constants.Category;
import com.progzc.ke.constants.RedisCacheNames;
import com.progzc.ke.entity.chart.HistogramChart;
import com.progzc.ke.entity.chart.LineChart;
import com.progzc.ke.entity.chart.Sery;
import com.progzc.ke.entity.chart.WordCloud;
import com.progzc.ke.service.CourseService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Description 课程销售信息控制器
 * @Author zhaochao
 * @Date 2021/3/17 17:54
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */
@RestController
@RequestMapping("/sys/course")
@CacheConfig(cacheNames = RedisCacheNames.COURSE)
@Slf4j
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/lineChart")
    @ApiOperation(value = "获取子模块的折线图")
    @Cacheable
    public Result lineChart(Integer id, Integer count, Integer category) {
        List<LineChart> lineChartsList = courseService.queryListByIdOfMode(id, count);
        Map<Integer, List<LineChart>> collect = lineChartsList.stream().
                collect(Collectors.groupingBy(e -> e.getCourse().getCourseId(), Collectors.toList()));
        int len = collect.size();
        String[] legend = new String[len];
        Sery[] series = new Sery[len];
        int i = 0;
        Set<Map.Entry<Integer, List<LineChart>>> entries = collect.entrySet();

        for (Map.Entry<Integer, List<LineChart>> entry : entries) {
            List<LineChart> value = entry.getValue();
            legend[i] = value.get(0).getCourseName();
            Sery sery = new Sery();
            sery.setType("line");
            sery.setName(value.get(0).getCourseName());
            Integer[] ans;
            if (Category.SELLING == category) {
                ans = value.stream().map(e -> e.getCourse().getSellingQuantity()).toArray(Integer[]::new);
            } else {
                ans = value.stream().map(e -> e.getCourse().getPageView()).toArray(Integer[]::new);
            }
            for (int j = 1; j < ans.length; j++) {
                ans[j] = ans[j - 1] + ans[j];
            }
            sery.setData(ans);
            series[i] = sery;
            i++;
        }
        return Result.ok().put("legend", legend).put("series", series);

    }

    @GetMapping("/histogramChart")
    @ApiOperation(value = "获取子模块的直方图")
    @Cacheable
    public Result histogramChart(Integer menuId, Integer count, Integer category) {
        List<HistogramChart> histogramCharts;
        if (Category.SELLING == category) {
            histogramCharts = courseService.querySellingSumByIdOfMenu(menuId, count);
        } else {
            histogramCharts = courseService.queryViewSumByIdOfMenu(menuId, count);
        }

        int len = histogramCharts.size();
        int i = 0;
        String[] xAxisHdata = new String[len];
        Long[] seriesHdata = new Long[len];
        Iterator<HistogramChart> iterator = histogramCharts.iterator();
        while (iterator.hasNext()) {
            HistogramChart next = iterator.next();
            xAxisHdata[i] = next.getXAxisHdata();
            seriesHdata[i] = next.getSeriesHdata();
            i++;
        }
        return Result.ok().put("xAxisHdata", xAxisHdata).put("seriesHdata", seriesHdata);
    }

    @GetMapping("/wordCloud")
    @ApiOperation(value = "获取全站的词云图")
    @Cacheable
    public Result wordCloud(Integer count, Integer category) {
        List<WordCloud> wordClouds;
        if (Category.SELLING == category) {
            wordClouds = courseService.querySellingSumByGroup(count);
        } else {
            wordClouds = courseService.queryViewSumByGroup(count);
        }
        return Result.ok().put("wordClouds", wordClouds);
    }
}
