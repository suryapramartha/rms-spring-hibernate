package com.mitrais.rms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mitrais.rms.dao.SkillDao;
import com.mitrais.rms.model.Skill;
import com.mitrais.rms.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService 
{
	
	@Autowired
	private SkillDao skillDao;
	
	@Override
	@Transactional
	public List<Skill> getAllSkill()
	{
		return skillDao.findAll();
	}

	@Override
	@Transactional
	public boolean deleteById(String id)
	{
		return skillDao.deleteById(id);
	}

	@Override
	@Transactional
	public boolean createSkill(Skill o) 
	{
		return skillDao.save(o);
	}

	@Override
	@Transactional
	public boolean updateSkill(Skill o) 
	{
		return skillDao.update(o);
	}

	@Override
	@Transactional
	public List<Skill> getSelectedSkillById(String id) 
	{
		return skillDao.getSelectedSkillById(id);
	}

	@Override
	@Transactional
	public List<Skill> getNotAssignedSkill(String id) 
	{
		return skillDao.getNotAssignedSkill(id);
	}

	@Override
	@Transactional
	public List<Skill> getAssignedSkill(String id) {
		return skillDao.getAssignedSkill(id);

	}
}
