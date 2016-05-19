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
	private JavaMailSender javaMailSender; //�ʼ����Ͷ���
	
	@Test
	public void testSendEmail() {
		SimpleMailMessage smm = new SimpleMailMessage(); //�ʼ���Ϣ��
		smm.setFrom("18173414165@163.com"); //�ʼ�������
		smm.setTo("1030583546@qq.com"); //�ʼ�������
		smm.setSubject("��һ����"); //�ʼ�����
		smm.setText("��ã�����spring�ʼ����Ե�һ���š���������"); //�ʼ�����
		
		javaMailSender.send(smm); //�����ʼ�
		System.out.println("�ʼ����ͳɹ�������");
	}
	
	@Test
	public void testSendEmail02() {
		MimeMessage mm = javaMailSender.createMimeMessage(); //�ʼ���Ϣ��
		MimeMessageHelper smm = new MimeMessageHelper(mm);
		try {
			smm.setFrom("18173414165@163.com"); //�ʼ�������
			smm.setTo("1274421194@qq.com"); //�ʼ�������
			smm.setSubject("Sping�ʼ����ϲ���03��������������"); //�ʼ�����
			smm.setText("��ã�����spring�ʼ�����<br>"
					+ "<a href='http://www.baidu.com'>����ٶ�</a><br>"
					+"<img src='cid:pic123'/>",true); //�ʼ�����
			
			FileSystemResource fsr = new FileSystemResource("E:\04.jpg"); //�����ļ�ϵͳ��Դ
			smm.addInline("pic123", fsr); //������Id���ļ�ϵͳ��Դ��
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		javaMailSender.send(mm); //�����ʼ�
		System.out.println("�ʼ����ͳɹ�������");
	}

}
