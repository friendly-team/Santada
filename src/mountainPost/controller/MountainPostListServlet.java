package mountainPost.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mountainPost.model.service.MountainPostService;
import mountainPost.model.vo.MountainPost;
import mountainPost.model.vo.PageData;

/**
 * Servlet implementation class MountainPostListServlet
 */
@WebServlet("/mountainPost/list")
public class MountainPostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MountainPostListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 0;
		String getCurrentPage = request.getParameter("currentPage");
		if(getCurrentPage == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(getCurrentPage);
		}
		PageData pageData = new MountainPostService().printAllmPost(currentPage);
		List<MountainPost> mList = pageData.getmList();
		if(!mList.isEmpty()) {
			request.setAttribute("mList", mList);
			request.setAttribute("pageNavi", pageData.getPageNavi());
			request.getRequestDispatcher("/WEB-INF/views/mountain-climbing/post/mountainPostList.jsp").forward(request, response);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/mountain-climbing/post/mPostError.html");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
