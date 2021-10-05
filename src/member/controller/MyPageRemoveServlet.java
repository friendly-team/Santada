package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
		String userPwd = request.getParameter("user-pwd");
		int result = new MemberService().deleteMember(studentId, userPwd);
		if(result > 0) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter();

			String msg = "회원 탈퇴가 완료되었습니다.";
			String str="";
			str = "<script language='javascript'>";
			str += "alert('"+ msg + "');location.href='/member/logout';";
			str += "</script>";
			out.print(str);
		}else {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			String msg = "비밀번호가 일치하지 않습니다.";
			String str="";
			str = "<script language='javascript'>";
			str += "alert('"+ msg + "');";
			str += "history.go(-1);";
			str += "</script>";
			out.print(str);
			

		

		}
	}
}


