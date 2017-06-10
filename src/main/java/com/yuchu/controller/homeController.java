package com.yuchu.controller;




import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.yuchu.pojo.Cats;
import com.yuchu.pojo.Posts;
import com.yuchu.pojo.User;
import com.yuchu.service.Impl.catsServiceImpl;
import com.yuchu.service.Impl.postServiceImpl;
import com.yuchu.service.Impl.relation_post_tagsServiceImpl;
import com.yuchu.service.Impl.tagsServiceImpl;
import com.yuchu.service.Impl.userServiceImpl;
import com.yuchu.utils.dateUtil;

@Controller
@RequestMapping("/home")
@SessionAttributes({"loginuser","username"})
public class homeController {
	@Autowired
	private postServiceImpl postServiceImpl;

	@Autowired
	private userServiceImpl userServiceImpl;
	@Autowired
	private catsServiceImpl catsServiceImpl;

	@Autowired
	private tagsServiceImpl tagsServiceImpl;

	@Autowired
	private relation_post_tagsServiceImpl relation_post_tagsServiceImpl;

	@RequestMapping("/index")
	public String homeView(HttpServletRequest request,Model model){
		if (request.getSession().getAttribute("loginuser")!=null) {
			User user = (User) request.getSession().getAttribute("loginuser");
			model.addAttribute("role",user.getRole());
			return "home";
		}
		return "redirect:/home/login";
	}
	//显示登录页面
	@RequestMapping("/login")
	public String loginView(){
		return "login";
	}
	//登录操作
	@RequestMapping("/dologin")
	public String dologin(String username,String password,Model model){
		if (null==userServiceImpl.checkUser(username, password)) {
			return "error";
		}else{
			User user = userServiceImpl.checkUser(username, password);
			if (user.getStatus()!=10) {
				return "error";
			}
			model.addAttribute("loginuser",user);
			model.addAttribute("username",user.getUsername());
			return "redirect:/home/index";
		}
	}
	//注销
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,SessionStatus sessionStatus){
		request.getSession().removeAttribute("loginuser");
		request.getSession().removeAttribute("username");
		sessionStatus.setComplete();
		return "redirect:/home/login";
	}
	//显示文章管理页面
	@RequestMapping("post/index")
	public String postView(Model model,HttpServletRequest request){
		if (request.getSession().getAttribute("loginuser")!=null) {
			List<Posts> posts = postServiceImpl.listValidPosts();
			model.addAttribute("posts",posts);
			return "post/index";
		}else {
			return "error";
		}
	}
	//设置文章合法性
	@RequestMapping("post/setValid/{postId}")
	public String postValid(@PathVariable Integer postId,HttpServletRequest request){
		if (request.getSession().getAttribute("loginuser")!=null) {
			postServiceImpl.changeValid(postId);
			return "redirect:/home/post/index";
		}else {
			return "error";
		}
	}
	//删除文章
	@RequestMapping("post/delete/{postId}")
	public String postdelete(@PathVariable Integer postId,HttpServletRequest request){
		if (request.getSession().getAttribute("loginuser")!=null) {
			postServiceImpl.deletePost(postId);
			return "redirect:/home/post/index";
		}else {
			return "error";
		}
	}
	//添加文章页面(权限大于10)
	@RequestMapping("post/add")
	public String addPost(HttpServletRequest request){
		if (request.getSession().getAttribute("loginuser")!=null) {
			User user = (User) request.getSession().getAttribute("loginuser");
			if (user.getRole()>10) {
				return "post/add";
			}
		}
		return "error";

	}
	//添加修改文章时获取分类(ajax)
	@RequestMapping(value="post/getAllCats",method=RequestMethod.POST)
	public @ResponseBody List<Cats> getAllCat(){
		return catsServiceImpl.getAllCats();
	}
	//添加文章
	@RequestMapping(value="post/postadd",method=RequestMethod.POST)
	public @ResponseBody String postAdd(String title,String catId,String isValid,@RequestParam("summary[]") List<String> summary,@RequestParam("content[]") List<String> content,String tags,String labelImg){
		String data;
		try {
			String newContent="";
			for (int i = 0; i < content.size(); i++) {
				newContent+=content.get(i);
			}
			String newSummary="";
			for (int i = 0; i < summary.size(); i++) {
				newSummary+=summary.get(i);
			}
			Posts posts = new Posts();
			posts.setTitle(title);
			posts.setCatId(Integer.parseInt(catId));
			posts.setContent(newContent);
			posts.setSummary(newSummary);
			posts.setCreatedAt(dateUtil.dateToStamp(new Date()));
			posts.setUpdatedAt(dateUtil.dateToStamp(new Date()));
			posts.setIsValid(isValid.equals("1"));
			posts.setUserId(566);
			posts.setUserName("yuchu");
			posts.setLabelImg(labelImg);
			postServiceImpl.addPost(posts);
			String[] tag = tags.split("/");
			for (int i = 0; i < tag.length; i++) {
				int tagId = tagsServiceImpl.getTagByTagName(tag[i]);
				relation_post_tagsServiceImpl.addRelations(posts.getId(), tagId);
			}
			data="success";
		} catch (Exception e) {
			// TODO: handle exception
			data="error";
		}

		return data;
	}
	//显示增加用户界面
	@RequestMapping("/user/add")
	public String addUser(HttpServletRequest request){
		if(request.getSession().getAttribute("loginuser")!=null){
			User user = (User) request.getSession().getAttribute("loginuser");
			if (user.getRole()>20) {
				return "User/add";
			}
		}
		return "error";
	}
	//添加用户
	@RequestMapping(value="/user/doadd",method=RequestMethod.POST)
	public String doUserAdd(User newUser,HttpSession session){
		if(session.getAttribute("loginuser")!=null){
			User user = (User) session.getAttribute("loginuser");
			if (user.getRole()>20) {
				userServiceImpl.addUser(newUser);
				return "redirect:/home/user/index";
			}
		}
		return "error";
	}
	//显示用户
	@RequestMapping("/user/index")
	public String showUsers(HttpServletRequest request,Model model){
		if (request.getSession().getAttribute("loginuser")!=null) {
			User user = (User) request.getSession().getAttribute("loginuser");
			if (user.getRole()>20) {
				List<User> users = userServiceImpl.getAll();
				for (int i = 0; i < users.size(); i++) {
					if (null!=users.get(i).getUpdatedAt()) {
						users.get(i).setUpdatedAt(dateUtil.stampToDate(users.get(i).getUpdatedAt()));
					}
				}
				model.addAttribute("users",users);
				return "User/index";
			}
		}
		return "error";
	}
	//修改用户是否合法
	@RequestMapping("user/setValid/{userid}")
	public String setUserValid(@PathVariable Integer userid,HttpSession session){
		if (session.getAttribute("loginuser")!=null) {
			User user = (User) session.getAttribute("loginuser");
			if (user.getRole()>20){
				userServiceImpl.setValid(userid);
				return "redirect:/home/user/index";
			}
		}
		return "error";
	}
	//上传封面图片
	 @ResponseBody
	    @RequestMapping("post/addpic")
	    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {  
	    	SimpleDateFormat dateForma=new SimpleDateFormat("yyyyMMdd");
			Date c= new Date();
	        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/resources/image/"+dateForma.format(c));  
	        System.out.println(file);
	        StringBuffer ped=new StringBuffer(file.getOriginalFilename());
	        int index=ped.reverse().indexOf(".");
	        String fileName =String.valueOf(c.getTime())+'.'+file.getOriginalFilename().substring(ped.length()-index, ped.length());
	        
	        File targetFile = new File(path, fileName);  
	        if(!targetFile.exists()){  
	            targetFile.mkdirs();  
	        }  
	        //保存  
	        try {  
	            file.transferTo(targetFile);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }   
	  
	        return "/image/"+dateForma.format(c)+'/'+fileName;  
	    }  

}
