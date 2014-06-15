package com.ictti.library.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.library.business.entity.BookReserve;

public class BookReserveDaoImpl extends HibernateDaoSupport implements
		BookReserveDao {

	public BookReserve getBookReserveByUserId(Integer id) {

		String hql = "from BookReserve b where b.user.id=?";
		List list = null;
		list = getHibernateTemplate().find(hql, id);
		return list != null && !list.isEmpty() ? (BookReserve) list.get(0)
				: null;

	}

	public List<BookReserve> findAll(Integer userId) {
		List<BookReserve> list;
		String hql = "from BookReserve v where v.user.id=? ";
		list = getHibernateTemplate().find(hql, userId);

		return list != null && !list.isEmpty() ? list : null;
	}

	public BookReserve getById(Integer Id) {
		Object[] param = new Object[] { Id };
		String hql = "from BookReserve v where v.id=? ";
		List list = null;
		list = getHibernateTemplate().find(hql, param);
		return list != null && !list.isEmpty() ? (BookReserve) list.get(0)
				: null;
	}

	public BookReserve getAllDataById(Integer bookReserveId) {
		String hql = "from BookReserve b where b.id=?";
		List list = null;
		list = getHibernateTemplate().find(hql, bookReserveId);
		return list != null && !list.isEmpty() ? (BookReserve) list.get(0)
				: null;

	}
  //for Reserve Service whether user is previously book-reserve or not?
	public BookReserve getUserById(int id) {

		String hql = "from BookReserve b where b.user.id=? and b.reserveStatus=0";
		// String
		// hql="from BookReserve b where b.user.id=? and b.reserveStatus=1";
		List<BookReserve> l = getHibernateTemplate().find(hql, id);
		return l.isEmpty() || l == null ? null : l.get(0);
	}

	/*
	 * public List<ViewDetailBook> getUserById(int id){ String
	 * hql="from ViewDetailBook b where b.BookList.id=?";
	 * List<ViewDetailBook>l=getHibernateTemplate().find(hql,id); return
	 * l.isEmpty() || l==null?null:l.get(0); }
	 */

	/*
	 * public void saveOrUpdate(BookReserve myBookReserve){
	 * getHibernateTemplate().saveOrUpdate(myBookReserve); }
	 */
/*	public BookReserve getStatus(Integer c_id) {
		String hql = "from BookReserve b where b.callnumber.id=? and b.reserveStatus=1";
		List<BookReserve> l = getHibernateTemplate().find(hql, c_id);
		System.out.println("in BookReserveDaoImpl to getStatus:"+l.size());
		return l.isEmpty() || l == null ? null : l.get(0);
	}*/

	public BookReserve getStatus(Integer c_id) {
		String hql = "from BookReserve b where b.callnumber.id=? ";
		List<BookReserve> l = getHibernateTemplate().find(hql,c_id);
		System.out.println("in BookReserveDaoImpl to getStatus:"+l.size());
		return l.isEmpty() || l == null ? null : l.get(0);
	}

	public void saveOrUpdate(BookReserve newBookReserve) {
		synchronized (this) {
			getHibernateTemplate().saveOrUpdate(newBookReserve);
		}
	}
	
	//For Check Out
	public BookReserve getReserveInfoByUserId(int user_id,int call_id){
		String hql="from BookReserve b where b.user.id=" + user_id +" and b.callnumber.id=" + call_id + " and b.reserveStatus=0 ";
		//Object[] param = {user_id,call_id};	/*param[0] = user_id;
		//param[1] = call_id;*/
		List<BookReserve> l=getHibernateTemplate().find(hql);
		//System.out.println("In BookReserve  info by user id and call id "+l.size());
		return l.isEmpty() ||l==null?null:l.get(0);
	}

	public BookReserve getReserveInfoByCallId(int call_id){
		String hql="from BookReserve b where b.callnumber.id=? and b.reserveStatus=0 ";
		
		List<BookReserve>l=getHibernateTemplate().find(hql,call_id);
		System.out.println("In BookReserve  info by user id and call id "+l.size());
		return l.isEmpty() ||l==null?null:l.get(0);
	}

	
	public BookReserve getReserveStatus(int usr_id, int call_id){
		//String hql="from BookReserve b where b.user.id=? and b.callnumber.id=? and b.reserveStatus=0";
		String hql="from BookReserve b where b.user.id=" + usr_id +" and b.callnumber.id=" + call_id + " and b.reserveStatus=0 ";
		/*Object[] param = new Object[2];
		param[0] = usr_id;
		param[1] = call_id;*/
		List<BookReserve> l=getHibernateTemplate().find(hql);
		return l.isEmpty() ||l==null?null:l.get(0);
	}

	public void saveReserveStatus(BookReserve myReserve){
		getHibernateTemplate().saveOrUpdate(myReserve);
	}
}