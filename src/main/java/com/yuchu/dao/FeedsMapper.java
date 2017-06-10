package com.yuchu.dao;

import java.util.List;

import com.yuchu.pojo.Feeds;

public interface FeedsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Feeds record);

    int insertSelective(Feeds record);

    List<Feeds> selectAll();
    
    Feeds selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Feeds record);

    int updateByPrimaryKey(Feeds record);
}