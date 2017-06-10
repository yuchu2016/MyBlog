package com.yuchu.service.Impl;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yuchu.dao.CatsMapper;
import com.yuchu.dao.Post_extendsMapper;
import com.yuchu.dao.PostsMapper;
import com.yuchu.dao.Relation_post_tagsMapper;
import com.yuchu.pojo.Post_extends;
import com.yuchu.pojo.Posts;
import com.yuchu.pojo.Relation_post_tags;
import com.yuchu.service.postService;
import com.yuchu.utils.dateUtil;
@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@Service
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class postServiceImpl implements postService {

	@Autowired
	private PostsMapper postsMapper;

	@Autowired
	private CatsMapper catsMapper;

	@Autowired
	private Post_extendsMapper post_extendsMapper;

	@Autowired
	private Relation_post_tagsMapper relation_post_tagsMapper;

	//首页展示8篇文章
	@Override
	public List<Posts> listAllPosts() {
		// TODO Auto-generated method stub
		List<Posts> pList =postsMapper.selectAllInfo();
		for (int i = 0; i < pList.size(); i++) {
			pList.get(i).setUpdatedAt(dateUtil.stampToDate(pList.get(i).getUpdatedAt()));
			pList.get(i).getCats().setCatName(catsMapper.selectByPrimaryKey(pList.get(i).getCatId()).getCatName());
			pList.get(i).getPost_extends().setBrowser(post_extendsMapper.selectByPostId(pList.get(i).getId()).getBrowser());
			pList.get(i).getPost_extends().setComment(post_extendsMapper.selectByPostId(pList.get(i).getId()).getComment());
		}
		return  pList;
	}

	//根据文章ID查出文章所有信息
	@Override
	public Posts getPostById(int id) {

		return postsMapper.selectByPrimaryKey(id);
	} 

	//查出最热的6篇文章，扔在  点击排行  
	@Override
	public List<Posts> listTopPosts() {
		// TODO Auto-generated method stub
		return postsMapper.selectTopPost();
	}

	//查出最新的6篇文章，扔在  最新文章  
	@Override
	public List<Posts> listNewPosts() {
		// TODO Auto-generated method stub
		return postsMapper.selectNewPost();
	}

	//根据标签查出文章
	@Override
	public List<Posts> getPostByTagId(int id) {
		// TODO Auto-generated method stub
		List<Relation_post_tags> postId=relation_post_tagsMapper.selectPostIdByTagId(id);

		List<Posts> posts = new ArrayList<Posts>();
		for (int i = 0; i < postId.size(); i++) {
			System.out.println(postId.get(i).getPostId());
			posts.add(postsMapper.selectInfoByPostId(postId.get(i).getPostId()));
		}
		for (int i = 0; i < posts.size(); i++) {
			posts.get(i).setUpdatedAt(dateUtil.stampToDate(posts.get(i).getUpdatedAt()));
			posts.get(i).getCats().setCatName(catsMapper.selectByPrimaryKey(posts.get(i).getCatId()).getCatName());
			posts.get(i).getPost_extends().setBrowser(post_extendsMapper.selectByPostId(posts.get(i).getId()).getBrowser());
			posts.get(i).getPost_extends().setComment(post_extendsMapper.selectByPostId(posts.get(i).getId()).getComment());
		}
		return posts;
	}

	//post页面列出所有文章
	@Override
	public List<Posts> listAll() {
		// TODO Auto-generated method stub
		return postsMapper.selectAll();
	}

	//后台列出所有合法以及非法文章
	@Override
	public List<Posts> listValidPosts() {
		// TODO Auto-generated method stub
		return postsMapper.selectValid();
	}

	//修改文章是否可读
	@Override
	public int changeValid(int id) {
		// TODO Auto-generated method stub
		Posts post = getPostById(id);
		if (post.getIsValid()) {
			post.setIsValid(false);
		}else {
			post.setIsValid(true);
		}
		return postsMapper.updateByPrimaryKeySelective(post);
	}
	//删除文章
	@Override
	public boolean deletePost(int id) {
		// TODO Auto-generated method stub
		postsMapper.deleteByPrimaryKey(id);
		post_extendsMapper.deleteByPostId(id);
		relation_post_tagsMapper.deleteByPostId(id);
		return true;
	}
	
	
	@Override
	public void addPost(Posts posts) {
		// TODO Auto-generated method stub
		postsMapper.insertSelective(posts);
		Post_extends post_extends = new Post_extends();
		post_extends.setPostId(posts.getId());
		post_extendsMapper.insertSelective(post_extends);
	}

	@Test
	public void addPosts(){
		Posts posts = new Posts();
		posts.setTitle("test");
		addPost(posts);
	}

}
