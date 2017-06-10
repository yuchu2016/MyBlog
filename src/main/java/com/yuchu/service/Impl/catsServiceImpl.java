package com.yuchu.service.Impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yuchu.dao.CatsMapper;
import com.yuchu.pojo.Cats;
import com.yuchu.service.catsService;

@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@Service
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class catsServiceImpl implements catsService {

	@Autowired
	private CatsMapper catsMapper;
	@Override
	public Cats getCatById(int id) {
		// TODO Auto-generated method stub
		return catsMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<Cats> getAllCats() {
		// TODO Auto-generated method stub
		return catsMapper.selectAll();
	}

	@Test
	public void getCats(){
		System.out.println(getAllCats().get(0).getCatName());
	}
}
