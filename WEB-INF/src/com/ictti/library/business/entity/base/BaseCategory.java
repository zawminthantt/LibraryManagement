package com.ictti.library.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the category table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="category"
 */

public abstract class BaseCategory  implements Serializable {

	public static String REF = "Category";
	public static String PROP_CATEGORY_CODE = "categoryCode";
	public static String PROP_CATEGORY_NAME = "categoryName";
	public static String PROP_ID = "id";


	// constructors
	public BaseCategory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCategory (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String categoryName;
	private java.lang.String categoryCode;

	// collections
	private java.util.Set<com.ictti.library.business.entity.BookList> bookLists;
	private java.util.Set<com.ictti.library.business.entity.SubCategory> subCategories;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="category_id"
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
	 * Return the value associated with the column: category_code
	 */
	public java.lang.String getCategoryCode () {
		return categoryCode;
	}

	/**
	 * Set the value related to the column: category_code
	 * @param categoryCode the category_code value
	 */
	public void setCategoryCode (java.lang.String categoryCode) {
		this.categoryCode = categoryCode;
	}



	/**
	 * Return the value associated with the column: bookLists
	 */
	public java.util.Set<com.ictti.library.business.entity.BookList> getBookLists () {
		return bookLists;
	}

	/**
	 * Set the value related to the column: bookLists
	 * @param bookLists the bookLists value
	 */
	public void setBookLists (java.util.Set<com.ictti.library.business.entity.BookList> bookLists) {
		this.bookLists = bookLists;
	}

	public void addTobookLists (com.ictti.library.business.entity.BookList bookList) {
		if (null == getBookLists()) setBookLists(new java.util.TreeSet<com.ictti.library.business.entity.BookList>());
		getBookLists().add(bookList);
	}



	/**
	 * Return the value associated with the column: subCategories
	 */
	public java.util.Set<com.ictti.library.business.entity.SubCategory> getSubCategories () {
		return subCategories;
	}

	/**
	 * Set the value related to the column: subCategories
	 * @param subCategories the subCategories value
	 */
	public void setSubCategories (java.util.Set<com.ictti.library.business.entity.SubCategory> subCategories) {
		this.subCategories = subCategories;
	}

	public void addTosubCategories (com.ictti.library.business.entity.SubCategory subCategory) {
		if (null == getSubCategories()) setSubCategories(new java.util.TreeSet<com.ictti.library.business.entity.SubCategory>());
		getSubCategories().add(subCategory);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.library.business.entity.Category)) return false;
		else {
			com.ictti.library.business.entity.Category category = (com.ictti.library.business.entity.Category) obj;
			if (null == this.getId() || null == category.getId()) return false;
			else return (this.getId().equals(category.getId()));
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