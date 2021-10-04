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
import club.model.vo.ClubManagement;
import clubPost.model.service.ClubPostService;
import clubPost.model.vo.ClubPost;
import clubPost.model.vo.PageData;

/**
 * Servlet implementation class ClubPostSearchServlet
 */
@WebServlet("/clubPost/search")
public class ClubPostSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClubPostSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		String clubName = new ClubService().selectOneClubName(userId);
		ClubManagement cm = new ClubService().printOneId(userId);
		int clubNo = cm.getClubNo();
		String searchKeyword = request.getParameter("keyword");
		int currentPage = 1;
		String currentPageVal = request.getParameter("currentPage");
		if(currentPageVal != null) {
			currentPage = Integer.parseInt(currentPageVal);
		}
		PageData pd = new ClubPostService().printSearchClubPost(searchKeyword, clubNo, currentPage);
		List<ClubPost> cpList = pd.getClubPostList();
		if(!cpList.isEmpty()) {
			request.setAttribute("cpList", cpList);
			request.setAttribute("pageNavi", pd.getPageNavi());
			request.setAttribute("clubName", clubName);
			request.getRequestDispatcher("/WEB-INF/views/club/clubPostSearch.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/club/error.html").forward(request, response);
		}
	}

}
