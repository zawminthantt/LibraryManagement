package com.ictti.library.dao;

import java.util.List;

import com.ictti.library.business.entity.Author;



public interface AuthorDao {
	public List<Author> getAuthorListByName(String strName);

	public Author getAuthorByName(String autName);

	public void saveNewAuthor(Author autName);
	
	//For Book Update
	public Author getAuthorById(int author_id);

}
