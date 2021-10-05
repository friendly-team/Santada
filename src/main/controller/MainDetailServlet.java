package main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mountainPost.model.service.MountainPostService;
import mountainPost.model.vo.MountainPost;

/**
 * Servlet implementation class MainDetailServelt
 */
@WebServlet("/main/detail")
public class MainDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 2
		int mountainPostNo = Integer.parseInt(request.getParameter("mountainPostNo"));
		MountainPost mPost = new MountainPostService().printMainPost(mountainPostNo);
		if(mPost != null) {
			request.setAttribute("mountainPostNo", mPost);
			request.getRequestDispatcher("/show/main.jsp").forward(request, response);
		}else {
			response.sendRedirect("/recommend/mountainRecommendError.html");
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
