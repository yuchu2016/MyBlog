package com.yuchu.service;

import java.util.List;

import com.yuchu.pojo.Cats;

public interface catsService {
	
	public Cats getCatById(int id);
	
	public List<Cats> getAllCats();
}
