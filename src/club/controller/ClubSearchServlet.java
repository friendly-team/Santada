package club.controller;

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
import club.model.vo.ClubPageData;

/**
 * Servlet implementation class ClubSearchServlet
 */
@WebServlet("/club/search")
public class ClubSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClubSearchServlet() {
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
		String keyword = request.getParameter("keyword");
		int currentPage = 1;
		String currentPageVal = request.getParameter("currentPage");
		if(currentPageVal != null) {
			currentPage = Integer.parseInt(currentPageVal);
		}
		ClubPageData cPd = new ClubService().ClubSearch(keyword, currentPage);
		List<Club> cList = cPd.getcList();
		if(!cList.isEmpty()) {
			request.setAttribute("cList", cList);
			request.setAttribute("pageNavi", cPd.getPageNavi());
			request.getRequestDispatcher("/WEB-INF/views/club/clubSearchList.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/club/clubList.jsp").forward(request, response);
		}
	}

}
