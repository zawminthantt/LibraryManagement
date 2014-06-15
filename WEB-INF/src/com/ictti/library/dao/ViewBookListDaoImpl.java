package com.ictti.library.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.library.business.entity.CallNumber;
import com.ictti.library.business.entity.ViewDetailBook;

public class ViewBookListDaoImpl extends HibernateDaoSupport implements ViewBookListDao  {

	@Override
	public ViewDetailBook getBookListById(Integer id) {
		
		// TODO Auto-generated method stub
		
			String hql="from ViewDetailBook v where v.bookId=? ";
			List<ViewDetailBook> l=getHibernateTemplate().find(hql,id);
			return l.isEmpty() || l==null ? null :l.get(0);
	}
	public List<ViewDetailBook> getBookInfo(int callnumber){
		String hql="from ViewDetailBook v where v.id=?";
		List<ViewDetailBook> l=getHibernateTemplate().find(hql,callnumber);
		return l.isEmpty() || l==null?null:l;
	}
}
