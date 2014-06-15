package com.ictti.library.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the sub_category table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="sub_category"
 */

public abstract class BaseSubCategory  implements Serializable {

	public static String REF = "SubCategory";
	public static String PROP_CATEGORY = "category";
	public static String PROP_SUB_CATEGORY_NAME = "subCategoryName";
	public static String PROP_ID = "id";


	// constructors
	public BaseSubCategory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSubCategory (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String subCategoryName;

	// many to one
	private com.ictti.library.business.entity.Category category;

	// collections
	private java.util.Set<com.ictti.library.business.entity.BookList> bookLists;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="subcategory_id"
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
	 * Return the value associated with the column: subcategory_name
	 */
	public java.lang.String getSubCategoryName () {
		return subCategoryName;
	}

	/**
	 * Set the value related to the column: subcategory_name
	 * @param subCategoryName the subcategory_name value
	 */
	public void setSubCategoryName (java.lang.String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}



	/**
	 * Return the value associated with the column: category_id
	 */
	public com.ictti.library.business.entity.Category getCategory () {
		return category;
	}

	/**
	 * Set the value related to the column: category_id
	 * @param category the category_id value
	 */
	public void setCategory (com.ictti.library.business.entity.Category category) {
		this.category = category;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.library.business.entity.SubCategory)) return false;
		else {
			com.ictti.library.business.entity.SubCategory subCategory = (com.ictti.library.business.entity.SubCategory) obj;
			if (null == this.getId() || null == subCategory.getId()) return false;
			else return (this.getId().equals(subCategory.getId()));
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