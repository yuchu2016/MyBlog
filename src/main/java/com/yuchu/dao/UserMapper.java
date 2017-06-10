package com.yuchu.dao;

import java.util.List;

import com.yuchu.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User selectByUsername(String username);
    
    List<User> selectAll();
    
    int updateValid(User record);
    
    User selectValid(int id);
}