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
import club.model.vo.ClubManagement;
import club.model.vo.ClubJoinPageData;


/**
 * Servlet implementation class ClubJoinManagement
 */
@WebServlet("/clubjoin/management")
public class ClubJoinListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClubJoinListServlet() {
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
		ClubJoinPageData pageData = new ClubService().printAllJoin(currentPage,userId);
		List<ClubManagement> cmList = pageData.getCmList();
		
		if(!cmList.isEmpty()) {
			request.setAttribute("userId", userId);
			request.setAttribute("cmList", cmList);
			request.setAttribute("pageNavi", pageData.getPageNavi());
			request.getRequestDispatcher("/WEB-INF/views/club/clubJoinList.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/club/clubJoinList.jsp").forward(request, response);
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
