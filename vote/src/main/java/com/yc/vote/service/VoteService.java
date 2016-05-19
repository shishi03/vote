package com.yc.vote.service;

import java.util.List;

import com.yc.vote.entity.Item;
import com.yc.vote.entity.OptionBean;
import com.yc.vote.entity.Subject;
import com.yc.vote.entity.SubjectBean;
import com.yc.vote.entity.VoteBean;

public interface VoteService {

	List<Subject> findAllSubjects();
	
	List<SubjectBean> findAllSubjectBeans();

	OptionBean findOptionsByVsId(int vsId);

	VoteBean findVoteBeanByVsId(int vsId);

	boolean saveVote(Item item);

	
}
