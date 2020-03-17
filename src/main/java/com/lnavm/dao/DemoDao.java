package com.lnavm.dao;

import com.lnavm.pojo.Demo;
import com.lnavm.thirdutils.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : lq
 * @date : 2019/4/16
 */
public interface DemoDao extends BaseDao<DemoDao>{
    Demo selectByPrimaryKey(@Param("id") int id);

    /**
     * 查询所有id不为指定id的记录
     * @param id     指定的id
     * @param page   分页内容（mapper中不用考虑，通过拦截器处理）
     * @return       所有id不为id记录集合
     */
    List<Demo> queryAll(@Param("id") int id, Page<Demo> page);
}
