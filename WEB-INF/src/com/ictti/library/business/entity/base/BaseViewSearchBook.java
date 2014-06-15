package com.ictti.library.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the view_search_book table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="view_search_book"
 */

public abstract class BaseViewSearchBook  implements Serializable {

	public static String REF = "ViewSearchBook";
	public static String PROP_SUB_CATEGORY_ID = "subCategoryId";
	public static String PROP_AUTHOR_INIT_NAME = "authorInitName";
	public static String PROP_CATEGORY_NAME = "categoryName";
	public static String PROP_PUBLISHER_NAME = "publisherName";
	public static String PROP_AUTHOR_ID = "authorId";
	public static String PROP_PHOTO_ID = "photoId";
	public static String PROP_NOOFCOPIES = "noofcopies";
	public static String PROP_TITLE = "title";
	public static String PROP_PHOTO_DATA = "photoData";
	public static String PROP_YEAR = "year";
	public static String PROP_SUBCATEGORY_NAME = "subcategoryName";
	public static String PROP_CATEGORY_ID = "categoryId";
	public static String PROP_EDITION = "edition";
	public static String PROP_PRICE = "price";
	public static String PROP_AUTHOR_NAME = "authorName";
	public static String PROP_ID = "id";
	public static String PROP_PUBID = "pubid";
	public static String PROP_ISBN = "isbn";
	public static String PROP_REMARK = "remark";


	// constructors
	public BaseViewSearchBook () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseViewSearchBook (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String title;
	private java.lang.String isbn;
	private java.lang.String edition;
	private java.lang.Integer price;
	private java.util.Date year;
	private java.lang.Integer noofcopies;
	private java.lang.String remark;
	private java.lang.Integer pubid;
	private java.lang.String publisherName;
	private java.lang.Integer authorId;
	private java.lang.String authorName;
	private java.lang.String authorInitName;
	private java.lang.String categoryName;
	private java.lang.String subcategoryName;
	private java.lang.Integer categoryId;
	private java.lang.Integer subCategoryId;
	private java.lang.Integer photoId;
	private java.sql.Blob photoData;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="book_id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: title
	 */
	public java.lang.String getTitle () {
		return title;
	}

	/**
	 * Set the value related to the column: title
	 * @param title the title value
	 */
	public void setTitle (java.lang.String title) {
		this.title = title;
	}



	/**
	 * Return the value associated with the column: ISBN
	 */
	public java.lang.String getIsbn () {
		return isbn;
	}

	/**
	 * Set the value related to the column: ISBN
	 * @param isbn the ISBN value
	 */
	public void setIsbn (java.lang.String isbn) {
		this.isbn = isbn;
	}



	/**
	 * Return the value associated with the column: edition
	 */
	public java.lang.String getEdition () {
		return edition;
	}

	/**
	 * Set the value related to the column: edition
	 * @param edition the edition value
	 */
	public void setEdition (java.lang.String edition) {
		this.edition = edition;
	}



	/**
	 * Return the value associated with the column: price
	 */
	public java.lang.Integer getPrice () {
		return price;
	}

	/**
	 * Set the value related to the column: price
	 * @param price the price value
	 */
	public void setPrice (java.lang.Integer price) {
		this.price = price;
	}



	/**
	 * Return the value associated with the column: year
	 */
	public java.util.Date getYear () {
		return year;
	}

	/**
	 * Set the value related to the column: year
	 * @param year the year value
	 */
	public void setYear (java.util.Date year) {
		this.year = year;
	}



	/**
	 * Return the value associated with the column: noofcopies
	 */
	public java.lang.Integer getNoofcopies () {
		return noofcopies;
	}

	/**
	 * Set the value related to the column: noofcopies
	 * @param noofcopies the noofcopies value
	 */
	public void setNoofcopies (java.lang.Integer noofcopies) {
		this.noofcopies = noofcopies;
	}



	/**
	 * Return the value associated with the column: remark
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: remark
	 * @param remark the remark value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
	}



	/**
	 * Return the value associated with the column: pub_id
	 */
	public java.lang.Integer getPubid () {
		return pubid;
	}

	/**
	 * Set the value related to the column: pub_id
	 * @param pubid the pub_id value
	 */
	public void setPubid (java.lang.Integer pubid) {
		this.pubid = pubid;
	}



	/**
	 * Return the value associated with the column: publisherName
	 */
	public java.lang.String getPublisherName () {
		return publisherName;
	}

	/**
	 * Set the value related to the column: publisherName
	 * @param publisherName the publisherName value
	 */
	public void setPublisherName (java.lang.String publisherName) {
		this.publisherName = publisherName;
	}



	/**
	 * Return the value associated with the column: author_id
	 */
	public java.lang.Integer getAuthorId () {
		return authorId;
	}

	/**
	 * Set the value related to the column: author_id
	 * @param authorId the author_id value
	 */
	public void setAuthorId (java.lang.Integer authorId) {
		this.authorId = authorId;
	}



	/**
	 * Return the value associated with the column: author_name
	 */
	public java.lang.String getAuthorName () {
		return authorName;
	}

	/**
	 * Set the value related to the column: author_name
	 * @param authorName the author_name value
	 */
	public void setAuthorName (java.lang.String authorName) {
		this.authorName = authorName;
	}



	/**
	 * Return the value associated with the column: author_initial_name
	 */
	public java.lang.String getAuthorInitName () {
		return authorInitName;
	}

	/**
	 * Set the value related to the column: author_initial_name
	 * @param authorInitName the author_initial_name value
	 */
	public void setAuthorInitName (java.lang.String authorInitName) {
		this.authorInitName = authorInitName;
	}



	/**
	 * Return the value associated with the column: category_name
	 */
	public java.lang.String getCategoryName () {
		return categoryName;
	}

	/**
	 * Set the value related to the column: category_name
	 * @param categoryName the category_name value
	 */
	public void setCategoryName (java.lang.String categoryName) {
		this.categoryName = categoryName;
	}



	/**
	 * Return the value associated with the column: subcategory_name
	 */
	public java.lang.String getSubcategoryName () {
		return subcategoryName;
	}

	/**
	 * Set the value related to the column: subcategory_name
	 * @param subcategoryName the subcategory_name value
	 */
	public void setSubcategoryName (java.lang.String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}



	/**
	 * Return the value associated with the column: category_id
	 */
	public java.lang.Integer getCategoryId () {
		return categoryId;
	}

	/**
	 * Set the value related to the column: category_id
	 * @param categoryId the category_id value
	 */
	public void setCategoryId (java.lang.Integer categoryId) {
		this.categoryId = categoryId;
	}



	/**
	 * Return the value associated with the column: subcategory_id
	 */
	public java.lang.Integer getSubCategoryId () {
		return subCategoryId;
	}

	/**
	 * Set the value related to the column: subcategory_id
	 * @param subCategoryId the subcategory_id value
	 */
	public void setSubCategoryId (java.lang.Integer subCategoryId) {
		this.subCategoryId = subCategoryId;
	}



	/**
	 * Return the value associated with the column: photo_id
	 */
	public java.lang.Integer getPhotoId () {
		return photoId;
	}

	/**
	 * Set the value related to the column: photo_id
	 * @param photoId the photo_id value
	 */
	public void setPhotoId (java.lang.Integer photoId) {
		this.photoId = photoId;
	}



	/**
	 * Return the value associated with the column: photo_data
	 */
	public java.sql.Blob getPhotoData () {
		return photoData;
	}

	/**
	 * Set the value related to the column: photo_data
	 * @param photoData the photo_data value
	 */
	public void setPhotoData (java.sql.Blob photoData) {
		this.photoData = photoData;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.library.business.entity.ViewSearchBook)) return false;
		else {
			com.ictti.library.business.entity.ViewSearchBook viewSearchBook = (com.ictti.library.business.entity.ViewSearchBook) obj;
			if (null == this.getId() || null == viewSearchBook.getId()) return false;
			else return (this.getId().equals(viewSearchBook.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}