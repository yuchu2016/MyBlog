package com.yuchu.controller;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.yuchu.pojo.Feeds;
import com.yuchu.pojo.Page;
import com.yuchu.service.Impl.SensitiveService;
import com.yuchu.service.Impl.feedsServiceImpl;
import com.yuchu.utils.dateUtil;

@Controller
public class feelsController {
	@Autowired
	private feedsServiceImpl feedsService;
	@Autowired
	private SensitiveService sensitiveService;
	@RequestMapping("/feels")
	public String aboutView(@RequestParam(required = false, defaultValue = "1")int page,Model model){
		List<Feeds> list = feedsService.queryByPage(page, 8);//查询
		 // 取分页信息
        PageInfo<Feeds> pageInfo = new PageInfo<Feeds>(list);
        for (int i = 0; i < list.size(); i++) {
			list.get(i).setCreatedAt(dateUtil.stampToDate(list.get(i).getCreatedAt()));
		}
        Page<Feeds> data = new Page<Feeds>();
        data.setList(list);
        data.setTotal(pageInfo.getPages());
        data.setPagesize(8);
        data.setPage(pageInfo.getPageNum());
        model.addAttribute("data",data);
		return "feels";
	}
	@RequestMapping(value="/feels/add",method=RequestMethod.POST)
	public @ResponseBody String addFeels(String content,ServletRequest request){
		//System.out.println(content);
		content = sensitiveService.filter(content);
		Feeds feeds = new Feeds();
		feeds.setContent(content);
		feeds.setUser(request.getRemoteAddr());
		feedsService.addFeeds(feeds);
		return "{}";
	}
}
