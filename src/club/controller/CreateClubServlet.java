package club.controller;

import java.io.IOException;
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
 * Servlet implementation class CreateClubServlet
 */
@WebServlet("/club/create")
public class CreateClubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateClubServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/club/createClub.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String userId = String.valueOf((session.getAttribute("userId")));
		String clubName = request.getParameter("club-name");
		String clubIntroduce = request.getParameter("club-introduce");
		String clubRegion = request.getParameter("club-region");
		int clubAge = Integer.parseInt((request.getParameter("club-age")));
		int userAge = Integer.parseInt(request.getParameter("user-age"));		
		Club club = new Club();
		club.setUserId(userId);
		club.setClubName(clubName);
		club.setClubIntroduce(clubIntroduce);
		club.setClubRegion(clubRegion);
		club.setClubAge(clubAge);
		int result = new ClubService().createClub(club, userAge);
		if(result > 0) {
			ClubManagement cm = new ClubService().printOneId(userId);
			Club clubBossCheck = new ClubService().printBossCheck(userId);
			session.setAttribute("cm", cm);
			session.setAttribute("club", clubBossCheck);
			response.sendRedirect("/index.jsp");
		}else {
			request.getRequestDispatcher("/club/Error.html").forward(request, response);
		}
	}

}
