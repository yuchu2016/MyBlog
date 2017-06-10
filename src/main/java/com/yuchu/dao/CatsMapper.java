package com.yuchu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yuchu.pojo.Cats;
@Repository
public interface CatsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cats record);

    int insertSelective(Cats record);

    Cats selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cats record);

    int updateByPrimaryKey(Cats record);
    
    List<Cats> selectAll();
}