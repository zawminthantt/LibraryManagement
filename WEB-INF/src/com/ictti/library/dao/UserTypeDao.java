package com.ictti.library.dao;

import java.util.List;

import com.ictti.library.business.entity.UserType;

public interface UserTypeDao {
	public List<UserType> getAllUserType();

	public UserType getUserTypeById(Integer id);
}
