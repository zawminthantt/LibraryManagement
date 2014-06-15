package com.ictti.library.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.library.business.entity.BookList;
import com.ictti.library.business.entity.ViewBookOnloan;
import com.ictti.library.business.entity.ViewBookReserve;

public class ViewBookStatusDaoImpl extends HibernateDaoSupport implements ViewBookStatusDao {
	

	@Override
	public ViewBookOnloan checkByOnLoan(String bookonloan) {
		String hql="from ViewBookOnloan i where i.callnumbercode=?";
		List l=getHibernateTemplate().find(hql,bookonloan);
		return l.isEmpty() || l==null ? null: (ViewBookOnloan) l.get(0);
	}
	public ViewBookOnloan checkByOnLoanStatus(String bookonloan) {
		String hql="from ViewBookOnloan i where i.callnumbercode=? and i.loanstatus=0";
		List l=getHibernateTemplate().find(hql,bookonloan);
		return l.isEmpty() || l==null ? null: (ViewBookOnloan) l.get(0);
	}


	@Override
	public ViewBookReserve checkByBookReserve(String bookreserve) {
		String hql="from ViewBookReserve i where i.callnumbercode=?";
		List l=getHibernateTemplate().find(hql,bookreserve);
		return l.isEmpty() || l==null ? null:(ViewBookReserve) l.get(0);
	}
	
	public ViewBookOnloan checkByCallNumber(String frmRegCallNumber)
	{
		String hql="from ViewBookOnloan i where i.callnumbercode=?";
		List<ViewBookOnloan> l=getHibernateTemplate().find(hql,frmRegCallNumber);
		System.out.println("list size:" + l.size());
		return l.isEmpty() || l==null ? null: (ViewBookOnloan) l.get(0);
	}


}
