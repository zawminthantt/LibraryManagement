package com.ictti.library.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.library.business.entity.UserType;

public class UserTypeDaoImpl extends HibernateDaoSupport implements UserTypeDao {

	@Override
	public List<UserType> getAllUserType() {
		List l = getHibernateTemplate().find("from UserType");
		return l.isEmpty() || l == null ? null : l;
	}

	@Override
	public UserType getUserTypeById(Integer id) {
		List l = getHibernateTemplate()
				.find("from UserType i where i.id=?", id);
		return l.isEmpty() || l == null ? null : (UserType) l.get(0);
	}

}
