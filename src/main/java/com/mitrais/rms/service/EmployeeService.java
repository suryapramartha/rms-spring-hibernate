package com.mitrais.rms.service;

import java.util.List;

import com.mitrais.rms.model.Employee;
import com.mitrais.rms.model.EmployeeCompetency;

public interface EmployeeService 
{
	 List<Employee> getAllEmployee();
	 boolean deleteById(String id);
	 boolean createEmployee(Employee o);
	 boolean updateEmployee(Employee o);
	 List<Employee> getSelectedEmployeeById(String id);
	 boolean insertNewCompetency(EmployeeCompetency cp);
	 boolean deleteEmployeeCompetency(String skillId,String emplId);


}
