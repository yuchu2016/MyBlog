package com.yuchu.service.Impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yuchu.dao.UserMapper;
import com.yuchu.pojo.User;
import com.yuchu.service.userService;
import com.yuchu.utils.MD5Util;
import com.yuchu.utils.dateUtil;
@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@Service
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class userServiceImpl implements userService {

	@Autowired
	private UserMapper userMapper;
	@Override
	//登录验证
	public User checkUser(String username,String password) {
		// TODO Auto-generated method stub
		User user = userMapper.selectByUsername(username);
		if (user!=null&&user.getPasswordHash().equals(MD5Util.string2MD5(password))) {
			return user;
		}else
			return null;
	}

	//添加新用户
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		user.setPasswordHash(MD5Util.string2MD5(user.getPasswordHash()));
		user.setCreatedAt(dateUtil.dateToStamp(new Date()));
		user.setUpdatedAt(dateUtil.dateToStamp(new Date()));
		userMapper.insertSelective(user);
	}
	
	@Test
	public void test(){
		setValid(573);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userMapper.selectAll();
	}

	@Override
	public void setValid(int id) {
		// TODO Auto-generated method stub
		User user = userMapper.selectValid(id);
		if (user.getStatus()==0) {
			user.setStatus((short) 10);
			userMapper.updateValid(user);
		}else if (user.getStatus()==10) {
			user.setStatus((short) 0);
			userMapper.updateValid(user);
		}
	}

}
