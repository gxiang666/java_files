package com.demos.web;

import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demos.model.User;
import com.demos.service.IUserService;

@Controller
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private IUserService userService;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/user/list.html";
	}

	@RequestMapping("/unauth")
	public String unauth() throws Exception {
		return "/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, HttpServletRequest request,
			HttpSession session) throws Exception {
		Object username = session.getAttribute("username");
		if (null != username) {
			return "redirect:/user/list.html";
		}
		String contextPath = request.getContextPath();
		session.setAttribute("ctx", contextPath);
		model.addAttribute("message", "");
		return "/login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(User user,
			HttpSession session, Model model, HttpServletRequest request) {
		logger.debug("login............");
		String result = "/login";
		if(null != user && StringUtils.isNotBlank(user.getName()) && StringUtils.isNotBlank(user.getPassword())) {
			List<User> list = userService.list(user, 0, 1);
			if(null != list && list.size() >0) {
				session.setAttribute("username", user.getName());
				result = "redirect:/user/list.html";
			}else {
				model.addAttribute("message", "用户名或密码错误!");
			}
		}else {
			model.addAttribute("message", "用户名或密码不能为空!");
		}
		return result;
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/user/list.html";
	}
}
