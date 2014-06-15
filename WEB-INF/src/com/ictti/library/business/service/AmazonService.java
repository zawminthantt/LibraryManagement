package com.ictti.library.business.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Blob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts.upload.FormFile;
import org.hibernate.Hibernate;

import com.ictti.library.business.entity.AccessionCode;
import com.ictti.library.business.entity.Author;
import com.ictti.library.business.entity.BookAuthor;
import com.ictti.library.business.entity.BookList;
import com.ictti.library.business.entity.CallNumber;
import com.ictti.library.business.entity.Category;
import com.ictti.library.business.entity.Photo;
import com.ictti.library.business.entity.Publisher;
import com.ictti.library.business.entity.SubCategory;
import com.ictti.library.dao.AccessionDao;
import com.ictti.library.dao.AuthorDao;
import com.ictti.library.dao.BookAuthorDao;
import com.ictti.library.dao.BookListDao;
import com.ictti.library.dao.CallNumberDao;
import com.ictti.library.dao.CategoryDao;
import com.ictti.library.dao.PhotoDao;
import com.ictti.library.dao.PublisherDao;
import com.ictti.library.dao.SubCategoryDao;
import com.ictti.library.presentation.form.AmazonBeanForm;
import com.ictti.library.util.JsonRead;

public class AmazonService {
	private BookListDao myBookListDao;
	private CategoryDao myCategoryDao;
	private SubCategoryDao mySubCategoryDao;
	private AuthorDao myAuthorDao;
	private PhotoDao myPhotoDao;
	private PublisherDao myPublisherDao;
	private CallNumberDao myCallNumberDao;
	private AccessionDao myAccessionCodeDao;
	private BookAuthorDao myBookAuthorDao;

	public BookListDao getMyBookListDao() {
		return myBookListDao;
	}

	public void setMyBookListDao(BookListDao myBookListDao) {
		this.myBookListDao = myBookListDao;
	}

	public CategoryDao getMyCategoryDao() {
		return myCategoryDao;
	}

	public void setMyCategoryDao(CategoryDao myCategoryDao) {
		this.myCategoryDao = myCategoryDao;
	}

	public SubCategoryDao getMySubCategoryDao() {
		return mySubCategoryDao;
	}

	public void setMySubCategoryDao(SubCategoryDao mySubCategoryDao) {
		this.mySubCategoryDao = mySubCategoryDao;
	}

	public AuthorDao getMyAuthorDao() {
		return myAuthorDao;
	}

	public void setMyAuthorDao(AuthorDao myAuthorDao) {
		this.myAuthorDao = myAuthorDao;
	}

	public PhotoDao getMyPhotoDao() {
		return myPhotoDao;
	}

	public void setMyPhotoDao(PhotoDao myPhotoDao) {
		this.myPhotoDao = myPhotoDao;
	}

	public PublisherDao getMyPublisherDao() {
		return myPublisherDao;
	}

	public void setMyPublisherDao(PublisherDao myPublisherDao) {
		this.myPublisherDao = myPublisherDao;
	}

	public CallNumberDao getMyCallNumberDao() {
		return myCallNumberDao;
	}

	public void setMyCallNumberDao(CallNumberDao myCallNumberDao) {
		this.myCallNumberDao = myCallNumberDao;
	}

	public AccessionDao getMyAccessionCodeDao() {
		return myAccessionCodeDao;
	}

	public void setMyAccessionCodeDao(AccessionDao myAccessionCodeDao) {
		this.myAccessionCodeDao = myAccessionCodeDao;
	}

	public BookAuthorDao getMyBookAuthorDao() {
		return myBookAuthorDao;
	}

	public void setMyBookAuthorDao(BookAuthorDao myBookAuthorDao) {
		this.myBookAuthorDao = myBookAuthorDao;
	}

	public void getAmazonInformation(AmazonBeanForm myForm) {
		AmazonBeanForm bean = new AmazonBeanForm();
		java.net.URL url = null;
		StringBuffer xmlAmazon = new StringBuffer("");
		try {
			url = new URL(myForm.getBaseURL());
			// Connect to Amazon API
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					url.openStream(), "UTF-8"));
			// read XML response from Amazon
			String line = "";
			while ((line = reader.readLine()) != null) {
				xmlAmazon.append(line);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Convert XML to JSON and set necessary element to bean
		JsonRead jsonRead = new JsonRead();

		/*
		 * String courseCode=myForm.getFrmRegLoginName(); String[] temp; String
		 * delimiter = "-"; temp = courseCode.split(delimiter); String st=""; //
		 * for(int i =0; i < temp.length ; i++) st+=temp[0];
		 */

		bean = jsonRead.getJsonElement(xmlAmazon.toString());
		if (bean.getFrmFormControl().length() > 0) {
			myForm.setFrmRegISBN(bean.getFrmRegISBN());
			myForm.setFrmRegTitle(bean.getFrmRegTitle());
			myForm.setFrmRegAuthor1(bean.getFrmRegAuthor1());
			myForm.setFrmRegPublisher(bean.getFrmRegPublisher());
			myForm.setFrmRegPage(bean.getFrmRegPage());
			// For check amazon;
			String price = (bean.getFrmRegPrice());
			String delimiter = "\\$";
			String[] temp;
			temp = price.split(delimiter);
			String st = "";
			st += temp[1];
			myForm.setFrmRegPrice((st));
			// end
			myForm.setFrmRegDate(bean.getFrmRegDate());
			myForm.setFrmSize(bean.getFrmSize());
			myForm.setFrmPhotoPath(bean.getFrmPhotoPath());
			myForm.setFrmFormControl("data");
			myForm.setFrmErrorMsg(null);
		} else {
			myForm.setFrmFormControl(null);
			myForm.setFrmErrorMsg(bean.getFrmErrorMsg());
		}
	}

	public void saveNewAuthor(AmazonBeanForm myForm) {
		// TODO Auto-generated method stub
		System.out.println("This is trying to save author table");
		if (myForm.getFrmRegAuthor1().trim().length() != 0) {
			Author myAuthor = myAuthorDao.getAuthorByName(myForm
					.getFrmRegAuthor1());
			System.out
					.println("This is return from dao for author1" + myAuthor);
			if (myAuthor == null) {
				myAuthor = new Author();
				myAuthor.setAuthorName(myForm.getFrmRegAuthor1());
				myAuthor.setAuthorInitName(myForm.getFrmRegAuthor1().substring(
						0, 2));
				myAuthorDao.saveNewAuthor(myAuthor);
				System.out.println("Successfully save for book author1");
			}
		}

		/*
		 * if (myForm.getFrmRegAuthor2().trim().length() != 0) { Author myAuthor
		 * = myAuthorDao.getAuthorByName(myForm .getFrmRegAuthor2());
		 * System.out.println("This is return from dao for author2" + myAuthor);
		 * if (myAuthor == null) { myAuthor = new Author();
		 * myAuthor.setAuthorName(myForm.getFrmRegAuthor2());
		 * myAuthor.setAuthorInitName(myForm.getFrmRegAuthor2().substring(0,2));
		 * myAuthorDao.saveNewAuthor(myAuthor);
		 * System.out.println("Successfully save for book author2"); } }
		 * 
		 * if (myForm.getFrmRegAuthor3().trim().length() != 0) { Author myAuthor
		 * = myAuthorDao.getAuthorByName(myForm .getFrmRegAuthor3());
		 * System.out.println("This is return from dao for author3" + myAuthor);
		 * if (myAuthor == null) { myAuthor = new Author();
		 * myAuthor.setAuthorName(myForm.getFrmRegAuthor3());
		 * myAuthor.setAuthorInitName(myForm.getFrmRegAuthor3().substring(0,2));
		 * myAuthorDao.saveNewAuthor(myAuthor);
		 * System.out.println("Successfully save for book author3"); } }
		 */

	}

	public void saveNewPhoto(AmazonBeanForm myForm) {
		// TODO Auto-generated method stub
		FormFile formFile = myForm.getFrmUploadFile();
		System.out.println("MyFormFile is " + formFile);

		try {
			Blob bfile = Hibernate.createBlob(((FormFile) formFile)
					.getInputStream());
			String fst = formFile.getFileName().trim();
			Integer size = formFile.getFileSize();
			Photo myPhoto = new Photo();
			myPhoto.setId(null);
			myPhoto.setPhotoName(fst);
			myPhoto.setPhotoData(bfile);
			myPhoto.setPhotoType(formFile.getContentType());
			myPhoto.setPhotoSize(size);
			myPhoto.setBook(myForm.getBooklist());
			myPhotoDao.saveNewPhoto(myPhoto);
			myForm.setFrmFile(myPhoto);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void saveNewBook(AmazonBeanForm myForm) {
		// TODO Auto-generated method stub
		BookList myBook = new BookList();
		BookAuthor bookAuthor = new BookAuthor();// For BookAuthor
		Author author = new Author();// For Author;
		Author author1 = new Author();// For Author
		myBook.setId(null);
		// to save category ID
		Category category = myCategoryDao.getCategoryById(Integer
				.parseInt(myForm.getCategoryId()));
		myBook.setCategory(category);
		// to save sub_category ID
		SubCategory subcategory = mySubCategoryDao.getSubCategoryId(Integer
				.parseInt(myForm.getSubCategoryId()));
		myBook.setSubcategory(subcategory);
		System.out.println("Before Publisher");
		System.out.println("PublisherName is " + myForm.getFrmRegPublisher());

		// to save publisher ID
		Publisher pub = myPublisherDao.getByPulisherName(myForm
				.getFrmRegPublisher());
		System.out.println("This is return from publisher Dao Impl"
				+ pub.getPubName());
		myBook.setPub(pub);

		double price = Double.parseDouble(myForm.getFrmRegPrice());
		int p = (int) price;
		myBook.setRegisterDate(new Date());// to save book_register date
		myBook.setTitle(myForm.getFrmRegTitle());
		myBook.setIsbnNo(myForm.getFrmRegISBN());
		myBook.setEdition(myForm.getFrmRegEdition());
		myBook.setPrice(p);
		myBook.setRemark(myForm.getFrmRegRemark());

		// for year

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		Date date;

		try {
			date = formatter.parse(myForm.getFrmRegDate());

			myBook.setYear(date);// to save published date

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		myBook.setNoOfCopy(myForm.getFrmRegCopy());
		myBook.setNoOfPages(Integer.parseInt(myForm.getFrmRegPage()));

		/*
		 * // for photo's book registration to save Photo table FileOutputStream
		 * outputStream = null; FormFile formFile = myForm.getFrmUploadPhoto();
		 * Blob bfile; try { bfile =
		 * Hibernate.createBlob(formFile.getInputStream()); String fst =
		 * formFile.getFileName().trim(); Integer size = formFile.getFileSize();
		 * Photo myPhoto = new Photo(); myPhoto.setId(null);
		 * myPhoto.setPhotoName(fst); myPhoto.setPhotoData(bfile);
		 * myPhoto.setPhotoType(formFile.getContentType());
		 * myPhoto.setPhotoSize(size);
		 * 
		 * myPhotoDao.saveNewPhoto(myPhoto);
		 * System.out.println("This is photo in service!" + myPhoto); } catch
		 * (FileNotFoundException e) { e.printStackTrace(); } catch (IOException
		 * e) { e.printStackTrace(); } // to join photo table and book_list
		 * table with id
		 * 
		 * Photo myPhoto = myPhotoDao.getPhotoById(1); //
		 * myBook.setPhotoId(myPhoto);
		 */
		myBookListDao.saveNewBook(myBook);
		myForm.setBooklist(myBook);
		System.out.println("Successfully save to BookList Table!!!!");

		// Photo myPhoto = myPhotoDao.getPhotoById(null);
		// myBook.setPhotos((Set<Photo>) myBook);

		// To Save for book Author table
		author = myAuthorDao.getAuthorByName(myForm.getFrmRegAuthor1());
		bookAuthor.setId(null);
		bookAuthor.setAuthor(author);
		bookAuthor.setBook(myBook);
		// author1=author;
		myBookAuthorDao.saveBookAuthor(bookAuthor);
		System.out
				.println("Successfully save into Book Author Table(for author1)!!!");

		/*
		 * //For Second Author String strauthor=myForm.getFrmRegAuthor2();
		 * if(strauthor.trim().length()!=0) {
		 * System.out.println("Author 2 Exit"); author=
		 * myAuthorDao.getAuthorByName(myForm.getFrmRegAuthor2());
		 * bookAuthor.setId(null); bookAuthor.setAuthor(author);
		 * bookAuthor.setBook(myBook); //author1=author;
		 * myBookAuthorDao.saveBookAuthor(bookAuthor); System.out.println(
		 * "Successfully save into Book Author Table(For author2)!!!"); } //For
		 * Third Author String strauthor1=myForm.getFrmRegAuthor3();
		 * if(strauthor1.trim().length()!=0) {
		 * System.out.println("Author 3 Exit"); author=
		 * myAuthorDao.getAuthorByName(myForm.getFrmRegAuthor3());
		 * bookAuthor.setId(null); bookAuthor.setAuthor(author);
		 * bookAuthor.setBook(myBook); //author1=author;
		 * myBookAuthorDao.saveBookAuthor(bookAuthor); System.out.println(
		 * "Successfully save into Book Author Table(For author3)!!!"); }
		 */
		System.out
				.println("Successfully save to book author(totally three)!!!");

		AccessionCode acc = myAccessionCodeDao.getByAccessionCodeId("1");

		// To Save call_number Table
		Integer callnumberCount = myCallNumberDao.getCallNumberCount();
		if (myForm.getFrmRegCopy() != 0)

		{
			CallNumber myCallnumber = new CallNumber();

			for (int i = 0; i < myForm.getFrmRegCopy(); i++) {
				myCallnumber.setId(null);
				callnumberCount += 1;
				// For callNumber format of book registration
				String callnumber_format = myForm.getCategoryId() + "."
						+ myForm.getSubCategoryId() + "."
						+ myForm.getFrmRegAuthor1().substring(0, 2) + "."
						+ "ICT" + "-" + (callnumberCount);
				System.out.println("CallNumberFormat is " + callnumber_format);

				myCallnumber.setCallNumberCode(callnumber_format);// for
																	// CallNumberCode
				myCallnumber.setIssuseStatus(1);// for IssuseStatus
				myCallnumber.setAccessionNo(callnumberCount);// for AccessionNo
				myCallnumber.setBook(myBook);// for book id
				myCallnumber.setAuthor(author);// for author id
				myCallnumber.setAccession(acc);// for accession id
				myCallNumberDao.saveCallnumber(myCallnumber);

			}

			System.out.println("Successfully save into call_number Table!!!");

		}

	}

	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		List<Category> list = myCategoryDao.getAllCategory();
		System.out.println("This is category testing for book register service"
				+ list.size());
		return list.isEmpty() || list == null ? null : list;
	}

	public List<SubCategory> getBySubCategory(String categoryId) {
		List<SubCategory> l = mySubCategoryDao.getBySubcategory(categoryId);
		return l.isEmpty() || l == null ? null : l;
	}

	// to retrieve subcategory list with category id

	public List getBySubcategory(Integer categoryId) {
		System.out.println("****SubcategoryService#getBySubcategory;param="
				+ categoryId);
		List<SubCategory> list = mySubCategoryDao
				.getBySubcategorybyid(categoryId);
		return list;
	}

	public List<SubCategory> getBySubcategory(String categoryId) {
		List<SubCategory> l = mySubCategoryDao.getBySubcategory(categoryId);
		System.out
				.println("This is subcategory testing for book register service"
						+ l.size());
		return l.isEmpty() || l == null ? null : l;
	}

	// to retrieve subcategory list with category id
	// added 10/03getByCategorySubcategory
	public List getByCategorySubcategory(String categoryId, String subcategoryId) {
		System.out
				.println("$$$$$$$$SubcategoryService#getBySubcategory;paramcategoryid="
						+ categoryId + "paramsubcategoryid" + subcategoryId);

		List<SubCategory> list = getBySubcategory(Integer.parseInt(categoryId));
		List<SubCategory> templist = new ArrayList<SubCategory>();

		if (categoryId.length() == 0) {
			System.out.println("Category Id is null, so we insert default 1");
			categoryId = "1";

		}
		if (subcategoryId == null) {
			System.out.println("Category Id is null, so we insert default 1");
			subcategoryId = "8";
		}
		if (subcategoryId.length() == 0) {
			System.out
					.println("SubCategory Id is null, so we insert default 1");
			subcategoryId = "8";
		}

		int catid;
		try {
			catid = Integer.valueOf(categoryId);
		} catch (NumberFormatException e) {

			Category category = myCategoryDao.getByCategoryName(categoryId);
			catid = category.getId();
		}
		int subcatid = Integer.parseInt(subcategoryId);

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == subcatid) {
				templist.add(list.get(i));
			}
		}
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() != subcatid) {
				templist.add(list.get(i));
			}
		}
		return templist;
	}// end of getByCategorySubcategory

	public void savePublisher(AmazonBeanForm myForm) {
		// TODO Auto-generated method stub
		if (myForm.getFrmRegPublisher().trim().length() != 0) {
			System.out.println("Publisher Name is "
					+ myForm.getFrmRegPublisher());
			Publisher myPub = myPublisherDao.getByPulisherName(myForm
					.getFrmRegPublisher());
			if (myPub == null) {
				myPub = new Publisher();
				myPub.setId(null);
				myPub.setPubName(myForm.getFrmRegPublisher());
				myPublisherDao.savePublisher(myPub);
			}
		}

	}

	public BookList getByBookISBN(String isbn) {
		// TODO Auto-generated method stub
		return myBookListDao.getByBookISBN(isbn);
	}

}