package com.yuchu.controller;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuchu.pojo.Comment;
import com.yuchu.pojo.Posts;
import com.yuchu.pojo.Tags;
import com.yuchu.service.post_extendsService;
import com.yuchu.service.Impl.SensitiveService;
import com.yuchu.service.Impl.commentServiceImpl;
import com.yuchu.service.Impl.postServiceImpl;
import com.yuchu.service.Impl.post_extendsServiceImpl;
import com.yuchu.service.Impl.tagsServiceImpl;
import com.yuchu.utils.PageModel;
import com.yuchu.utils.dateUtil;

@Controller
public class postController {
	@Autowired
	private postServiceImpl postService;
	@Autowired
	private post_extendsServiceImpl post_extendsService;
	@Autowired
	private tagsServiceImpl tagsServiceImpl;
	@Autowired
	private commentServiceImpl commentService;
	@Autowired
	private SensitiveService sensitiveService;
	@RequestMapping("/post")
	public String postView(Model model){
		//PageModel pm = new PageModel(postService.listAll(), 5);  //页面容量 
		//List<Posts> posts = pm.getObjects(pageId);	//返回第几页数据
		List<Posts> posts = postService.listAll();
		List<Posts> nList = postService.listNewPosts();
		List<Posts> tList = postService.listTopPosts();
		List<Tags> tags = tagsServiceImpl.getTagName();
		model.addAttribute("posts",posts);
		model.addAttribute("newposts", nList);
		model.addAttribute("topposts", tList);
		model.addAttribute("tags",tags);
		return "allpost";
	}
	@RequestMapping(value = "/post/{postId}")
	 public String showPostDetails(@PathVariable int postId,Model model){
		try {
			List<Comment> comments = commentService.getCommentByPostId(postId);
			Posts post = postService.getPostById(postId);
			post_extendsService.postBrowserAdd(postId);
			post.setCreatedAt(dateUtil.stampToDate(post.getCreatedAt()));
			model.addAttribute("post",post);
			List<Posts> nList = postService.listNewPosts();
			List<Posts> tList = postService.listTopPosts();
			List<Tags> tags = tagsServiceImpl.getTagName();
			model.addAttribute("comments",comments);
			model.addAttribute("newposts", nList);
			model.addAttribute("topposts", tList);
			model.addAttribute("tags",tags);
			return "post";
		} catch (Exception e) {
			return "err";
		}
		
	}
	@RequestMapping(value = "/tags/{tagsId}")
	public String showPostsByTag(@PathVariable int tagsId,Model model){
		try {
			List<Posts> posts = postService.getPostByTagId(tagsId);
			model.addAttribute("posts",posts);
			List<Posts> nList = postService.listNewPosts();
			List<Posts> tList = postService.listTopPosts();
			List<Tags> tags = tagsServiceImpl.getTagName();
			model.addAttribute("newposts", nList);
			model.addAttribute("topposts", tList);
			model.addAttribute("tags",tags);
			return "allpost";
		} catch (Exception e) {
			return "err";
		}
		
	}
	@RequestMapping(value="/post/addComment",method=RequestMethod.POST)
	public @ResponseBody String commentAdd(int postid,String content,ServletRequest request){
		Comment comment = new Comment();
		content = sensitiveService.filter(content);
		comment.setContent(content);
		comment.setPostid(postid);
		comment.setUsername(request.getRemoteAddr());
		commentService.addComment(comment);
		return "{}";
	}
}
