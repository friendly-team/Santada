package club.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import club.model.service.ClubService;
import club.model.vo.ClubManagement;

/**
 * Servlet implementation class ClubMemberDetail
 */
@WebServlet("/clubMember/detail")
public class ClubMemberDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClubMemberDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		ClubManagement cm = new ClubService().printMemberDetail(userId);
		
		if(cm != null) {
			request.setAttribute("cm", cm);
			request.getRequestDispatcher("/WEB-INF/views/club/ClubMemberDetail.jsp").forward(request, response);
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
		int result = new ClubService().removeMember(userId);
		
		if(result > 0) {
			response.sendRedirect("/club/memberList");
	}else {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/club/Error.html");
		view.forward(request, response);
	}
	}

}
