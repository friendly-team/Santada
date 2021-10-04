package clubPost.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clubPost.model.service.ClubPostService;

/**
 * Servlet implementation class ClubPostDeleteServlet
 */
@WebServlet("/clubPost/delete")
public class ClubPostDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClubPostDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = String.valueOf(session.getAttribute("userId"));
		String writeUser = request.getParameter("write-user");
		int postNo = Integer.parseInt(request.getParameter("post-no"));
		int clubNo = Integer.parseInt(request.getParameter("club-no"));
		int result = new ClubPostService().removeClubPost(postNo, clubNo, userId, writeUser);
		if(result > 0) {
			response.sendRedirect("/clubPost/List");
		}else {
			request.getRequestDispatcher("/WEB-INF/views/club/deleteError.html").forward(request, response);
		}
	}
}
