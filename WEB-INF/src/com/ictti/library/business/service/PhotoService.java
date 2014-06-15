package com.ictti.library.business.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import org.apache.struts.upload.FormFile;
import org.hibernate.Hibernate;



import com.ictti.library.business.entity.Photo;
import com.ictti.library.dao.PhotoDao;
import com.ictti.library.presentation.form.PhotoForm;

public class PhotoService {
	private PhotoDao myPhotoDao;

	public PhotoDao getMyPhotoDao() {
		return myPhotoDao;
	}

	public void setMyPhotoDao(PhotoDao myPhotoDao) {
		this.myPhotoDao = myPhotoDao;
	}

	public void loadAllPhoto(PhotoForm myForm) {
		// TODO Auto-generated method stub
		List<Photo> myPhotoList = myPhotoDao.getAllPhoto();
	       myForm.setFrmPhotoList(myPhotoList);
	       if (myPhotoList != null) {
	    	    myForm.setBegin(1);
	    	    myForm.setEnd(myPhotoList.size());
	    	  }
		
	}
	public void saveUploadPhoto(PhotoForm myForm){
	       FileOutputStream outputStream = null;
	       FormFile formFile = myForm.getFrmUploadPhoto();
	       Blob bfile;
	       try {
	              bfile = Hibernate.createBlob(formFile.getInputStream());
	              String fst=formFile.getFileName().trim();
	              Integer size=formFile.getFileSize();
	              Photo myPhoto=new Photo();
	              myPhoto.setId(null);
	              myPhoto.setPhotoName(fst);
	              myPhoto.setPhotoData(bfile);
	              //myFile.setFileType(formFile.getContentType());
	              myPhoto.setPhotoSize(size);
	              myPhoto.setPhotoType(formFile.getContentType());
	              myPhoto.setPhotoSize(size);
	              myPhotoDao.saveNewPhoto(myPhoto);
	              System.out.println("This is photo in service!"+myPhoto);
	       } catch (FileNotFoundException e) {
	              e.printStackTrace();
	       } catch (IOException e) {
	              e.printStackTrace();
	       }
	     }

}
