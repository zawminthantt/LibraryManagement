package com.ictti.library.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.library.business.entity.CallNumber;
import com.ictti.library.business.entity.ViewDetailBook;

public class CallNumberDaoImpl extends HibernateDaoSupport implements
		CallNumberDao {
	public List<CallNumber> getCallNumberByBookId(int id) {
		//String hql = "from CallNumber c where c.book.id=? and c.issuseStatus<>1";
		//String hql = "from CallNumber c where c.book.id=? and c.status=<>0";
		System.out.println("In callnumber daoImpl" + id);
		//String hql = "from CallNumber c where c.book.id=? and c.issuseStatus=0";
		String hql = "from CallNumber c where c.book.id=? and c.issuseStatus<>2 and c.issuseStatus<>3 ";
		//String hql = "from CallNumber c where c.book.id=?";
		List<CallNumber> l = getHibernateTemplate().find(hql, id);
		System.out.println("This is testing in call number daoimpl"+l.size());
		return l.isEmpty() || l == null ? null : l;
	}

	public CallNumber getCallNumberById(int id) {
		String hql = "from CallNumber c where c.id=?";
		List<CallNumber> l = getHibernateTemplate().find(hql, id);
		return l.isEmpty() || l == null ? null : l.get(0);
	}

	public void saveOrUpdate(CallNumber myCallNumber) {
		synchronized (this) {
			getHibernateTemplate().saveOrUpdate(myCallNumber);
		}
	}

	public CallNumber getCallNumberById(Integer id) {
		String hql = "from CallNumber c where c.id=?";
		List list = null;
		list = getHibernateTemplate().find(hql, id);
		return list != null && !list.isEmpty() ? (CallNumber) list.get(0)
				: null;
	}
	public CallNumber getCallNumberCodeByCallNumber(int callNo){
		String hql="from CallNumber c where c.id=?";
		List list=null;
		list=getHibernateTemplate().find(hql,callNo);
		return list != null && !list.isEmpty() ? (CallNumber) list.get(0)
				: null;
	}
	
	@Override
	//to book register
	public Integer getCallNumberCount() {
		String hql="from CallNumber c";
		List<CallNumber> list=getHibernateTemplate().find(hql);
		return list.isEmpty() || list==null ? null: list.size();
	}
	public void saveCallnumber(CallNumber myCallNumber)
	{
		getHibernateTemplate().saveOrUpdate(myCallNumber);
	}

	//For Check In
	public void saveCheckinCallInfo(CallNumber myCallNumber){
		getHibernateTemplate().saveOrUpdate(myCallNumber);
	}

	//For Book Update
	public List<CallNumber> getLastAccessionNo(){
		String hql="from CallNumber";
		List<CallNumber> l=getHibernateTemplate().find(hql);
		System.out.println("In CallNumberDao impl"+l.size());
		return l.isEmpty()||l==null?null:l;	
	}
	public void saveBookUpdateInfo(CallNumber myCallNo){
		getHibernateTemplate().saveOrUpdate(myCallNo);
	}
	
	//For Book Delete
	public void saveChangeStatus(CallNumber myCall){
		getHibernateTemplate().saveOrUpdate(myCall);
	}
	
	//For Check Out
	public CallNumber getCallNumberIDByCallNumberCode(String c_code){
		String hql="from CallNumber c where c.callNumberCode=?";
		List list = null;
		list = getHibernateTemplate().find(hql, c_code);
		System.out.println("In CallNumberDaoImpl"+list.size());
		return list != null && !list.isEmpty() ? (CallNumber) list.get(0): null;
		
	}
	public void saveIssuseStatus(CallNumber myCallNo){
		getHibernateTemplate().saveOrUpdate(myCallNo);
	}

	public List<CallNumber> getCallNumberList(String call_code){
		String hql="from CallNumber c where c.callNumberCode=? and c.issuseStatus<>1";
		List<CallNumber> l=getHibernateTemplate().find(hql,call_code);
		System.out.println("In getCallNumber List Dao Impl"+l.size());
		return l.isEmpty()||l==null?null:l;
	}
	public CallNumber checkCallCode(String callCode){
		String hql="from CallNumber c where c.callNumberCode=?";
		List<CallNumber> l=getHibernateTemplate().find(hql,callCode);
		System.out.println("In getCallNumber List Dao Impl"+l.size());
		return l.isEmpty()||l==null?null:l.get(0);
	}
	public CallNumber getCallStatus(String callCode){
		String hql="from CallNumber c where c.callNumberCode=? and c.issuseStatus=1";
		List<CallNumber> l=getHibernateTemplate().find(hql,callCode);
		System.out.println("In getCallNumber List Dao Impl"+l.size());
		return l.isEmpty()||l==null?null:l.get(0);
		
	}


   //change call number status by reserve 
	public void saveIssueStatusByReserve(CallNumber myCall){
		getHibernateTemplate().saveOrUpdate(myCall);
	}
	}



