package com.yuchu.service.Impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yuchu.dao.TagsMapper;
import com.yuchu.pojo.Tags;
import com.yuchu.service.tagsService;
@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@Service
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class tagsServiceImpl implements tagsService{
	@Autowired
	private TagsMapper tagsMapper;
	
	@Override
	public List<Tags> getTagName() {
		// TODO Auto-generated method stub
		return tagsMapper.selectTagName();
	}

	@Override
	public int getTagByTagName(String tagName) {
		// TODO Auto-generated method stub
		if (null==tagsMapper.selectByTagName(tagName)) {
			Tags newtag= new Tags();
			newtag.setTagName(tagName);
			newtag.setPostNum(1);
			tagsMapper.insert(newtag);
			return tagsMapper.selectByTagName(tagName).getId();
		}else {
			tagsMapper.updateByTagName(tagName);
			return tagsMapper.selectByTagName(tagName).getId();
		}
	}
	
	@Test
	public void getTags(){
		
		//assertEquals(getTagByTagName("test"), 17);
		
	}
}
