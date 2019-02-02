package com.mitrais.rms.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mitrais.rms.dao.EmployeeDao;
import com.mitrais.rms.model.Employee;
import com.mitrais.rms.model.EmployeeCompetency;
import com.mitrais.rms.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	@Transactional
	public List<Employee> getAllEmployee() 
	{
		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public boolean deleteById(String id) 
	{
		return employeeDao.deleteById(id);
	}

	@Override
	@Transactional
	public boolean createEmployee(Employee o) 
	{
		return employeeDao.save(o);
	}

	@Override
	@Transactional
	public boolean updateEmployee(Employee o) 
	{
		return employeeDao.update(o);
	}

	@Override
	@Transactional
	public List<Employee> getSelectedEmployeeById(String id) {
		return employeeDao.getSelectedEmployeeById(id);
	}

	@Override
	@Transactional
	public boolean insertNewCompetency(EmployeeCompetency cp) {
		return employeeDao.insertNewCompetency(cp);
	}

	@Override
	@Transactional
	public boolean deleteEmployeeCompetency(String skillId, String emplId) {
		return employeeDao.deleteEmployeeCompetency(skillId, emplId);
	}
}
