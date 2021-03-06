package club.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import club.model.service.ClubService;
import club.model.vo.Club;
import club.model.vo.ClubManagement;

/**
 * Servlet implementation class ClubJoinDetailServlet
 */
@WebServlet("/clubjoin/detail")
public class ClubJoinDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClubJoinDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = request.getParameter("userId");
		ClubManagement cm = new ClubService().printJoinDetail(userId);
		ClubManagement cmName = new ClubService().printOneId(userId);
		if(cm != null) {
			Club clubName = new ClubService().printClubName(cmName.getClubNo());
			session.setAttribute("clubName", clubName);
			request.setAttribute("cm", cm);
			request.getRequestDispatcher("/WEB-INF/views/club/ClubJoindetail.jsp").forward(request, response);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/club/Error.html");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		int result = new ClubService().modifyPosition(userId);
		
		if(result > 0) {
				response.sendRedirect("/clubjoin/management");
		}else {
				request.getRequestDispatcher("WEB-INF/views/club/Error.html").forward(request, response);
		}
	}

}
