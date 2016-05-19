package com.yc.vote.web.action;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.yc.vote.entity.User;
import com.yc.vote.service.UserService;
import com.yc.vote.util.VoteData;

@Controller("userAction")
public class UserAction implements ModelDriven<User>,SessionAware{
	
	private User user;
	@Autowired
	private UserService userService;
	private Map<String, Object> session;

	public String login(){
		LogManager.getLogger().debug("login登录操作......");
		LogManager.getLogger().debug("login登录操作数据==>" + user);
		user = userService.login(user);
		if(user == null){
			session.put(VoteData.ERROR_MSG, "用户名或密码错误，请重新输入！！！");
			return "login";
		}
		session.put(VoteData.LOGIN_USER, user);
		return "loginSuccess";
	}
	
	public String register(){
		LogManager.getLogger().debug("register操作......");
		LogManager.getLogger().debug("register操作数据==>" + user);
		try {
			userService.register(user);
			return "registerSuccess";
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.put(VoteData.ERROR_MSG,"注册失败！！！");
		return "registerFail";
	}

	public User getModel() {
		user = new User();
		return user;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}
	
}
