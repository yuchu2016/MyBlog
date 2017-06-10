package com.yuchu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yuchu.pojo.Comment;
@Repository
public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);
    
    List<Comment> selectByPostId(Integer postId);
}