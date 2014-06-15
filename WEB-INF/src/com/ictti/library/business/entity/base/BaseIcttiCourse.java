package com.ictti.library.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ictti_course table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ictti_course"
 */

public abstract class BaseIcttiCourse  implements Serializable {

	public static String REF = "IcttiCourse";
	public static String PROP_END_DATE = "endDate";
	public static String PROP_COURSE_CODE = "courseCode";
	public static String PROP_COURSE_NAME = "courseName";
	public static String PROP_ID = "id";


	// constructors
	public BaseIcttiCourse () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIcttiCourse (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String courseName;
	private java.lang.String courseCode;
	private java.util.Date endDate;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="course_id"
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
	 * Return the value associated with the column: course_name
	 */
	public java.lang.String getCourseName () {
		return courseName;
	}

	/**
	 * Set the value related to the column: course_name
	 * @param courseName the course_name value
	 */
	public void setCourseName (java.lang.String courseName) {
		this.courseName = courseName;
	}



	/**
	 * Return the value associated with the column: course_code
	 */
	public java.lang.String getCourseCode () {
		return courseCode;
	}

	/**
	 * Set the value related to the column: course_code
	 * @param courseCode the course_code value
	 */
	public void setCourseCode (java.lang.String courseCode) {
		this.courseCode = courseCode;
	}



	/**
	 * Return the value associated with the column: end_date
	 */
	public java.util.Date getEndDate () {
		return endDate;
	}

	/**
	 * Set the value related to the column: end_date
	 * @param endDate the end_date value
	 */
	public void setEndDate (java.util.Date endDate) {
		this.endDate = endDate;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.library.business.entity.IcttiCourse)) return false;
		else {
			com.ictti.library.business.entity.IcttiCourse icttiCourse = (com.ictti.library.business.entity.IcttiCourse) obj;
			if (null == this.getId() || null == icttiCourse.getId()) return false;
			else return (this.getId().equals(icttiCourse.getId()));
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