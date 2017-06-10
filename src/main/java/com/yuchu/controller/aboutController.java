package com.yuchu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuchu.pojo.Posts;
import com.yuchu.pojo.Tags;
import com.yuchu.service.Impl.postServiceImpl;
import com.yuchu.service.Impl.tagsServiceImpl;

@Controller
public class aboutController {
	@Autowired
	private postServiceImpl postServiceImpl;
	@Autowired
	private tagsServiceImpl tagsServiceImpl;
	@RequestMapping("/about")
	public String aboutView(Model model){
		List<Posts> nList = postServiceImpl.listNewPosts();
		List<Posts> tList = postServiceImpl.listTopPosts();
		List<Tags> tags = tagsServiceImpl.getTagName();
		model.addAttribute("newposts", nList);
		model.addAttribute("topposts", tList);
		model.addAttribute("tags",tags);
		return "about";
	}
}
