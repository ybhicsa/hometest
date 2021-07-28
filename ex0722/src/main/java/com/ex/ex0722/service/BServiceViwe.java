package com.ex.ex0722.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.ex0722.Dao.BDao;
import com.ex.ex0722.vo.BVo;

public class BServiceViwe implements BService {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		BDao bDao = new BDao();
		
		BVo bVo = bDao.BSelectView(Integer.parseInt(request.getParameter("bid")));
		
		request.setAttribute("bVo", bVo);
	}
}
