package com.mitrais.rms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empl_assigned_skill")
public class EmployeeCompetency implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="empl_id")
	private int emplId;
	
	@Id
	@Column(name="skill_id")
	private int skillId;

	public EmployeeCompetency(int emplId, int skillId) {
		this.emplId = emplId;
		this.skillId = skillId;
	}
	
	public EmployeeCompetency() 
	{
		
	}

	public int getEmplId() {
		return emplId;
	}

	public void setEmplId(int emplId) {
		this.emplId = emplId;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	@Override
	public String toString() {
		return "EmployeeCompetency [emplId=" + emplId + ", skillId=" + skillId + "]";
	}
	
	
}
