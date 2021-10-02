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
import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class ClubJoinServlet
 */
@WebServlet("/club/join")
public class ClubJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClubJoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/club/ClubJoin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		
	String clubName = request.getParameter("club-Name");
	int age = Integer.parseInt(request.getParameter("age")); 
	String introduce = request.getParameter("introduce");
	String joinRoute = request.getParameter("joinRoute");
	HttpSession session = request.getSession();
	String writerId = (String)session.getAttribute("userId");
	String userName = request.getParameter("userName");
	Member member = new MemberService().printOneById(writerId);
	ClubManagement club = new ClubManagement();	
	club.setClubName(clubName);
	club.setUserId(writerId);
	club.setUserAge(age);
	club.setUserIntroduce(introduce);
	club.setJoinRoute(joinRoute);
	club.setUserName(userName);	
	int result = new ClubService().ClubJoin(club);	
	if(result > 0) {
		ClubManagement cm = new ClubService().printOneId(writerId);
		Club clubBossCheck = new ClubService().printBossCheck(writerId);
		session.setAttribute("cm", cm);
		session.setAttribute("club", clubBossCheck);
		response.sendRedirect("/index.jsp");
//		request.getRequestDispatcher("/club/joinSuccess.jsp").forward(request, response);
	}else {
		request.getRequestDispatcher("/club/Error.html").forward(request, response);
	}
	}

}
