package com.ex.ex0722.service;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.ex0722.Dao.BDao;
import com.ex.ex0722.service.BService;
import com.ex.ex0722.vo.BVo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BServiceWrite implements BService {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		BDao bDao = new BDao();

		String path = "c:/upload";
		int size = 5*1024*1024;
		
		try {
			MultipartRequest multi = new MultipartRequest(request, path, size,"utf-8", new DefaultFileRenamePolicy());
		
			String btitle = multi.getParameter("btitle");
			String bname = multi.getParameter("bname");
			String bcontent = multi.getParameter("bcontent");
			String bupload = multi.getFilesystemName("upload1");
			
			
			int result = bDao.boardInsert(btitle,bname,bcontent,bupload);
			request.setAttribute("result", result);
			
			
			
			
			//여러 파일업로드시
//			String[] upload = new String[3];
//			Enumeration e = multi.getParameterNames();
//			
//			int i=0;
//			while (e.hasMoreElements()) {
//				String name = (String)e.nextElement();
//				
//				upload[i] = multi.getFilesystemName(name);
//				i++;
//			}
		
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
