package com.yuchu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yuchu.pojo.Relation_post_tags;
@Repository
public interface Relation_post_tagsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Relation_post_tags record);

    int insertSelective(Relation_post_tags record);

    Relation_post_tags selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Relation_post_tags record);

    int updateByPrimaryKey(Relation_post_tags record);
    
    List<Relation_post_tags> selectPostIdByTagId(Integer tagId);

	int deleteByPostId(Integer id);
}