package com.yuchu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuchu.pojo.Posts;
import com.yuchu.pojo.Tags;
import com.yuchu.service.tagsService;
import com.yuchu.service.Impl.postServiceImpl;
import com.yuchu.service.Impl.tagsServiceImpl;
import com.yuchu.utils.dateUtil;

@Controller
public class indexController {
	@Autowired
	private postServiceImpl postServiceImpl;
	@Autowired
	private tagsServiceImpl tagsServiceImpl;
	@RequestMapping("/index")
	public String indexView(Model model){
		List<Posts> pList = postServiceImpl.listAllPosts();
		List<Posts> nList = postServiceImpl.listNewPosts();
		List<Posts> tList = postServiceImpl.listTopPosts();
		List<Tags> tags = tagsServiceImpl.getTagName();
		model.addAttribute("posts", pList);
		model.addAttribute("newposts", nList);
		model.addAttribute("topposts", tList);
		model.addAttribute("tags",tags);
		return "index";
	}
}
