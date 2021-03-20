package com.progzc.ke.controller;

import com.progzc.ke.common.Result;
import com.progzc.ke.constants.Category;
import com.progzc.ke.constants.RedisCacheNames;
import com.progzc.ke.entity.Course;
import com.progzc.ke.entity.Info;
import com.progzc.ke.entity.Menu;
import com.progzc.ke.entity.chart.Sery;
import com.progzc.ke.entity.chart.WordCloud;
import com.progzc.ke.service.CourseService;
import com.progzc.ke.service.InfoService;
import com.progzc.ke.service.MenuService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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
    private MenuService menuService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private InfoService infoService;

    @GetMapping("/lineChart")
    @ApiOperation(value = "获取子模块的折线图")
    @Cacheable
    public Result lineChart(Integer id, Integer count, Integer category) {
        List<Info> infos = infoService.queryListByMenuId(id);
        Iterator<Info> iterator = infos.iterator();
        String[] legend = new String[infos.size()];
        Sery[] series = new Sery[infos.size()];
        int i = 0;
        while (iterator.hasNext()) {
            Info next = iterator.next();
            legend[i] = next.getCourseName();
            Sery sery = new Sery();
            sery.setName(next.getCourseName());
            sery.setType("line");
            List<Course> courses = courseService.queryListByCourseId(next.getId(), count);
            Integer[] ans;
            if (Category.SELLING == category) {
                ans = courses.stream().map(Course::getSellingQuantity).toArray(Integer[]::new);
            } else {
                ans = courses.stream().map(Course::getPageView).toArray(Integer[]::new);
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
        List<Menu> ids = menuService.getModuleById(menuId);
        Iterator<Menu> iterator = ids.iterator();
        String[] xAxisHdata = new String[ids.size()];
        Long[] seriesHdata = new Long[ids.size()];
        int i = 0;
        while (iterator.hasNext()) {
            Menu next = iterator.next();
            xAxisHdata[i] = next.getName();
            List<Integer> idList = infoService.queryIdListByMenuId(next.getId());
            if (Category.SELLING == category) {
                seriesHdata[i] = courseService.querySellingSumByCourseIds(idList, count * ids.size());
            } else {
                seriesHdata[i] = courseService.queryViewSumByCourseIds(idList, count * ids.size());
            }
            i++;
        }
        System.out.println(Arrays.toString(seriesHdata));
        return Result.ok().put("xAxisHdata", xAxisHdata).put("seriesHdata", seriesHdata);
    }

    @GetMapping("/wordCloud")
    @ApiOperation(value = "获取全站的词云图")
    @Cacheable
    public Result wordCloud(Integer count, Integer category) {
        List<Info> infos = infoService.queryIds();
        int size = infos.size();
        WordCloud[] wordClouds = new WordCloud[size];
        int i = 0;
        Iterator<Info> iterator = infos.iterator();
        while (iterator.hasNext()) {
            Info next = iterator.next();
            WordCloud wordCloud = new WordCloud();
            wordCloud.setName(next.getCourseName());
            Long ans;
            if (Category.SELLING == category) {
                ans = courseService.querySellingSumByCourseId(next.getId(), count);
            } else {
                ans = courseService.queryViewSumByCourseId(next.getId(), count);
            }
            wordCloud.setValue(ans);
            wordClouds[i++] = wordCloud;
        }
        return Result.ok().put("wordClouds", wordClouds);
    }
}
