package com.mitrais.rms.dao;

import java.util.List;
import com.mitrais.rms.model.Skill;

public interface SkillDao extends Dao<Skill, Integer> {
	boolean deleteById(String id);
	int getNewId();
	List<Skill> getSelectedSkillById(String id);
	List<Skill> getNotAssignedSkill(String id);
	List<Skill> getAssignedSkill(String id);

}
