package clubPost.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import club.model.service.ClubService;
import club.model.vo.ClubManagement;
import clubPost.model.service.ClubPostService;
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
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		ClubManagement cm = new ClubService().printOneId(userId);
		int clubNo = cm.getClubNo();
		String searchKeyword = request.getParameter("keyword");
		int currentPage = 1;
		String currentPageVal = request.getParameter("currentPage");
		if(currentPageVal != null) {
			currentPage = Integer.parseInt(currentPageVal);
		}
		PageData pd = new ClubPostService().printSearchClubPost(searchKeyword, clubNo, currentPage);
	}

}
