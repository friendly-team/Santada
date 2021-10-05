package member.controller;

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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/member/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("user-id");
		String userPwd = request.getParameter("user-pwd");
//		System.out.println("userId : " + userId + ", userPwd : " + userPwd);
//		System.out.println("잘 넘어오는군 ㅎㅎ");
		// 인증과정
		Member member = new MemberService().printOneLogin(userId, userPwd);
		ClubManagement cm = new ClubService().printOneId(userId);
		Club club = new ClubService().printBossCheck(userId);
			
		if(member != null && cm != null) {
			Club clubName = new ClubService().printClubName(cm.getClubNo());	
			HttpSession session = request.getSession();
			session.setAttribute("clubName", clubName);
			session.setAttribute("userId", member.getUserId());
			session.setAttribute("cm", cm);			
			session.setAttribute("club", club);
//			request.getRequestDispatcher("/index.jsp").forward(request, response);
			response.sendRedirect("/index.jsp");
		}else if(member != null && cm == null) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", member.getUserId());
			session.setAttribute("cm", cm);			
			session.setAttribute("club", club);
			response.sendRedirect("/index.jsp");
		}
		 else {
			 request.getRequestDispatcher("/WEB-INF/views/member/loginFail.jsp").forward(request, response); // 실패할 경우 실패메시지 페이지로 이동
		}
	}

}
