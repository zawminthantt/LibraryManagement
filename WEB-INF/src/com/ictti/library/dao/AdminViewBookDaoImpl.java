package com.ictti.library.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.library.business.entity.ViewMemberInfo;
import com.ictti.library.business.entity.ViewMostRentBook;

public class AdminViewBookDaoImpl extends HibernateDaoSupport implements
		AdminViewBookDao {
	public List<ViewMostRentBook> getByBookId(String categoryName) {
		String hql = "from ViewMostRentBook i where i.categoryName like ?  ORDER BY rentTimes DESC";
		List<ViewMostRentBook> l = getHibernateTemplate().find(hql, categoryName);
		return l.isEmpty() || l == null ? null : l;
	}
	public List<ViewMostRentBook> getByBookIdAll() {
		String hql = "from ViewMostRentBook i ORDER BY rentTimes DESC";
		List<ViewMostRentBook> l = getHibernateTemplate().find(hql);
		return l.isEmpty() || l == null ? null : l;
	}
	
}
