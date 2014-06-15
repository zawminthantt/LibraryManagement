package com.ictti.library.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.library.business.entity.BookList;
import com.ictti.library.business.entity.Photo;

public class PhotoDaoImpl extends HibernateDaoSupport implements PhotoDao {
	public List<Photo> getAllPhoto(){
		String hql = "from Photo p";
		List<Photo> list = getHibernateTemplate().find(hql);
		System.out.println("This is dao for photo!");
		return list.isEmpty() || list == null ? null:list;
	}
	public void saveNewPhoto(Photo photo) {
		getHibernateTemplate().saveOrUpdate(photo);	
	}
	/*public Photo getPhotoById(Integer photoId) {
		String hql="from Photo p where p.id=?";
		List list = getHibernateTemplate().find(hql,photoId);
		return (Photo) (list.isEmpty() || list == null? null:list.get(0));
	}*/
	public Photo getPhotoById(Integer photoId) {
		String hql="from Photo p where p.id=?";
		List list = getHibernateTemplate().find(hql,photoId);
		 return list.isEmpty() || list==null ? null : (Photo) list.get(0);
	}
	
}
