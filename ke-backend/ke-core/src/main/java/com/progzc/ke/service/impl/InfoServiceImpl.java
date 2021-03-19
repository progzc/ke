package com.progzc.ke.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.progzc.ke.entity.Info;
import com.progzc.ke.mapper.InfoMapper;
import com.progzc.ke.service.InfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description Info服务实现类
 * @Author zhaochao
 * @Date 2021/3/17 15:47
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */
@Service
@Slf4j
public class InfoServiceImpl extends ServiceImpl<InfoMapper, Info> implements InfoService {

    @Resource
    private InfoMapper infoMapper;

    @Override
    public List<Info> queryListByMenuId(Integer id) {
        return infoMapper.selectList(new QueryWrapper<Info>().lambda().eq(Info::getMenuId, id));
    }
}
