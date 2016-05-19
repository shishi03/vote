package com.yc.vote.test;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class JavaMailSenderTest {

	@Autowired
	private JavaMailSender javaMailSender; //邮件发送对象
	
	@Test
	public void testSendEmail() {
		SimpleMailMessage smm = new SimpleMailMessage(); //邮件信息类
		smm.setFrom("18173414165@163.com"); //邮件发送者
		smm.setTo("1030583546@qq.com"); //邮件接受者
		smm.setSubject("第一封信"); //邮件主题
		smm.setText("你好，我是spring邮件测试第一封信。。。。。"); //邮件内容
		
		javaMailSender.send(smm); //发送邮件
		System.out.println("邮件发送成功！！！");
	}
	
	@Test
	public void testSendEmail02() {
		MimeMessage mm = javaMailSender.createMimeMessage(); //邮件信息类
		MimeMessageHelper smm = new MimeMessageHelper(mm);
		try {
			smm.setFrom("18173414165@163.com"); //邮件发送者
			smm.setTo("1274421194@qq.com"); //邮件接受者
			smm.setSubject("Sping邮件整合测试03。。。。。。。"); //邮件主题
			smm.setText("你好，我是spring邮件测试<br>"
					+ "<a href='http://www.baidu.com'>进入百度</a><br>"
					+"<img src='cid:pic123'/>",true); //邮件内容
			
			FileSystemResource fsr = new FileSystemResource("E:\04.jpg"); //创建文件系统资源
			smm.addInline("pic123", fsr); //把内容Id与文件系统资源绑定
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		javaMailSender.send(mm); //发送邮件
		System.out.println("邮件发送成功！！！");
	}

}
