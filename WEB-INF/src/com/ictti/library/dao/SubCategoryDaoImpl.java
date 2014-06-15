package com.ictti.library.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.ictti.library.business.entity.SubCategory;

public class SubCategoryDaoImpl extends HibernateDaoSupport implements SubCategoryDao  {

	@Override
	public List<SubCategory> getBySubcategory(String categoryId) {
		// TODO Auto-generated method stub
		int sid=Integer.valueOf(categoryId);
		String hql = "from SubCategory s where s.category.id=?";
		List<SubCategory> list =  getHibernateTemplate().find(hql,sid);
		System.out.println("This is testing for book register dao for subcategory"+list);
		System.out.println("list=" + list);
		return list;
	}
	public List<SubCategory> getBySubcategorybyid(Integer categoryId) {

        String hql = "from SubCategory s where s.category.id= ? ";
        List<SubCategory> list =  getHibernateTemplate().find(hql,categoryId);
        System.out.println("list=" + list);
        return list;
}

	  public SubCategory getSubcategoryName(String subcat) {
          System.out.println("subcategory id is ....." +subcat);
          int cid=Integer.valueOf(subcat);
          String hql ="from SubCategory s where s.id = ?";
          List list = null;
          list = getHibernateTemplate().find(hql,cid);
          System.out.println("Do Subcategory...."+list.get(0));
          return list != null && !list.isEmpty() ? (SubCategory)list.get(0)
                          : null;
   }

  //get subcategoryDto for adding subcategory_id
  public SubCategory get(String sub) {
          System.out.println("subcategoryDaoImpl....." +sub);

          String hql ="from SubCategory s where s.subcategoryName = ?";
          List list = null;
          list = getHibernateTemplate().find(hql,sub);
          System.out.println("Do Category...."+list.get(0));
          return list != null && !list.isEmpty() ? (SubCategory)list.get(0)
                          : null;
   }
  public SubCategory getBySubcategoryid(Integer catId)
  {

	  String hql = "from SubCategory s where s.category.id = ?";
		List list = getHibernateTemplate().find(hql, catId);
		return list != null && !list.isEmpty() ? (SubCategory) list.get(0) : null;

  }
  //For book registration
  public SubCategory getSubCategoryId(Integer catId)
  { 
	  System.out.println("In SubCategoryDaoImpl,SubCategoryID is"+catId);
	  //int sid=Integer.valueOf(catId);
	  String hql = "from SubCategory s where s.id=?";
	  List list = getHibernateTemplate().find(hql,catId);
	  return list != null && !list.isEmpty() ? (SubCategory) list.get(0) : null;
	  
  }
}
