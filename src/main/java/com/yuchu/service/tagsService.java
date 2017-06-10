package com.yuchu.service;

import java.util.List;

import com.yuchu.pojo.Tags;

public interface tagsService {
	
	public List<Tags> getTagName();
	
	public int getTagByTagName(String tagName);
}
