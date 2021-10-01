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
 * Servlet implementation class MyPageRemoveServlet
 */
@WebServlet("/member/remove")
public class MyPageRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageRemoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String studentId = (String)session.getAttribute("userId");
		Member student = new MemberService().printOneById(studentId);
		if(student != null) {
			request.setAttribute("student", student);
			request.getRequestDispatcher("/WEB-INF/views/member/remove.jsp").forward(request, response);
		}else {
			response.sendRedirect("/member/studentError.html");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String studentId = (String)session.getAttribute("userId");
		int result = new MemberService().deleteMember(studentId);
		if(result > 0) {
			response.sendRedirect("/member/logout");
		}else {
		}
	}
}


