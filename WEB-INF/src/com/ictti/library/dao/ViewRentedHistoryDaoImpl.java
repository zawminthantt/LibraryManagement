package com.ictti.library.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.library.business.entity.BookOnLoan;
import com.ictti.library.business.entity.ViewDetailBook;
import com.ictti.library.business.entity.ViewRentedHistory;

public class ViewRentedHistoryDaoImpl  extends HibernateDaoSupport implements ViewRentedHistoryDao {
	public List<ViewRentedHistory> getUserById(Integer usr_id){
		String hql="from ViewRentedHistory v where v.userId=? order by dueDate desc";
		List<ViewRentedHistory>l=getHibernateTemplate().find(hql,usr_id);
		return l.isEmpty()||l==null?null:l;
	}
	public ViewRentedHistory getCallNumberId(Integer id){
		String hql="from ViewRentedHistory v where v.returnDate=null and v.userId=? ";
		List<ViewRentedHistory>l=getHibernateTemplate().find(hql,id);
		return l.isEmpty()||l==null?null:l.get(0);
	}
	/*public List<ViewRentedHistory> getCallNumberId(){
		String hql="from ViewRentedHistory";
		List<ViewRentedHistory>l=getHibernateTemplate().find(hql);
		return l.isEmpty()||l==null?null:l;
	}
*/
	//For Check In
	public ViewRentedHistory getUserNameByCallNumber(String callCode){
		String hql="from ViewRentedHistory v where v.callNumber=? and v.returnDate=null";
		 List<ViewRentedHistory>l=getHibernateTemplate().find(hql,callCode);
		 return l.isEmpty()||l==null?null:l.get(0);
	 }
	

}

