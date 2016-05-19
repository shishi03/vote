package com.yc.vote.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.vote.entity.Item;
import com.yc.vote.entity.OptionBean;
import com.yc.vote.entity.Subject;
import com.yc.vote.entity.SubjectBean;
import com.yc.vote.entity.VoteBean;
import com.yc.vote.mapper.SubjectMapper;
import com.yc.vote.service.VoteService;

@Transactional
@Service("voteService")
public class VoteServiceImpl implements VoteService{

	@Autowired
	private SubjectMapper subjectMapper;
	
	public List<Subject> findAllSubjects() {
		return subjectMapper.getAllSubjects();
	}

	public List<SubjectBean> findAllSubjectBeans() {
		return subjectMapper.getAllSubjectBeans();
	}

	public OptionBean findOptionsByVsId(int vsId) {
		
		return subjectMapper.getOptionsByVsId(vsId);
	}

	public VoteBean findVoteBeanByVsId(int vsId) {
		return subjectMapper.getVoteBeanByVsId(vsId);
	}
	

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean saveVote(Item item) {
		try {
			subjectMapper.insertItem(item);
			return true;
		} catch (Exception e) {
			LogManager.getLogger().error("誘同払移。。。。。。",e);
			throw new RuntimeException("誘同払移。。。。。。",e);
		}
	}

	

	
}
