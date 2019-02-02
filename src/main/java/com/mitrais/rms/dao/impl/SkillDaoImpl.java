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

import com.mitrais.rms.dao.SkillDao;
import com.mitrais.rms.model.Skill;

@Repository
public class SkillDaoImpl implements SkillDao 
{
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Optional<Skill> find(Integer id) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Skill> findAll() 
	{
		List<Skill> skillList = null;
		Session session = sessionFactory.getCurrentSession();
		skillList = session.createQuery("from Skill").getResultList();
		return skillList;
	}

	@Override
	public boolean save(Skill o) 
	{
		int newId = getNewId();
		o.setSkillId(newId);
		Session session = sessionFactory.getCurrentSession();
		session.persist(o);
		logger.info("Skill saved successfully, Skill Details="+o);
		return true;
	}

	@Override
	public boolean update(Skill o) 
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.update(o);
		logger.info("Skill updated successfully, Skill Details="+o);
		return true;
	}

	@Override
	public boolean delete(Skill o) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(String id) 
	{
		Session session = this.sessionFactory.getCurrentSession();
		Skill skill = (Skill) session.load(Skill.class, new Integer(id));
		if(skill != null)
		{
			session.delete(skill);
		}
		logger.info("Skill deleted successfully, Skill Details="+skill);
		return true;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int getNewId() 
	{
		int id = 0;
    	int idCore = 10;
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "Select MAX(skillId) as skillId From Skill";
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

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Skill> getSelectedSkillById(String id)
	{
		List<Skill> skillList = null;
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Skill where skillId = :skill_id";
		skillList = session.createQuery(hql).setString("skill_id", id).getResultList();
		for(Skill p : skillList)
		{
			logger.info("Skill List::"+p);
		}
		return skillList;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Skill> getNotAssignedSkill(String id) 
	{
		List<Skill> skillList = null;
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Skill where skillStatus=0 and skillId not in "
				+ "(select skillId from EmployeeCompetency where emplId = :employee_id)";
		skillList = session.createQuery(hql).setString("employee_id", id).getResultList();
		for(Skill p : skillList)
		{
			logger.info("Skill Not assigned for "+id+" List::"+p);
		}
		return skillList;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Skill> getAssignedSkill(String id) 
	{
		List<Skill> skillList = null;
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Skill where skillStatus=0 and skillId in "
				+ "(select skillId from EmployeeCompetency where emplId = :employee_id)";
		skillList = session.createQuery(hql).setString("employee_id", id).getResultList();
		for(Skill p : skillList)
		{
			logger.info("Skill assigned for "+id+" List::"+p);
		}
		return skillList;
	}

}
