package com.mitrais.rms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="para_skill")
public class Skill 
{
	@Id
	@Column(name="skill_id")
	private int skillId; 	
	
	@Column(name="skill_name")
	private String skillName; 
	
	@Column(name="skill_desc")
	private String skillDesc;
	
	@Column(name="skill_status")
	private int skillStatus;	

	@ManyToMany(
			fetch=FetchType.LAZY,
			cascade= {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH}
			)
	@JoinTable(
			name="empl_assigned_skill",
			joinColumns=@JoinColumn(name="skill_id"),
			inverseJoinColumns=@JoinColumn(name="employee_id")
			)
	private List<Employee> employees;
	
	public Skill(int skillId, String skillName, String skillDesc, int skillStatus) 
	{
		this.skillId = skillId;
		this.skillName = skillName;
		this.skillDesc = skillDesc;
		this.skillStatus = skillStatus;
	}

	public Skill()
	{
		
	}
	public int getSkillId() 
	{
		return skillId;
	}

	public void setSkillId(int skillId) 
	{
		this.skillId = skillId;
	}

	public String getSkillName() 
	{
		return skillName;
	}

	public void setSkillName(String skillName)
	{
		this.skillName = skillName;
	}

	public String getSkillDesc() 
	{
		return skillDesc;
	}

	public void setSkillDesc(String skillDesc) 
	{
		this.skillDesc = skillDesc;
	}

	public int getSkillStatus() 
	{
		return skillStatus;
	}

	public void setSkillStatus(int skillStatus) 
	{
		this.skillStatus = skillStatus;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public void addEmployees(Employee employee)
	{
		if(employees==null) 
		{
			employees = new ArrayList<Employee>();
		}
		employees.add(employee);
	}
	
	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", skillName=" + skillName + ", skillDesc=" + skillDesc + ", skillStatus="
				+ skillStatus + "]";
	}
	
	
}
