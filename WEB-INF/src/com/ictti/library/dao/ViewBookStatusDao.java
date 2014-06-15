package com.ictti.library.dao;

import java.util.List;

import com.ictti.library.business.entity.ViewBookOnloan;
import com.ictti.library.business.entity.ViewBookReserve;

public interface ViewBookStatusDao {
	public ViewBookOnloan checkByOnLoan(String bookonloan);
	public ViewBookOnloan checkByOnLoanStatus(String bookonloan);
	
	public ViewBookReserve checkByBookReserve(String bookreserve);

	public ViewBookOnloan checkByCallNumber(String frmRegCallNumber);


}
