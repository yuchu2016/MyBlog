package com.yuchu.service;


import java.util.List;

import com.yuchu.pojo.Feeds;

public interface feedsService {

	public List<Feeds> queryByPage(Integer pageNo,Integer pageSize);
	
	public void addFeeds(Feeds feeds);
}
