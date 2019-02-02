package com.mitrais.rms.dao;

import java.util.List;

import com.mitrais.rms.model.Employee;
import com.mitrais.rms.model.EmployeeCompetency;


public interface EmployeeDao extends Dao<Employee, Integer> 
{
	boolean deleteById(String id);
	int getNewId();
	List<Employee> getSelectedEmployeeById(String id);
	boolean insertNewCompetency(EmployeeCompetency cp);
	boolean deleteEmployeeCompetency(String skillId,String emplId);
}
