package club.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import club.model.service.ClubService;
import club.model.vo.Club;
import club.model.vo.ClubJoinPageData;
import club.model.vo.ClubManagement;

/**
 * Servlet implementation class ClubMemberListServlet
 */
@WebServlet("/club/memberList")
public class ClubMemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClubMemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 0;
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		String getCurrentPage = request.getParameter("currentPage");
	
		if(getCurrentPage ==null) {
			currentPage =1;
		}else {
			currentPage = Integer.parseInt(getCurrentPage);
		}
		ClubJoinPageData pageData = new ClubService().printAllMember(currentPage,userId);
		List<ClubManagement> cmList = pageData.getCmList();
	
		if(!cmList.isEmpty()) {
			request.setAttribute("userId", userId);
			request.setAttribute("cmList", cmList);
			request.setAttribute("pageNavi", pageData.getPageNavi());
			request.getRequestDispatcher("/WEB-INF/views/club/ClubMemberList.jsp").forward(request, response);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/club/Error.html");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
