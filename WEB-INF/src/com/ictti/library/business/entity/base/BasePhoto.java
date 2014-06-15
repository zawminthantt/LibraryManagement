package com.ictti.library.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the photo table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="photo"
 */

public abstract class BasePhoto  implements Serializable {

	public static String REF = "Photo";
	public static String PROP_BOOK = "book";
	public static String PROP_PHOTO_DATA = "photoData";
	public static String PROP_PHOTO_NAME = "photoName";
	public static String PROP_ID = "id";
	public static String PROP_PHOTO_TYPE = "photoType";
	public static String PROP_PHOTO_SIZE = "photoSize";


	// constructors
	public BasePhoto () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhoto (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String photoName;
	private java.lang.String photoType;
	private java.sql.Blob photoData;
	private java.lang.Integer photoSize;

	// many to one
	private com.ictti.library.business.entity.BookList book;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="photo_id"
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
	 * Return the value associated with the column: photo_name
	 */
	public java.lang.String getPhotoName () {
		return photoName;
	}

	/**
	 * Set the value related to the column: photo_name
	 * @param photoName the photo_name value
	 */
	public void setPhotoName (java.lang.String photoName) {
		this.photoName = photoName;
	}



	/**
	 * Return the value associated with the column: photo_type
	 */
	public java.lang.String getPhotoType () {
		return photoType;
	}

	/**
	 * Set the value related to the column: photo_type
	 * @param photoType the photo_type value
	 */
	public void setPhotoType (java.lang.String photoType) {
		this.photoType = photoType;
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



	/**
	 * Return the value associated with the column: photo_size
	 */
	public java.lang.Integer getPhotoSize () {
		return photoSize;
	}

	/**
	 * Set the value related to the column: photo_size
	 * @param photoSize the photo_size value
	 */
	public void setPhotoSize (java.lang.Integer photoSize) {
		this.photoSize = photoSize;
	}



	/**
	 * Return the value associated with the column: book_id
	 */
	public com.ictti.library.business.entity.BookList getBook () {
		return book;
	}

	/**
	 * Set the value related to the column: book_id
	 * @param book the book_id value
	 */
	public void setBook (com.ictti.library.business.entity.BookList book) {
		this.book = book;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.library.business.entity.Photo)) return false;
		else {
			com.ictti.library.business.entity.Photo photo = (com.ictti.library.business.entity.Photo) obj;
			if (null == this.getId() || null == photo.getId()) return false;
			else return (this.getId().equals(photo.getId()));
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