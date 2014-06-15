package com.ictti.library.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.library.business.entity.Admin;
import com.ictti.library.business.entity.Author;
public class AuthorDaoImpl extends HibernateDaoSupport implements AuthorDao
{
	public List<Author> getAuthorListByName(String strName) {
		String hql="from Author i where i.authorName like ?";
		List<Author> l=getHibernateTemplate().find(hql,strName+"%");
		return l.isEmpty() || l==null ? null :l;
	}
	public Author getAuthorByName(String autName)
	{
		String hql="from Author i where i.authorName=?";
		List l=getHibernateTemplate().find(hql,autName);
		System.out.println("This is testing for book register for author name dao impl"+l.size());
		System.out.println("This is testing for book register for author name dao impl"+l);
		return l.isEmpty() || l==null ? null : (Author) l.get(0);
	}
	public void saveNewAuthor(Author autName)
	{
		getHibernateTemplate().saveOrUpdate(autName);
		System.out.println("This is save for Author dao impl");
	}
	
	//For Book Update
	public Author getAuthorById(int author_id){
		String hql="from Author a where a.id=?";
		List<Author> l=getHibernateTemplate().find(hql,author_id);
		return l.isEmpty()||l==null?null:l.get(0);
	}


}
