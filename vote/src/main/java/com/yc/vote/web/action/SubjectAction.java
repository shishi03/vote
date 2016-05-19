package com.yc.vote.web.action;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.yc.vote.entity.AddSubjectBean;
import com.yc.vote.service.SubjectService;

@Controller("subjectAction")  //���bean
public class SubjectAction implements ModelDriven<AddSubjectBean>{

	private AddSubjectBean addSubjectBean;
	
	@Autowired
	private SubjectService subjectService;
	
	public String save(){
		LogManager.getLogger().debug("SubjectActionȡ���Ĳ�������=="+addSubjectBean);
		try {
			subjectService.add(addSubjectBean);
			return "addSuccess";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "addFail";
	}

	public AddSubjectBean getModel() {
		addSubjectBean = new AddSubjectBean();
		return addSubjectBean;
	}
}
