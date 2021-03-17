package com.progzc.ke.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.progzc.ke.entity.Menu;
import com.progzc.ke.mapper.MenuMapper;
import com.progzc.ke.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
