package com.ictti.library.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.library.business.entity.ViewDetailBook;

public class ViewDetailBookDaoImpl extends HibernateDaoSupport implements ViewDetailBookDao {

	
	 public List<ViewDetailBook> getBookInfoByIsbnNo(String isbn){
		 String hql="from ViewDetailBook v where v.isbn=? and v.status<>0 and v.status<>2 and v.status<>3";
		 List<ViewDetailBook> l=getHibernateTemplate().find(hql,isbn);
		 return l.isEmpty() || l==null?null:l; 
	 }
	 public ViewDetailBook getBookIdbyCallCode(String c_code){
		 String hql="from ViewDetailBook v where v.callNumberCode=?";
		 List<ViewDetailBook> l=getHibernateTemplate().find(hql,c_code);
		 System.out.println("In View Detail Book Dao Impl= "+l.size());
		 return l.isEmpty() || l==null?null:l.get(0);
	 }
	 
	 //for new Check out Book
	 
	 public ViewDetailBook getBookInfoByIsbn(String isbn){
		 String hql="from ViewDetailBook v where v.isbn=?";
		 List<ViewDetailBook> l=getHibernateTemplate().find(hql,isbn);
		 return l.isEmpty() || l==null?null:l.get(0);
	 }
	 
	 public List<ViewDetailBook> getCallNumberList(int book_id){
		 String hql="from ViewDetailBook v where v.bookId=? and v.status=1";
		 List<ViewDetailBook> l=getHibernateTemplate().find(hql,book_id);
		 System.out.println("In getCallNumberList in View DetailBook Dao Impl = "+l.size());
		 return l.isEmpty() || l==null?null:l;
	 }
}