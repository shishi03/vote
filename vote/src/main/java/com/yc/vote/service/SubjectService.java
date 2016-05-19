package com.yc.vote.service;

import com.yc.vote.entity.AddSubjectBean;
import com.yc.vote.entity.Option;

public interface SubjectService {

	public AddSubjectBean addSubject(AddSubjectBean addSubjectBean);
	
	public void addOption(Option option);
	
	void add(AddSubjectBean addSubjectBean);

}
