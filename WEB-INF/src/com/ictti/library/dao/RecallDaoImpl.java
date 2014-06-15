package com.ictti.library.dao;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.ictti.library.business.entity.ViewRecall;

public class RecallDaoImpl extends HibernateDaoSupport implements RecallDao {
	public List<ViewRecall> findAll(Date dueDate) {
		System.out.println("findAll of RecallDaoImpl");
		String hql = "from ViewRecall o where o.dueDate <= ?";
		List<ViewRecall> list = new ArrayList<ViewRecall>();
		list = getHibernateTemplate().find(hql, dueDate);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println("aaa" + list.get(i));
		}
		System.out.println("RecallDaoImpl..");
		return list;
	}

	public ViewRecall getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ViewRecall> findAll() {
		System.out.println("findAll of ViewrecallDaoImpl");
		String hql = "from ViewRecall o ";
		List<ViewRecall> list = new ArrayList<ViewRecall>();
		list = getHibernateTemplate().find(hql);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println("aaa" + list.get(i));
		}
		System.out.println("ViewrecallDaoImpl..");
		return list;
	}

	public List<ViewRecall> findAll(String st) {
		String hql = "from ViewRecall o where o.dueDate <= ?";
		List<ViewRecall> list = new ArrayList<ViewRecall>();
		// try {
		list = getHibernateTemplate().find(hql, st);
		return list;
	}
}