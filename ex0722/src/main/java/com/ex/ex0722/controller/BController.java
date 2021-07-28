package com.ex.ex0722.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.ex0722.service.BService;
import com.ex.ex0722.service.BServiceDelete;
import com.ex.ex0722.service.BServiceList;
import com.ex.ex0722.service.BServiceViwe;
import com.ex.ex0722.service.BServiceWrite;

@WebServlet("*.do")
public class BController extends HttpServlet {

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		request.setCharacterEncoding("utf-8");
		
		RequestDispatcher dispatcher = null;
		
		String uri = request.getRequestURI();
		String fileName = uri.substring(request.getContextPath().length());
	
		System.out.println(fileName);
							
		if(fileName.equals("/board/bList.do")) {
			BService bService = new BServiceList();
			bService.excute(request, response);
			System.out.println("1번");
			dispatcher = request.getRequestDispatcher("./bList.jsp");
		}else if(fileName.equals("/board/bviwe.do")) {
			BService bService = new BServiceViwe();
			bService.excute(request, response);
			System.out.println("2번");
			dispatcher = request.getRequestDispatcher("./bviwe.jsp");
		}else if(fileName.equals("/board/bwrite.do")) {
			dispatcher = request.getRequestDispatcher("./bwrite.jsp");
		}else if(fileName.equals("/board/bwriteOk.do")) {
			BService bService = new BServiceWrite();
			bService.excute(request, response);
			System.out.println("3번");
			dispatcher = request.getRequestDispatcher("/board/bList.do");
		}else if(fileName.equals("/board/delete.do")) {
			BService bService = new BServiceDelete();
			bService.excute(request, response);
			System.out.println("삭제부분");
			dispatcher = request.getRequestDispatcher("./bDelete.jsp");
		}
		
		
		dispatcher.forward(request, response);
		
		
		
		
		
		
		
		
	}//doAction
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost");
		doAction(request, response);
	}

}
