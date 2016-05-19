package com.yc.vote.web.action;

import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Controller("registerMailAction")
public class RegisterMailAction {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public String sendEmail(){
		
			MimeMessage mm = javaMailSender.createMimeMessage(); //邮件信息类
			try {
				MimeMessageHelper smm = new MimeMessageHelper(mm,true);
				smm.setFrom("18173414165@163.com"); //邮件发送者
				smm.setTo("1274421194@qq.com"); //邮件接受者
				smm.setSubject("Sping邮件整合测试03。。。。。。。"); //邮件主题
				String actionId=UUID.randomUUID().toString();  //激活码
				String activePath="http://localhost:8080/vote/user_active.action?actionId="+actionId;//激活路径
				smm.setText("激活账号：<a href='"+activePath+"'>"+activePath+"</a>",true); //邮件内容
				javaMailSender.send(mm); //发送邮件
				ActionContext.getContext().getSession().put("actionId", actionId);
				return "success";
			} catch (MessagingException e) {
				
			}
			return "fail";
		
	}
}
