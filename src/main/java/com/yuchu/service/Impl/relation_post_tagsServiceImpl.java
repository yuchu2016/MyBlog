package com.yuchu.service.Impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yuchu.dao.Relation_post_tagsMapper;
import com.yuchu.pojo.Relation_post_tags;
import com.yuchu.service.relation_post_tagsService;
@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@Service
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class relation_post_tagsServiceImpl implements relation_post_tagsService {
	
	@Autowired
	private Relation_post_tagsMapper relation_post_tagsMapper;
	@Override
	public void addRelations(int postId,int tagId) {
		// TODO Auto-generated method stub
		Relation_post_tags relation_post_tags = new Relation_post_tags();
		relation_post_tags.setPostId(postId);
		relation_post_tags.setTagId(tagId);
		relation_post_tagsMapper.insert(relation_post_tags);
	}
	@Test
	public void addRelationsTest(){
		addRelations(22, 17);
	}
}
