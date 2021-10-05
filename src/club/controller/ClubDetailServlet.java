package club.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import club.model.service.ClubService;
import club.model.vo.Club;

/**
 * Servlet implementation class ClubDetailServlet
 */
@WebServlet("/club/detail")
public class ClubDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClubDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int clubNo = Integer.parseInt(request.getParameter("clubNo"));
		Club c = new ClubService().printDetailClub(clubNo);
		int clubPersonnel = new ClubService().printClubPersonnel(clubNo);
		if(c != null) {
			request.setAttribute("club", c);
			request.setAttribute("clubPersonnel", clubPersonnel);
			request.getRequestDispatcher("/WEB-INF/views/club/clubDetail.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
