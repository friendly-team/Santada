package mountainPost.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mountainPost.model.service.MountainPostService;

/**
 * Servlet implementation class MountainPostRemoveServlet
 */
@WebServlet("/mountainPost/remove")
public class MountainPostRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MountainPostRemoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mPostNo = Integer.parseInt(request.getParameter("mountainPostNo"));
		int result = new MountainPostService().removeMountainPost(mPostNo);
		if(result > 0) {
			response.sendRedirect("/mountainPost/list");
		} else {
			request.getRequestDispatcher("/WEB-INF/views/mountain-climbing/post/mPostError.html").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
