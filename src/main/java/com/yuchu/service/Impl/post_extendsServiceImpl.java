package com.yuchu.service.Impl;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yuchu.dao.Post_extendsMapper;
import com.yuchu.service.post_extendsService;
@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@Service
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class post_extendsServiceImpl implements post_extendsService {
	@Autowired
	private Post_extendsMapper post_extendsMapper;

	@Override
	public boolean postBrowserAdd(int postId) {
		// TODO Auto-generated method stub
		if (post_extendsMapper.updateBrowserByPostId(postId)) {
			return true;
		}
		return false;
	}
	@Test
	public void test(){
		assertTrue(postBrowserAdd(22));
	}
}
