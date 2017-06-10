package com.yuchu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yuchu.pojo.Posts;
@Repository
public interface PostsMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Posts record);

	int insertSelective(Posts record);

	Posts selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Posts record);

	int updateByPrimaryKeyWithBLOBs(Posts record);

	int updateByPrimaryKey(Posts record);

	List<Posts> selectAllInfo();

	List<Posts> selectAll();

	List<Posts> selectNewPost();

	List<Posts> selectTopPost();

	Posts selectInfoByPostId(Integer id);

	List<Posts> selectValid();
}