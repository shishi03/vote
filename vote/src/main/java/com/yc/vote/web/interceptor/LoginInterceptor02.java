package com.yc.vote.web.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

//用户登录拦截器
public class LoginInterceptor02 implements Interceptor {

	private static final long serialVersionUID = 1307687631270550421L;

	public void destroy() {}

	public void init() {}

	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String,Object> session = ActionContext.getContext().getSession(); //取到session的封装对象
		Object obj = session.get("loginUser");
		if(obj == null){
			session.put("errorMsg", "请登录后再进行操作！！！");
			return "login";
		}
		return invocation.invoke();
	}

	


	

	

}
