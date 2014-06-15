package com.ictti.library.dao;

import java.util.List;


import com.ictti.library.business.entity.Photo;

public interface PhotoDao {

	Photo getPhotoById(Integer photoId);
	public void saveNewPhoto(Photo myPhoto);
	public List<Photo> getAllPhoto();
	
	
}
