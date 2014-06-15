package com.ictti.library.dao;

import com.ictti.library.business.entity.Admin;



public interface AdminDao {
	public Admin getAdminByLoginAndPassword(String strLoginName,String strPassword);

	public Admin getAdminByAccountName(String frmLoginName);
}
