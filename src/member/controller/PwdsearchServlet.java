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
 * Servlet implementation class PwdsearchServlet
 */
@WebServlet("/pwd/search")
public class PwdSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PwdSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/views/member/pwdSearch.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("user-id");
		String userName = request.getParameter("user-name");
		String userEmail = request.getParameter("user-email");
		
		int result = new MemberService().findMemberPwd(userId,userName,userEmail);
		
		if(result > 0) {
			request.setAttribute("change", userId);
			request.getRequestDispatcher("/WEB-INF/views/member/Pwdchange.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/member/searchfail.jsp").forward(request, response);
		}
	}

}
