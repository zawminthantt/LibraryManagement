package com.ictti.library.dao;

import java.util.List;

import com.ictti.library.business.entity.ViewMostRentBook;

public interface AdminViewBookDao {
	public List<ViewMostRentBook> getByBookId(String categoryName);
	public List<ViewMostRentBook> getByBookIdAll();
}
