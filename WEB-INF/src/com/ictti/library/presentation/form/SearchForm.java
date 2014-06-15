package com.ictti.library.presentation.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.ictti.library.business.entity.BookList;

public class SearchForm extends ActionForm {
	private List<BookList> frmBookList;
	private BookList frmBooksDetail;
	private String frmDetailBookId;
	private String frmBookTitle;
	private String searcherror;
	private String frmAuthorName;
	private Integer frmPrice;
	private String frmCategory;

	public String getFrmCategory() {
		return frmCategory;
	}

	public void setFrmCategory(String frmCategory) {
		this.frmCategory = frmCategory;
	}

	public Integer getFrmPrice() {
		return frmPrice;
	}

	public void setFrmPrice(Integer frmPrice) {
		this.frmPrice = frmPrice;
	}

	public String getFrmAuthorName() {
		return frmAuthorName;
	}

	public void setFrmAuthorName(String frmAuthorName) {
		this.frmAuthorName = frmAuthorName;
	}

	public String getSearcherror() {
		return searcherror;
	}

	public void setSearcherror(String searcherror) {
		this.searcherror = searcherror;
	}

	public String getFrmBookTitle() {
		return frmBookTitle;
	}

	public void setFrmBookTitle(String frmBookTitle) {
		this.frmBookTitle = frmBookTitle;
	}

	public List<BookList> getFrmBookList() {
		return frmBookList;
	}

	public void setFrmBookList(List<BookList> frmBookList) {
		this.frmBookList = frmBookList;
	}

	public BookList getFrmBooksDetail() {
		return frmBooksDetail;
	}

	public void setFrmBooksDetail(BookList frmBooksDetail) {
		this.frmBooksDetail = frmBooksDetail;
	}

	public String getFrmDetailBookId() {
		return frmDetailBookId;
	}

	public void setFrmDetailBookId(String frmDetailBookId) {
		this.frmDetailBookId = frmDetailBookId;
	}

	public String getFrmControl() {
		return frmControl;
	}

	public void setFrmControl(String frmControl) {
		this.frmControl = frmControl;
	}

	private String frmControl;

	// scroll function;actual page
	private int actualPage;

	// scroll function;max data to show in the list
	private int iMaxShow = 1;

	public int getiMaxShow() {
		return iMaxShow;
	}

	public void setiMaxShow(int iMaxShow) {
		this.iMaxShow = iMaxShow;
	}

	public int getiMaxData() {
		return iMaxData;
	}

	public void setiMaxData(int iMaxData) {
		this.iMaxData = iMaxData;
	}

	// scroll function; max data that is retrieved from the list
	private int iMaxData;
	// scroll function;final page
	private int finalPage;
	// scroll function; next button
	private boolean nextBtn;

	// scroll function; prev button
	private boolean prevBtn;

	public int getActualPage() {
		return actualPage;
	}

	public void setActualPage(int actualPage) {
		this.actualPage = actualPage;
	}

	public boolean isPrevBtn() {
		if (getActualPage() == 1) {
			prevBtn = false;
		} else {
			prevBtn = true;
		}
		return prevBtn;
	}

	public void setPrevBtn(boolean prevBtn) {
		this.prevBtn = prevBtn;
	}

	public boolean isNextBtn() {
		if (getActualPage() == getFinalPage()) {
			nextBtn = false;
		} else {
			nextBtn = true;
		}
		return nextBtn;
	}

	public void setNextBtn(boolean nextBtn) {
		this.nextBtn = nextBtn;
	}

	public String getBegin() {
		int iBegin = (actualPage - 1) * iMaxShow + 1;
		return Integer.valueOf(iBegin).toString();
	}

	public String getEnd() {
		int iEnd = actualPage * iMaxShow;
		if (iEnd > iMaxData) {
			iEnd = iMaxData;
		}
		return Integer.valueOf(iEnd).toString();
	}

	/*
	 * public void setFinalPageCalc(int iListSize){ finalPage=iListSize /
	 * iMaxShow; }
	 */
	public int getFinalPage() {
		finalPage = (int) Math.ceil((double) iMaxData / iMaxShow);
		return finalPage;
	}

	public void setFinalPage(int finalPage) {
		this.finalPage = finalPage;
	}

}
