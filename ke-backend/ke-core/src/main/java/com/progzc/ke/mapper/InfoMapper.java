package com.progzc.ke.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.progzc.ke.entity.Info;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description Info DAO层接口
 * @Author zhaocho
 * @Date 2021/3/17 15:36
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */
@Mapper
public interface InfoMapper extends BaseMapper<Info> {

    List<Integer> queryIdListByMenuId(Integer id);
}
