package com.ictti.library.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



import com.ictti.library.business.entity.BookList;
import com.ictti.library.business.entity.ViewBookOnloan;



public class BookListDaoImpl extends HibernateDaoSupport implements BookListDao
{
	public List<BookList> getBookListByTitle(String a_strTitle) {
		String hql="from BookList i where i.noOfCopy<>0 and i.title like '%" + a_strTitle+ "%'";
		List<BookList> l=getHibernateTemplate().find(hql);
		System.out.println("list size:" + l.size());
		return l.isEmpty() || l==null ? null :l;
	}
	public BookList getBookListById(int id)
	{
		 String hql="from BookList i where i.id=? ";
		List l=getHibernateTemplate().find(hql,id);
	       return l.isEmpty() || l==null ? null : (BookList) l.get(0);
	      
			
	}
	public List<BookList> getBookListAll() {
		  String hql="from BookList i";
		  List<BookList> l=getHibernateTemplate().find(hql);
		  return l.isEmpty() || l==null ? null :l;
		}
		
	public void saveNewBook(BookList book) {
		// TODO Auto-generated method stub
		System.out.println("This is testing for book save dao impl"+book.getOrgName());
		getHibernateTemplate().saveOrUpdate(book);
	}

	public BookList getByBookISBN(String isbn)
	{
		String hql="from BookList i where i.isbnNo=?";
		List l=getHibernateTemplate().find(hql,isbn);
		return l.isEmpty() || l==null ? null : (BookList) l.get(0);
		
	}
	
	//For Book Update
	//For search All(Category and Sub Category)
	public void saveBookInfo(BookList myBookList){
		getHibernateTemplate().saveOrUpdate(myBookList);
	}
	
	//For Book Delete
	public void saveChangeCopy(BookList myBook){
		getHibernateTemplate().saveOrUpdate(myBook);
	}



}