package com.ictti.library.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.library.business.entity.BookOnLoan;
import com.ictti.library.business.entity.BookReserve;
import com.ictti.library.presentation.form.UserForm;

public class BookOnLoanDaoImpl extends HibernateDaoSupport implements BookOnLoanDao {

	@Override
	
	 public List<BookOnLoan> getEarilestDateByCallNumber(Integer cno){
		 String hql="from BookOnLoan b where b.callnumber.id=? and b.loanStatus=0 ";
		 List<BookOnLoan>l=getHibernateTemplate().find(hql,cno);
		 System.out.println("In BookOnLoanDaoImpl" + l.size());
			return l.isEmpty() || l==null?null:l;
	 }
	public List<BookOnLoan> getUserById(Integer usr_id){
		String hql="from BookOnLoan b where b.user.id=?";
		List<BookOnLoan>l=getHibernateTemplate().find(hql,usr_id);
		return l.isEmpty()||l==null?null:l;
	}
	public BookOnLoan getBookLoanId(int id){
		String hql="from BookOnLoan b where b.id=?";
		List<BookOnLoan>l=getHibernateTemplate().find(hql,id);
		return l.isEmpty()||l==null?null:l.get(0);
		
	}
	public void saveRenew(BookOnLoan myBookOnLoan){
					getHibernateTemplate().saveOrUpdate(myBookOnLoan);
				System.out.println("In DataBase Saving!!!!!!");
	}
	
	//For Check In
	public void saveCheckinInfo(BookOnLoan myBookOnLoan){
		getHibernateTemplate().saveOrUpdate(myBookOnLoan);
		System.out.println("In DataBase Saving bookLoan Info!!!!!!");
	}
	
	//For Check Out
	public BookOnLoan getLoanStatusById(int usr_id){
		String hql="from BookOnLoan b where b.user.id=? and b.loanStatus=0 ";
		List<BookOnLoan> l=getHibernateTemplate().find(hql,usr_id);
		System.out.println("In BookOnLoan Dao Impl:"+l.size());
		return l.isEmpty()||l==null?null:l.get(0);
	}
	
	public void saveCheckOutInfo(BookOnLoan myBookOnLoan){
		getHibernateTemplate().saveOrUpdate(myBookOnLoan);
		System.out.println("In DataBase Saving bookLoan Info for Check Out!!!!!!");
	}


	
	


}
