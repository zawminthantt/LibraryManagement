package com.ictti.library.dao;

import com.ictti.library.business.entity.User;

public interface UserDao {
	public User getUserByLoginNameAndPassword(String strName,
			String strPassword);

	public User getUserByAccountName(String loginName);

	public void saveUser(User usr);
	public User getUserById(int id);

	//For Update Book
	public User getExpiredDatebyUserType(String usr_name);

	/*public User getStudentByAccountName(String accountName);

	public void saveStudent(User stu);*/
	
	//For View Member Info
	public User getUserId(int userId);

}
