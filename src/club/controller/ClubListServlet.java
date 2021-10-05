package club.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import club.model.service.ClubService;
import club.model.vo.Club;
import club.model.vo.ClubPageData;

/**
 * Servlet implementation class ClubListServlet
 */
@WebServlet("/club/list")
public class ClubListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClubListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 0;
		String getCurrentPage = request.getParameter("currentPage");
		if(getCurrentPage == null) {
			currentPage=1;
		}else {
			currentPage = Integer.parseInt(getCurrentPage);
		}
		ClubPageData cPd = new ClubService().printAllClub(currentPage);
		List<Club> cList = cPd.getcList();
		if(!cList.isEmpty()) {
			request.setAttribute("cList", cList);
			request.setAttribute("pageNavi", cPd.getPageNavi());
			request.getRequestDispatcher("/WEB-INF/views/club/clubList.jsp").forward(request, response);
		}else {
			response.sendRedirect("/show/main");
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
