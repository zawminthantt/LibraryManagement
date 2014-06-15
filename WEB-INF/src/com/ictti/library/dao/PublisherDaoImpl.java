package com.ictti.library.dao;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.library.business.entity.Author;
import com.ictti.library.business.entity.BookList;
import com.ictti.library.business.entity.Publisher;

public class PublisherDaoImpl extends HibernateDaoSupport implements
		PublisherDao {

	@Override
	//to test publisher name show save button page
	public Publisher getByPulisherName(String pubName) {
		String hql="from Publisher p where p.pubName like ? ";
		List<Publisher> l=	getHibernateTemplate().find(hql,pubName+"%");
		return l.isEmpty() || l==null ? null :l.get(0);
	}
	
	public Publisher getByPulisherName(Integer pubName) {
		String hql="from Publisher p where p.pubName like ?";
		List<Publisher> l=	getHibernateTemplate().find(hql,pubName+"%");
		return l.isEmpty() || l==null ? null :l.get(0);
	}
	
	//for Book registration option collection
	public List<Publisher> getAllPublisher()
	{
		String hql="from Publisher order by pubName asc";
		List l = getHibernateTemplate().find(hql);
		return l.isEmpty() || l == null ? null : l;
		
	}
	@Override
	public Publisher getPublisherById(Integer PubId) {
		// TODO Auto-generated method stub
		List l=getHibernateTemplate().find("from Publisher i where i.id=?",PubId);
		System.out.println("This is publisher Dao Impl for book registration"+l.size());
	       return l.isEmpty() || l==null ? null : (Publisher) l.get(0);
	}
	
	public void savePublisher(Publisher myPublisher)
	
	{
		getHibernateTemplate().saveOrUpdate(myPublisher);
	}
	public Publisher checkPublisher(String publisherName)
	{
		String hql="from Publisher i where i.pubName=?";
		List l=getHibernateTemplate().find(hql,publisherName);
		System.out.println("This is testing for book register for publisher name dao impl"+l.size());
		System.out.println("This is testing for book register for publisher name dao impl"+l);
		return (Publisher) (l.isEmpty() || l==null ? null :l.get(0));
	}
	}
	