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
		
			MimeMessage mm = javaMailSender.createMimeMessage(); //�ʼ���Ϣ��
			try {
				MimeMessageHelper smm = new MimeMessageHelper(mm,true);
				smm.setFrom("18173414165@163.com"); //�ʼ�������
				smm.setTo("1274421194@qq.com"); //�ʼ�������
				smm.setSubject("Sping�ʼ����ϲ���03��������������"); //�ʼ�����
				String actionId=UUID.randomUUID().toString();  //������
				String activePath="http://localhost:8080/vote/user_active.action?actionId="+actionId;//����·��
				smm.setText("�����˺ţ�<a href='"+activePath+"'>"+activePath+"</a>",true); //�ʼ�����
				javaMailSender.send(mm); //�����ʼ�
				ActionContext.getContext().getSession().put("actionId", actionId);
				return "success";
			} catch (MessagingException e) {
				
			}
			return "fail";
		
	}
}
