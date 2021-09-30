package mountainPost.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mountainPost.model.service.MountainPostService;

/**
 * Servlet implementation class MountainPostRecommendServlet
 */
@WebServlet("/mountainPost/recommend")
public class MountainPostRecommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MountainPostRecommendServlet() {
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
		int mPostNo = Integer.parseInt(request.getParameter("mountainPostNo"));
		int recCount = Integer.parseInt(request.getParameter("mountainRecommend"));
		int result = new MountainPostService().plusMountainRecommend(mPostNo, recCount);
		if(result > 0) {
			response.sendRedirect("/mountainPost/detail?mountainPostNo=" + mPostNo);
		} else {
			request.getRequestDispatcher("/WEB-INF/views/mountain-climbing/post/mPostError.html").forward(request, response);
		}
	}

}
