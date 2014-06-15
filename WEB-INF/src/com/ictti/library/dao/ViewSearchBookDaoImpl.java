package com.ictti.library.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.ictti.library.business.entity.BookList;

import com.ictti.library.business.entity.ViewSearchBook;

class ViewSearchBookDaoImpl extends HibernateDaoSupport implements
		ViewSearchBookDao {
	public ViewSearchBook getBookListById(int id) {
		String hql = "from ViewSearchBook i where i.id=?";
		List l = getHibernateTemplate().find(hql, id);
		return (ViewSearchBook) (l.isEmpty() || l == null ? null : l.get(0));
	}

	public List<ViewSearchBook> getBookListDetail() {
		String hql = "from ViewSearchBook i";
		List<ViewSearchBook> l = getHibernateTemplate().find(hql);
		return l.isEmpty() || l == null ? null : l;
	}

	// for title only
	public List<ViewSearchBook> getBookListByTitle(String strTitle) {
		System.out.println("Here Service.." + strTitle);
		String hql = "from ViewSearchBook i where i.noofcopies<>0 and i.title like '%" + strTitle
				+ "%' group by i.id order by title asc";
		List<ViewSearchBook> l = getHibernateTemplate().find(hql);
		System.out.println("list size (For title):" + l.size());
		return l.isEmpty() || l == null ? null : l;

	}

	// for author only
	public List<ViewSearchBook> getBookListByAuthor(String strAuthor) {
		String hql = "from ViewSearchBook i where i.noofcopies<>0 and i.authorName like '%"
				+ strAuthor + "%' order by title asc";
		List<ViewSearchBook> l = getHibernateTemplate().find(hql);
		System.out.println("list size (For author):" + l.size());
		return l.isEmpty() || l == null ? null : l;
	}

	// for title&author
	public List<ViewSearchBook> searchByTitleAuthor(String a_strTitle,
			String a_strAuthor) {
		System.out.println("This is Dao Impl for getBookListByTitleAuthor!!");
		String hql = "from ViewSearchBook i where i.noofcopies<>0 and i.title like '%" + a_strTitle
				+ "%' and i.authorName like '%" + a_strAuthor
				+ "%' order by title asc";
		// Object[] parm = { a_strTitle, a_strAuthor };
		List<ViewSearchBook> l = getHibernateTemplate().find(hql);
		System.out.println("list size (For title,author):" + l.size());
		return l.isEmpty() || l == null ? null : l;

	}

	// For category and sub category
	public List<ViewSearchBook> getViewBookListByCategoryAndSubCategory(
			String categoryId, String subCategoryId) {
		System.out
				.println("This is Dao Impl for getViewBookListByCategoryAndSubCategory");
		String hql = "from ViewSearchBook i where i.noofcopies<>0 and i.categoryId=? and i.subCategoryId=? group by i.id order by title asc";
		Object[] param = new Object[] { Integer.parseInt(categoryId),
				Integer.parseInt(subCategoryId) };
		List list = null;
		list = getHibernateTemplate().find(hql, param);
		System.out.println("list size (For Category And SubCategory):"
				+ list.size());
		return list != null && !list.isEmpty() ? list : null;

	}

	// for all
	public List<ViewSearchBook> getBookListByAll(Integer category,
			Integer subcategory) {
		System.out.println("This is Dao Impl for getBookListByAll!!");
		String hql = "from ViewSearchBook i where i.noofcopies<>0 group by i.id order by title asc";
		List<ViewSearchBook> l = getHibernateTemplate().find(hql);
		System.out.println("list size(for All,All):" + l.size());
		return l.isEmpty() || l == null ? null : l;
	}

	/*// for Title,Category And SubCategory
	public List<ViewSearchBook> getViewBookListByTitleCategoryAndSubCategory(
			String title, Integer categoryId, Integer subCategoryId) {
		System.out
				.println("This is Dao Impl for getBookListByTitleCategoryAndSubCategory!!");
		String hql = "from ViewSearchBook i where i.title=? and i.categoryId=? and i.subCategoryId=? group by i.id order by title asc";
		Object[] parm = new Object[] { title,categoryId, subCategoryId };
		List<ViewSearchBook> l = getHibernateTemplate().find(hql, parm);
		System.out.println("list size(for Title,Category And SubCategory):"
				+ l.size());
		return l.isEmpty() || l == null ? null : l;

	}*/
	// for Title,Category And SubCategory
	public List<ViewSearchBook> getViewBookListByTitleCategoryAndSubCategory(
			String title, Integer categoryId, Integer subCategoryId) {
		System.out
				.println("This is Dao Impl for getBookListByTitleCategoryAndSubCategory!!");
		String hql = "from ViewSearchBook i where i.noofcopies<>0 and i.title like '%" +title+ "%' and i.categoryId=? and i.subCategoryId=? group by i.id order by title asc";
		Object[] parm = new Object[] {categoryId, subCategoryId };
		List<ViewSearchBook> l = getHibernateTemplate().find(hql, parm);
		System.out.println("list size(for Title,Category And SubCategory):"
				+ l.size());
		return l.isEmpty() || l == null ? null : l;

	}

	// for Author,Category And SubCategory
	public List<ViewSearchBook> getViewBookListByAuthorCategoryAndSubCategory(
			String author, Integer categoryId, Integer subcategoryId) {
		System.out
				.println("This is Dao Impl for getBookListByAuthorCategoryAndSubCategory!!");
		String hql = "from ViewSearchBook i where i.noofcopies<>0 and i.authorName like '%" +author+ "%' and i.categoryId=? and i.subCategoryId=?";
		Object[] parm = new Object[] {categoryId, subcategoryId };
		List<ViewSearchBook> l = getHibernateTemplate().find(hql, parm);
		System.out.println("list size:" + l.size());
		return l.isEmpty() || l == null ? null : l;

	}

	// for all Criteria
	public List<ViewSearchBook> getViewBookListByAllCriteria(String title, 
			String author, Integer categoryId, Integer subcategoryId) {
		System.out
				.println("This is Dao Impl for getBookListByAuthorCategoryAndSubCategory!!");
		String hql = "from ViewSearchBook i where i.noofcopies<>0 and i.title like '%" +title+ "%' and i.authorName like '%" +author+ "%' and i.categoryId=? and i.subCategoryId=? group by i.id order by title asc";
		Object[] parm = new Object[] {categoryId, subcategoryId };
		List<ViewSearchBook> l = getHibernateTemplate().find(hql, parm);
		System.out.println("list size (for All Criteria):" + l.size());
		return l.isEmpty() || l == null ? null : l;

	}

}