package com.ictti.library.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.library.business.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public User getUserByLoginNameAndPassword(String strName, String strPassword) {
		String hql = "from User i where i.userLoginName=? and i.userPassword=?";
		Object[] parm = { strName, strPassword };
		List l = getHibernateTemplate().find(hql, parm);
		return l.isEmpty() || l == null ? null : (User) l.get(0);
	}

	@Override
	public User getUserByAccountName(String loginName) {
		String hql = "from User i where i.userLoginName=?";
		List l = getHibernateTemplate().find(hql, loginName);
		System.out.println("In Get User By Account Name Dao Impl="+l.size());
		return l.isEmpty() || l == null ? null : (User) l.get(0);
	}

	@Override
	public void saveUser(User stu) {
		getHibernateTemplate().saveOrUpdate(stu);
	}

	public User getUserById(int id) {
		String hql = "from User c where c.id=?";
		List<User> l = getHibernateTemplate().find(hql, id);
		return l.isEmpty() || l == null ? null : l.get(0);
	}

	// For Update Book
	public User getExpiredDatebyUserType(String usr_name) {
		System.out.println("Checking user name" + usr_name);
		String hql = "from User u where u.userLoginName=?";
		List<User> l = getHibernateTemplate().find(hql, usr_name);
		System.out.println("In user dao iMpl" + l.size());
		return l.isEmpty() || l == null ? null : l.get(0);
	}

	// For View Member Info
	public User getUserId(int userId) {
		String hql = "from User i where i.id=?";
		List l = getHibernateTemplate().find(hql, userId);
		return l.isEmpty() || l == null ? null : (User) l.get(0);
	}

}
