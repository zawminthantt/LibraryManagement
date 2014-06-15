package com.ictti.library.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.library.business.entity.ViewMemberInfo;

public class AdminViewMemberInfoDaoImpl extends HibernateDaoSupport implements
		AdminViewMemberInfoDao {
	public List<ViewMemberInfo> getByUserTypeName(String userTypeName) {
		String hql = "from ViewMemberInfo i where i.userTypeName like ?  ORDER BY userName DESC";
		List<ViewMemberInfo> l = getHibernateTemplate().find(hql, userTypeName);
		return l.isEmpty() || l == null ? null : l;
	}
	public List<ViewMemberInfo> getUserByLoanCount(String userTypeName) {
		String hql = "from ViewMemberInfo i where i.userTypeName=? and i.userStatus=1 order by rentCount Desc)";
		List<ViewMemberInfo> l = getHibernateTemplate().find(hql,userTypeName);
		return l.isEmpty() || l == null ? null : l;
	}
}
