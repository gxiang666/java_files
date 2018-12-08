package com.demos.utils;

public class Page {
	private int pageIndex;
	private int pageSize = 10;
	private int totalCount = 0;
	private int pageCount;
	private String sort;
	private String order;
	private boolean firstPage = false;
	private boolean hasPrev = false;
	private boolean hasNext = false;
	private boolean lastPage = false;

	public Page(int pageIndex) {
		this(pageIndex, 10);
	}

	public Page() {
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Page(int pageIndex, int pageSize) {
		if (pageIndex < 1)
			pageIndex = 1;
		if (pageSize < 1)
			pageSize = 10;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		if (this.pageIndex < 1)
			this.pageIndex = 1;
		if (this.pageSize < 1)
			this.pageSize = 10;
		return this.pageIndex;
	}

	public int getPageSize() {
		if (this.pageSize == 0)
			this.pageSize = 10;
		return this.pageSize;
	}

	public int getPageCount() {
		return this.pageCount;
	}

	public int getFirstResult() {
		return (this.pageIndex - 1) * this.pageSize;
	}

	public int getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.pageCount = (totalCount / this.pageSize + (totalCount
				% this.pageSize == 0 ? 0 : 1));
	}

	public boolean isEmpty() {
		return this.totalCount == 0;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSort() {
		return this.sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return this.order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public boolean getFirstPage() {
		if ((this.pageCount > 0) && (getPageIndex() != 1)) {
			return true;
		}
		return false;
	}

	public boolean getHasPrev() {
		if (getPageIndex() > 1) {
			return true;
		}
		return this.hasPrev;
	}

	public boolean getLastPage() {
		if (this.pageIndex >= this.pageCount)
			return false;
		return true;
	}

	public boolean getHasNext() {
		if (this.pageIndex > this.pageCount - 1) {
			return false;
		}
		return true;
	}

	public String toString() {
		return "Page [pageIndex=" + this.pageIndex + ", pageSize="
				+ this.pageSize + ", totalCount=" + this.totalCount
				+ ", pageCount=" + this.pageCount + ", sort=" + this.sort
				+ ", order=" + this.order + ", firstPage=" + this.firstPage
				+ ", hasPrev=" + this.hasPrev + ", hasNext=" + this.hasNext
				+ ",lastPage=" + this.lastPage + "]";
	}
}
