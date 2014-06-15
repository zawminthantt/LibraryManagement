package com.ictti.library.dao;

import java.util.List;

import com.ictti.library.business.entity.ViewMemberInfo;

public interface AdminViewMemberInfoDao {
	public List<ViewMemberInfo> getByUserTypeName(String userTypeName);

	public List<ViewMemberInfo> getUserByLoanCount(String userTypeName);
}
