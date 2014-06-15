package com.ictti.library.business.service;

import java.util.List;

import com.ictti.library.business.entity.Author;
import com.ictti.library.business.entity.Publisher;
import com.ictti.library.business.entity.ViewSearchBook;
import com.ictti.library.dao.PublisherDao;
import com.ictti.library.presentation.form.AdminForm;

public class PublisherService {
	private PublisherDao myPublisherDao;
	public PublisherDao getMyPublisherDao() {
		return myPublisherDao;
	}
	public void setMyPublisherDao(PublisherDao myPublisherDao) {
		this.myPublisherDao = myPublisherDao;
	}
	public void firstLoadPublisher(AdminForm myForm)
	{
		// TODO Auto-generated method stub
		myForm.setPublisherName("");
		myForm.setFrmPubAddress("");
		myForm.setFrmRegFormControl(null);
	}
	public void saveNewPublisher(AdminForm myForm) {
		// TODO Auto-generated method stub
		Publisher  myPublisher=new Publisher();
		String pubName=myForm.getPublisherName();
		if(pubName.trim().length()!=0)
		{
			
			System.out.println("To Check Publisher exit!!!");
			myPublisher=myPublisherDao.checkPublisher(myForm.getPublisherName());
			if(myPublisher==null)
			{
				myPublisher = new Publisher();
				myPublisher.setId(null);
				myPublisher.setPubName(myForm.getPublisherName());
				myPublisher.setPubAddress(myForm.getFrmPubAddress());
				
			}
			myPublisherDao.savePublisher(myPublisher);
			
		}
			
			System.out.println("No Duplicate publisher!!!!!!!!");
			
		
	}

}