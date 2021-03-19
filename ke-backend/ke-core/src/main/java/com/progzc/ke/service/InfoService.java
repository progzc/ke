package com.progzc.ke.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.progzc.ke.entity.Info;

import java.util.List;

/**
 * @Description Info服务接口
 * @Author zhaocho
 * @Date 2021/3/17 15:41
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */
public interface InfoService extends IService<Info> {
    List<Info> queryListByMenuId(Integer id);

    List<Integer> queryIdListByMenuId(Integer id);
}
