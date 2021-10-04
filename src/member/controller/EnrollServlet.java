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
 * Servlet implementation class EnrollServlet
 */
@WebServlet("/member/enroll")
public class EnrollServlet extends HttpServlet {

    public EnrollServlet() {}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/WEB-INF/views/member/enroll.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("user-id");
		String userPwd = request.getParameter("user-pwd");
		String userName = request.getParameter("user-name");
		String userPhone = request.getParameter("user-phone");
		String userEmail = request.getParameter("user-email");

		
		Member member = new Member(userId,userPwd,userName,userPhone,userEmail);

		int result = new MemberService().registerMember(member);
		
		if(result > 0) {
			response.sendRedirect("/member/login");
		}else {
			request.getRequestDispatcher("/WEB-INF/views/member/enrollfail.jsp").forward(request, response);
		}

	}
}
