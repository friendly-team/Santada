package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MyPageModifyServlet
 */
@WebServlet("/info/modify")
public class MyPageModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	////////////////////////////
		// userId, userPwd, userEmail, userPhone, userAddress, userHobby
		String userId = request.getParameter("user-id");
		String userPwd = request.getParameter("pwd-check");
		String userName = request.getParameter("user-name");
		String userEmail = request.getParameter("user-email");
		String userPhone = request.getParameter("user-phone");
		Member student = new Member(userId,userPwd,userName, userPhone,userEmail);
		int result = new MemberService().modifyStudent(student);
		if(result > 0) {
			// 성공하면 메인페이지로 이동!
			response.sendRedirect("/mypage/info");
		}else {
			// 실패하면 실패메시지 페이지로 이동!
			response.sendRedirect("/member/studentError.html");
		}
	}

}
