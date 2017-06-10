package com.yuchu.service;

import java.util.List;

import com.yuchu.pojo.Posts;;

public interface postService {
	
	public List<Posts> listAll();
	
	public List<Posts> listAllPosts();
	
	public Posts getPostById(int id);
	
	public List<Posts> listTopPosts();
	
	public List<Posts> listNewPosts();
	
	public List<Posts> getPostByTagId(int id);
	
	public List<Posts> listValidPosts();
	
	public int changeValid(int id);
	
	public boolean deletePost(int id);
	
	public void addPost(Posts posts); 
	
}
