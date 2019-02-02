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
@Table(name="para_employee")
public class Employee 
{
	@Id
	@Column(name="empl_id")
	private int emplId;
	
	@Column(name="empl_name")
	private String emplName;
	
	@Column(name="empl_status")
	private int emplStatus;
	
	@Column(name="empl_age")
	private int emplAge;
	
	@Column(name="empl_address")
	private String emplAddress;
	
	@ManyToMany(
			fetch=FetchType.LAZY,
			cascade= {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH}
			)
	@JoinTable(
			name="empl_assigned_skill",
			joinColumns=@JoinColumn(name="empl_id"),
			inverseJoinColumns=@JoinColumn(name="skill_id")
			)
	private List<Skill> skills;
	
	public Employee() {
		
	}
	public Employee(int emplId, String emplName, int emplAge,int emplStatus, String emplAddress) 
	{
		this.emplId = emplId;
		this.emplName = emplName;
		this.emplStatus = 0;
		this.emplAge = emplAge;
		this.emplAddress = emplAddress;
	}

	public int getEmplId() 
	{
		return emplId;
	}

	public void setEmplId(int emplId)
	{
		this.emplId = emplId;
	}

	public String getEmplName() {
		return emplName;
	}

	public void setEmplName(String emplName) 
	{
		this.emplName = emplName;
	}

	public int getEmplStatus() 
	{
		return emplStatus;
	}

	public void setEmplStatus(int emplStatus) 
	{
		this.emplStatus = emplStatus;
	}

	public int getEmplAge()
	{
		return emplAge;
	}

	public void setEmplAge(int emplAge)
	{
		this.emplAge = emplAge;
	}

	public String getEmplAddress()
	{
		return emplAddress;
	}

	public void setEmplAddress(String emplAddress)
	{
		this.emplAddress = emplAddress;
	}
	
	public List<Skill> getSkills() {
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
	public void addSkills(Skill skill)
	{
		if(skills==null) 
		{
			skills = new ArrayList<Skill>();
		}
		skills.add(skill);
	}
	
	@Override
	public String toString() {
		return "Employee [emplId=" + emplId + ", emplName=" + emplName + ", emplStatus=" + emplStatus + ", emplAge="
				+ emplAge + ", emplAddress=" + emplAddress + "]";
	}
	
	
}
