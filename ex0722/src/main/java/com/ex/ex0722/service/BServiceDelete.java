package com.ex.ex0722.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.ex0722.Dao.BDao;
import com.ex.ex0722.vo.BVo;

public class BServiceDelete implements BService {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		BDao bDao = new BDao();
		int bid = Integer.parseInt(request.getParameter("bid"));
		int result = bDao.BoardDelete(Integer.parseInt(request.getParameter("bid")));
		System.out.println(result);
		request.setAttribute("result", result);
		request.setAttribute("bid", bid);
	}

}
