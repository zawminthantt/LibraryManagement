package com.ictti.library.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.library.business.entity.IcttiCourse;
import com.ictti.library.business.entity.User;


public class IcttiCourseDaoImpl extends HibernateDaoSupport implements  IcttiCourseDao {
	public IcttiCourse getExpireDateByCourseCode(String temp){		
		String hql="from IcttiCourse i where courseCode=?";
		 List l =getHibernateTemplate().find(hql, temp); 
		 System.out.println("Testing in database"+l.size());
		  return l.isEmpty() || l ==null ? null : (IcttiCourse) l.get(0);
	}

}
