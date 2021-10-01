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
import club.model.vo.ClubJoinPageData;
import club.model.vo.ClubManagement;
import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class ClubMemberSearch
 */
@WebServlet("/club/memberSearch")
public class ClubMemberSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClubMemberSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchKeyword = request.getParameter("searchKeyword");
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		int CurrentPage = 1;
		String currentPageVal = request.getParameter("currentPage");
		if(currentPageVal !=null) {
			CurrentPage = Integer.parseInt(currentPageVal);
		}
		ClubJoinPageData cjpd = new ClubService().pirntSearchMember(searchKeyword,CurrentPage,userId);
		List<ClubManagement> cmList = cjpd.getCmList();
		
		if(!cmList.isEmpty()) {
			request.setAttribute("userId", userId);
			request.setAttribute("cmList", cmList);
			request.setAttribute("pageNavi", cjpd.getPageNavi());
		}else {
			
		}
		//response.sendRedirect("/index.jsp");
		request.getRequestDispatcher("/WEB-INF/views/club/ClubMemberSearch.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
