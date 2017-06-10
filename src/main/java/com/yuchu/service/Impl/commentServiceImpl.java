package com.yuchu.service.Impl;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yuchu.dao.CommentMapper;
import com.yuchu.pojo.Comment;
import com.yuchu.service.commentService;
import com.yuchu.utils.dateUtil;

@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@Service
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class commentServiceImpl implements commentService {
	@Autowired
	private CommentMapper commentMapper;
	@Override
	public void addComment(Comment comment) {
		// TODO Auto-generated method stub
		comment.setCreatedAt(dateUtil.dateToStamp(new Date()));
		commentMapper.insertSelective(comment);
	}
	@Test
	public void TestAdd(){
		/*Comment comment = new Comment();
		comment.setContent("<p>1234</p>");
		comment.setPostid(26);
		addComment(comment);*/
		List<Comment> comments = getCommentByPostId(27);
		System.out.println(comments.size());
	}
	@Override
	public List<Comment> getCommentByPostId(int postId) {
		// TODO Auto-generated method stub
		List<Comment> comments = commentMapper.selectByPostId(postId);
		for (int i = 0; i < comments.size(); i++) {
			comments.get(i).setCreatedAt(dateUtil.stampToDate(comments.get(i).getCreatedAt()));
		}
		return comments;
	}

}
