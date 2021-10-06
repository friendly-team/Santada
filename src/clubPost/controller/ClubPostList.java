package clubPost.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import club.model.service.ClubService;
import club.model.vo.Club;
import club.model.vo.ClubManagement;
import clubPost.model.service.ClubPostService;
import clubPost.model.vo.ClubPost;
import clubPost.model.vo.PageData;

/**
 * Servlet implementation class ClubPostList
 */
@WebServlet("/clubPost/List")
public class ClubPostList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClubPostList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String userId = String.valueOf(session.getAttribute("userId"));
		int currentPage = 0;
		String getCurrentPage = request.getParameter("currentPage");
		if(getCurrentPage == null) {
			currentPage=1;
		}else {
			currentPage = Integer.parseInt(getCurrentPage);
		}
		PageData pageData = new ClubPostService().printAllClubPost(currentPage, userId);
		List<ClubPost> cpList = pageData.getClubPostList();
		if(!cpList.isEmpty()) {
			ClubManagement cm = (ClubManagement) session.getAttribute("cm");
			Club club = (Club)session.getAttribute("club");
			request.setAttribute("cm", cm);
			request.setAttribute("club", club);
			request.setAttribute("cpList", cpList);
			request.setAttribute("pageNavi", pageData.getPageNavi());
			request.getRequestDispatcher("/WEB-INF/views/club/postList.jsp").forward(request, response);
		}else {
			request.setAttribute("cpList", cpList);
			request.setAttribute("pageNavi", pageData.getPageNavi());
			request.getRequestDispatcher("/WEB-INF/views/club/postList.jsp").forward(request, response);
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
