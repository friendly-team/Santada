package club.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import club.model.service.ClubService;

/**
 * Servlet implementation class ClubExitServlet
 */
@WebServlet("/club/exit")
public class ClubExitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClubExitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		int result = new ClubService().removeJoin(userId);
		
		if(result > 0) {
			response.sendRedirect("/clubjoin/management");
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/club/Error.html");
			view.forward(request, response);
		}
		
	}

}
