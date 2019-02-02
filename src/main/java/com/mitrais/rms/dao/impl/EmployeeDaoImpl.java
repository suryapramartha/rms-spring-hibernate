package com.mitrais.rms.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mitrais.rms.dao.EmployeeDao;
import com.mitrais.rms.model.Employee;
import com.mitrais.rms.model.EmployeeCompetency;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Optional<Employee> find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAll() 
	{
		List<Employee> emplList = null;
		Session session = sessionFactory.getCurrentSession();
		emplList = session.createQuery("from Employee").getResultList();
		return emplList;
	}

	@Override
	public boolean save(Employee o) 
	{
		int newId = getNewId();
		o.setEmplId(newId);
		Session session = sessionFactory.getCurrentSession();
		session.persist(o);
		logger.info("Employee saved successfully, Employee Details="+o);
		return true;
	}

	@Override
	public boolean update(Employee o) 
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.update(o);
		logger.info("Employee updated successfully, Employee Details="+o);
		return true;
	}

	@Override
	public boolean delete(Employee o) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(String id) 
	{
		Session session = this.sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.load(Employee.class, new Integer(id));
		if(employee != null)
		{
			session.delete(employee);
		}
		logger.info("Employee deleted successfully, Employee Details="+employee);
		return true;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public int getNewId() 
	{
		int id = 0;
    	int idCore = 10000;
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "Select MAX(emplId) as emplId From Employee";
		Query query = session.createQuery(hql);
	    id = (Integer) query.uniqueResult();
		if (id == 0) 
	    {
			return idCore+1;
	    }else 
	    {
	      	return id+1;
	    }
	}
	
	@SuppressWarnings({"unchecked", "deprecation" })
	@Override
	public List<Employee> getSelectedEmployeeById(String id) 
	{
		List<Employee> emplList = null;
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Employee where emplId = :employee_id";
		emplList = session.createQuery(hql).setString("employee_id", id).getResultList();
		for(Employee p : emplList)
		{
			logger.info("Employee List::"+p);
		}
		return emplList;
	}

	@Override
	public boolean insertNewCompetency(EmployeeCompetency cp) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(cp);
		logger.info("Competency saved successfully, Details="+cp);
		return true;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean deleteEmployeeCompetency(String skillId, String emplId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from EmployeeCompetency where skillId = :skill_id and emplId = :empl_id";
		session.createQuery(hql).setString("skill_id",skillId).setString("empl_id", emplId).executeUpdate();
		return true;
	}

}
