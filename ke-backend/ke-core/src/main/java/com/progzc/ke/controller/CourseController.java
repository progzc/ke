package com.progzc.ke.controller;

import com.progzc.ke.common.Result;
import com.progzc.ke.constants.Category;
import com.progzc.ke.entity.Course;
import com.progzc.ke.entity.Info;
import com.progzc.ke.entity.chart.Sery;
import com.progzc.ke.service.CourseService;
import com.progzc.ke.service.InfoService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@Slf4j
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private InfoService infoService;

    @GetMapping("/chart")
    @ApiOperation(value = "获取子模块的折线图")
    public Result module(Integer id, Integer count, Integer category) {
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
}
