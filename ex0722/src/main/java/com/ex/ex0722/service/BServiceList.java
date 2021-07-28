package com.ex.ex0722.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.ex0722.Dao.BDao;
import com.ex.ex0722.vo.BVo;

public class BServiceList implements BService {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		BDao bDao = new BDao();
		ArrayList<BVo> list = bDao.boardAllSelect();
		request.setAttribute("list", list);
	}

}
