package com.yuchu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yuchu.pojo.Tags;
@Repository
public interface TagsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tags record);

    int insertSelective(Tags record);

    Tags selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tags record);

    int updateByPrimaryKey(Tags record);
    
    List<Tags> selectTagName();
    
    Tags selectByTagName(String tagName);
    
    int updateByTagName(String tagName);
}