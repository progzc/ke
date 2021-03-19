package com.progzc.ke.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.progzc.ke.entity.Menu;
import com.progzc.ke.mapper.MenuMapper;
import com.progzc.ke.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description Menu服务实现类
 * @Author zhaochao
 * @Date 2021/3/17 15:46
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */
@Service
@Slf4j
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    /**
     * 获取所有菜单
     * @return
     */
    @Override
    public List<Menu> listMenu() {
        List<Menu> menuList = queryListParentId(0, null);
        getMenuTreeList(menuList, null);
        return menuList;
    }

    /**
     * 获取子模块的菜单
     * @param id
     * @return
     */
    @Override
    public List<Menu> getModuleById(Integer id) {
        return menuMapper.selectList(new QueryWrapper<Menu>().lambda().eq(Menu::getParentId, id));
    }

    private List<Menu> getMenuTreeList(List<Menu> menuList, List<Integer> menuIdList) {
        List<Menu> subMenuList = new ArrayList<>();
        for (Menu menu : menuList) {
            menu.setList(getMenuTreeList(queryListParentId(menu.getId(), menuIdList), menuIdList));
            subMenuList.add(menu);
        }
        return subMenuList;
    }

    private List<Menu> queryListParentId(Integer parentId, List<Integer> menuIdList) {
        List<Menu> menuList = queryListParentId(parentId);
        if (menuIdList == null) {
            return menuList;
        }
        List<Menu> subMenuList = new ArrayList<>();
        for (Menu menu : menuList) {
            if (menuIdList.contains(menu.getId())) {
                subMenuList.add(menu);
            }
        }
        return subMenuList;
    }

    private List<Menu> queryListParentId(Integer parentId) {
        return menuMapper.queryListParentId(parentId);
    }

}
