package com.yuchu.pojo;

import java.util.List;

public class Page<T> {
    //总页数
	int total;
	//第几页
	int page;
	//分页大小
	int pagesize;
	
	List<T> list;
	
	public Page(){
		
	}

	public Page(int total, int page, int pagesize) {
		this.total = total;
		this.page = page;
		this.pagesize = pagesize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
}
