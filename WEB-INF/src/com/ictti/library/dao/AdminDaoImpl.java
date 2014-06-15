package com.ictti.library.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.ictti.library.business.entity.Admin;
import com.ictti.library.business.entity.User;

public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao{

	@Override
	public Admin getAdminByLoginAndPassword(String strLoginName, String strPassword) {
		// TODO Auto-generated method stub
		String hql="from Admin i where i.name=? and i.password=?";
		Object[] parm={strLoginName,strPassword};
		List l=getHibernateTemplate().find(hql,parm);
		return l.isEmpty() || l==null ? null : (Admin) l.get(0);
	}

	@Override
	public Admin getAdminByAccountName(String frmLoginName) {
		// TODO Auto-generated method stub
		String hql="from Admin i where i.name=?";
		List l =getHibernateTemplate().find(hql,frmLoginName); 
		  return l.isEmpty() || l ==null ? null : (Admin) l.get(0); 
	}

	
}
