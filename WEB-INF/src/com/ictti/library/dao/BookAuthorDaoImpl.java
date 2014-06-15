package com.ictti.library.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.library.business.entity.BookAuthor;

public class BookAuthorDaoImpl extends HibernateDaoSupport implements BookAuthorDao {

	public void saveBookAuthor(BookAuthor bookAuthor)
	{
		getHibernateTemplate().saveOrUpdate(bookAuthor);
	}

}
