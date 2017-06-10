package com.yuchu.service;

import java.util.List;

import com.yuchu.pojo.Comment;

public interface commentService {

	public void addComment(Comment comment);
	
	public List<Comment> getCommentByPostId(int postId);
}
