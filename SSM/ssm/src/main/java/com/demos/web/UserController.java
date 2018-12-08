package com.demos.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demos.model.User;
import com.demos.service.IUserService;
import com.demos.utils.Page;

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/list")
	public String list(User user,HttpServletRequest request, Model model) {
		logger.debug("into list");
		try {
			Page page = newPage(request);
			int total = userService.count(user);
			page.setTotalCount(total);
			if (page.getTotalCount() <= page.getPageSize()) {
				page.setPageIndex(1);
			}
			
			Integer pageNo = page.getPageIndex();
			Integer pageSize = page.getPageSize();
			int pageIndex = (pageNo - 1) * pageSize;
			List<User> list = userService.list(user, pageIndex, pageSize);
			
			model.addAttribute("userList", list);
			model.addAttribute("page", page);
			model.addAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/page/user/list";
	}
	@RequestMapping("/addOrUpdate")
	public String addOrUpdate(User user,HttpServletRequest request, Model model) {
		logger.debug("into addOrUpdate");
		try {
			if(null != user && null != user.getId() && 0 != user.getId()){
				userService.update(user);
			}else{
				userService.insert(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/user/list";
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(Integer id,HttpServletRequest request, Model model) {
		String result ="fail";
		try {
			userService.delete(id);
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
}
