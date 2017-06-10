package com.yuchu.dao;

import org.springframework.stereotype.Repository;

import com.yuchu.pojo.Post_extends;
@Repository
public interface Post_extendsMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByPostId(Integer id);
    
    int insert(Post_extends record);

    int insertSelective(Post_extends record);

    Post_extends selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Post_extends record);

    int updateByPrimaryKey(Post_extends record);
    
    Post_extends selectByPostId(Integer id);
    
    boolean updateBrowserByPostId(Integer postId);
}