package com.ictti.library.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.library.business.entity.BookList;
import com.ictti.library.business.entity.Category;
import com.ictti.library.business.entity.SubCategory;



public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao {

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		String strsql = "from Category c order by c.categoryName";
		List list = getHibernateTemplate().find(strsql);
		System.out.println("This is testing for book register dao for category"+list);
		System.out.println("This is testing for book register dao for category"+list.size());
		return list;
	}
	public Category getByCategoryName(String catid) {
		// TODO Auto-generated method stub
		String strsql = "from Category c where c.id = ?";
		List list = getHibernateTemplate().find(strsql,catid);
		 return list != null && !list.isEmpty() ? (Category)list.get(0)
                 : null;
	}
	
	public Category getCategoryById(Integer catid)
	{
		List l=getHibernateTemplate().find("from Category i where i.id=?",catid);
	       return l.isEmpty() || l==null ? null : (Category) l.get(0);
	       
	}
	
}
