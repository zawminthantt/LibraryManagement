package com.ictti.library.dao;

import com.ictti.library.business.entity.AccessionCode;

public interface AccessionDao {
	public AccessionCode getByAccessionCodeId(String acCode);
	//public List<AccessionCode> findAll();
	
	//For Book Update
	public AccessionCode getAccessionCodeById(int accession_id);


}
