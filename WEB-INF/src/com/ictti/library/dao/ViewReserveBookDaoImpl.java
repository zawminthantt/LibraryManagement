package com.ictti.library.dao;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.library.business.entity.CallNumber;
import com.ictti.library.business.entity.ViewReserveBook;
import com.ictti.library.dao.ViewReserveBookDao;

public class ViewReserveBookDaoImpl extends HibernateDaoSupport implements
		ViewReserveBookDao {

	@Override
	public ViewReserveBook getById(Integer userId) {

		List l = getHibernateTemplate().find("from ViewReserveBook i where i.userId=?", userId);
		return l.isEmpty() || l == null ? null : (ViewReserveBook) l.get(0);

	}

	public List<ViewReserveBook> getByUserId(Integer userId) {
		String hql = "from ViewReserveBook i where i.userId=?  ORDER BY dueDate DESC";
		List<ViewReserveBook> l = getHibernateTemplate().find(hql, userId);
		return l.isEmpty() || l == null ? null : l;
	}

	/*
	 * @Override public List<ViewReserveBook> getBookListById(String
	 * bookReserveId) { List l =
	 * getHibernateTemplate().find("from ViewReserveBook i where i.bookReserveId=?"
	 * ); return l.isEmpty() || l == null ? null : l; }
	 * 
	 * 
	 * 
	 * @Override public List<ViewReserveBook> getBookListAll() { // TODO
	 * Auto-generated method stub return null; }
	 */
	public List<ViewReserveBook> getBookListAll() {
		String hql = "from ViewReserveBook i";
		List<ViewReserveBook> l = getHibernateTemplate().find(hql);
		return l.isEmpty() || l == null ? null : l;
	}

	public void updateBookReserve(CallNumber callNumberId){
		getHibernateTemplate().save(callNumberId);
	}
		
	//For Admin View Reservation
		public List<ViewReserveBook> getBookListByDate(Date myD1, Date myD2) {
			String strhql = "from ViewReserveBook vrb where vrb.reserveStatus=0 and vrb.reserveDate between ? and ?";
			Object[] param = new Object[2];
			param[0] = myD1;
			param[1] = myD2;
			List lst = getHibernateTemplate().find(strhql, param);
			return lst;

		}
		public List<ViewReserveBook> getBookInfoByIsbnNo(String isbn){
			String str="from ViewReserveBook vrb where vrb.isbn like ?";
			List l=getHibernateTemplate().find(str, isbn);
			return l;
		}







}
