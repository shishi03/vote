package com.yc.vote.web.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.yc.vote.util.VoteData;

//MethodFilterInterceptor���Զ����󷽷����й���
public class LoginInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = 1307687631270550421L;

	public void destroy() {}

	public void init() {}

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Map<String,Object> session = ActionContext.getContext().getSession(); //ȡ��session�ķ�װ����
		Object obj = session.get(VoteData.LOGIN_USER);
		if(obj == null){
			session.put(VoteData.ERROR_MSG, "���¼���ٽ��в���������");
			return "login";
		}
		return invocation.invoke();
	}

	


	

	

}
