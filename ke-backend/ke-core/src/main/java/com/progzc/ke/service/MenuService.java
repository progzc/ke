package com.progzc.ke.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.progzc.ke.entity.Menu;

import java.util.List;

/**
 * @Description Menu服务接口
 * @Author zhaocho
 * @Date 2021/3/17 15:40
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */
public interface MenuService extends IService<Menu> {
    List<Menu> listMenu();

    List<Menu> getModuleById(Integer id);
}
