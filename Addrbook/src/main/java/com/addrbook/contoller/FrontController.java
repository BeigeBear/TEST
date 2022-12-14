package com.addrbook.contoller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.addrbook.model.AddrDto;
import com.addrbook.service.DeleteService;
import com.addrbook.service.DeleteServiceImpl;
import com.addrbook.service.InsertService;
import com.addrbook.service.InsertServiceImpl;
import com.addrbook.service.ListService;
import com.addrbook.service.ListServiceImpl;
import com.addrbook.service.UpdateService;
import com.addrbook.service.UpdateServiceImpl;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public FrontController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request,response);
	}

	
	// *.do 실행
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 연락처 리스트 호출
		if(command.equals("/list.do")) {
			System.out.println("list.do 입니다");
			
			ListService listService = new ListServiceImpl();
			ArrayList<AddrDto> addrList = listService.execute(request, response);
			
			request.setAttribute("addrList", addrList);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("addrbook_list.jsp");
			requestDispatcher.forward(request, response);
		}
		
		// 연락처 삽입
		if(command.equals("/insert.do")) {
			System.out.println("insert.do 입니다.");
			
			AddrDto insertAddr = new AddrDto();
			insertAddr.setName(request.getParameter("name"));
			insertAddr.setEmail(request.getParameter("email"));
			insertAddr.setComdept(request.getParameter("comdept"));
			insertAddr.setBirth(request.getParameter("birth"));
			insertAddr.setTel(request.getParameter("tel"));
			insertAddr.setMemo(request.getParameter("memo"));
			
			request.setAttribute("insertAddr", insertAddr);
			
			InsertService insertService = new InsertServiceImpl();
			insertService.execute(request, response);
			response.sendRedirect("/Addrbook/list.do");
		}
		
		
		// 연락처 업데이트
		if(command.equals("/update.do")) {
			System.out.println("update.do 입니다.");
			HttpSession session = request.getSession();
			
			int updateId = (Integer.parseInt((String)session.getAttribute("editId")));
			
			AddrDto updateAddr = new AddrDto();
			updateAddr.setName(request.getParameter("name"));
			updateAddr.setEmail(request.getParameter("email"));
			updateAddr.setComdept(request.getParameter("comdept"));
			updateAddr.setBirth(request.getParameter("birth"));
			updateAddr.setTel(request.getParameter("tel"));
			updateAddr.setMemo(request.getParameter("memo"));
			
			request.setAttribute("updateId", updateId);
			request.setAttribute("updateAddr", updateAddr);
			
			UpdateService updateService = new UpdateServiceImpl();
			updateService.execute(request, response);
			response.sendRedirect("/Addrbook/list.do");
		}
		
		// 연락처 삭제
		if(command.equals("/delete.do")) {
			System.out.println("delete.do 입니다.");
			HttpSession session = request.getSession();
			
			int deleteId = (Integer.parseInt((String)session.getAttribute("editId")));

			request.setAttribute("deleteId", deleteId);
			
			DeleteService deleteService = new DeleteServiceImpl();
			deleteService.execute(request, response);
			response.sendRedirect("/Addrbook/list.do");
		}

	} // actionDo
	
}