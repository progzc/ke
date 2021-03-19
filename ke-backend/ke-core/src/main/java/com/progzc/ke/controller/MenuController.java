package com.progzc.ke.controller;

import com.progzc.ke.common.Result;
import com.progzc.ke.entity.Menu;
import com.progzc.ke.service.MenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description 菜单控制器
 * @Author zhaochao
 * @Date 2021/3/17 17:52
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */
@RestController
@RequestMapping("/sys/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/nav")
    @ApiOperation(value = "查询导航菜单")
    public Result nav() {
        List<Menu> menuList = menuService.listMenu();
        return Result.ok().put("menuList", menuList);
    }

    @GetMapping("/module/{id}")
    @ApiOperation(value = "获取子模块的菜单")
    public Result module(@PathVariable Integer id) {
        List<Menu> options = menuService.getModuleById(id);
        return Result.ok().put("options", options);
    }

}
