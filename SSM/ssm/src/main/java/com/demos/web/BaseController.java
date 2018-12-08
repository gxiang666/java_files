package com.demos.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;

import com.demos.utils.Page;

public class BaseController {
	public Page newPage(HttpServletRequest request) {
		return newPage(request, "id", "desc");
	}

	public Page newPage(HttpServletRequest request, String defaultOrder,
			String defaultSort) {
		String str_pageIndex = request.getParameter("pageIndex");
		int pageIndex = NumberUtils.toInt(str_pageIndex, 1);
		String str_pageSize = request.getParameter("pageSize");
		int pageSize = NumberUtils.toInt(str_pageSize, 10);
		String order = request.getParameter("order");
		String sort = request.getParameter("sort");

		if (StringUtils.isBlank(order)) {
			order = defaultOrder;
		}
		if (StringUtils.isBlank(sort)) {
			sort = defaultSort;
		}

		if (StringUtils.isBlank(order)) {
			order = "id";
		}
		if (StringUtils.isBlank(sort)) {
			sort = "desc";
		}

		Page page = new Page(pageIndex,pageSize);
		page.setOrder(order);
		page.setSort(sort);
		return page;
	}
}
