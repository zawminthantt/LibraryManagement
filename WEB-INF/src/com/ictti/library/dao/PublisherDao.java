package com.ictti.library.dao;

import java.util.List;

import com.ictti.library.business.entity.Publisher;

public interface PublisherDao {
	//public Publisher findbyPublisherId(Integer PubId);

	public Publisher getByPulisherName(String pubName);
	//zmy
	public Publisher getByPulisherName(Integer pubName);
	

	public List<Publisher> getAllPublisher();

	public Publisher getPublisherById(Integer PubId);
	public void savePublisher(Publisher myPublisher);
	//
	public Publisher checkPublisher(String publisherName);
	

}
