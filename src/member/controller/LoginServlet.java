package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		if(member != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", member.getUserId());
			response.sendRedirect("/index.jsp"); // 성공할 경우 성공메시지 페이지로 이동
		}else {
			request.getRequestDispatcher("/WEB-INF/views/member/loginfail.jsp").forward(request, response); // 실패할 경우 실패메시지 페이지로 이동
		}
	}

}
