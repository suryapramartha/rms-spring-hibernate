package com.mitrais.rms.service;

import java.util.List;

import com.mitrais.rms.model.Skill;

public interface SkillService
{
	 List<Skill> getAllSkill();
	 boolean deleteById(String id);
	 boolean createSkill(Skill o);
	 boolean updateSkill(Skill o);
	 List<Skill> getSelectedSkillById(String id);
	 List<Skill> getNotAssignedSkill(String id);
	 List<Skill> getAssignedSkill(String id);

}
