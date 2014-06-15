package com.ictti.library.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.library.business.entity.AccessionCode;

public class AccessionDaoImpl extends HibernateDaoSupport implements AccessionDao{
	
	//For Book Registration
	public AccessionCode getByAccessionCodeId(String acCode)
	{
		int sid=Integer.valueOf(acCode);
		String hql = "from AccessionCode a where a.id=?";
		List list = null;
		list = getHibernateTemplate().find(hql,sid);
		return list != null && !list.isEmpty() ? (AccessionCode) list.get(0):null;
	}
	//For Book Update
	public AccessionCode getAccessionCodeById(int accession_id){
		String hql="from AccessionCode a where a.id=?";
		List<AccessionCode> l=getHibernateTemplate().find(hql,accession_id);
		return l.isEmpty()||l==null?null:l.get(0);
		}

	


}
