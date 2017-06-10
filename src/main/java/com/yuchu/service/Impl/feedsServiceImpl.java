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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuchu.dao.FeedsMapper;
import com.yuchu.pojo.Feeds;
import com.yuchu.service.feedsService;
import com.yuchu.utils.dateUtil;

@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@Service
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class feedsServiceImpl implements feedsService {

	@Autowired
	public FeedsMapper feedsMapper;
	@Override
	public List<Feeds> queryByPage(Integer pageNo, Integer pageSize) {
		 pageNo = pageNo == null?1:pageNo;
		    pageSize = pageSize == null?10:pageSize;
		    PageHelper.startPage(pageNo, pageSize);
		    List<Feeds> list = feedsMapper.selectAll();
		    return list;
		//return null;
	}
	@Test  
    public void queryByPageTest(){ 
		 List<Feeds> list = queryByPage(1, 1);//查询
	        // 取心情列表
	        for(Feeds item : list) {
	            System.out.println(item.getContent());
	        }
	        // 取分页信息
	        PageInfo<Feeds> pageInfo = new PageInfo<Feeds>(list);
	        long total = pageInfo.getTotal(); //获取总记录数
	        System.out.println("共有心情条数：" + total);
    }
	@Override
	public void addFeeds(Feeds feeds) {
		// TODO Auto-generated method stub
		feeds.setCreatedAt(dateUtil.dateToStamp(new Date()));
		feedsMapper.insertSelective(feeds);
	}

}
