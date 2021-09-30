package mountainPost.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mountainPost.model.service.MountainPostService;
import mountainPost.model.vo.MountainPost;
import mountainPost.model.vo.PageData;

/**
 * Servlet implementation class MountainPostSearchServlet
 */
@WebServlet("/mountainPost/search")
public class MountainPostSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MountainPostSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchKeyword = request.getParameter("m-search-keyword");
		int currentPage = 1;
		String getCurrentPage = request.getParameter("currentPage");
		if(getCurrentPage != null) {
			currentPage = Integer.parseInt(getCurrentPage);
		}
		PageData pd = new MountainPostService().printSearchMountainPost(searchKeyword, currentPage);
		List<MountainPost> mList = pd.getmList();
		if(!mList.isEmpty()) {
			request.setAttribute("mList", mList);
			request.setAttribute("pageNavi", pd.getPageNavi());
			request.getRequestDispatcher("/WEB-INF/views/mountain-climbing/post/mountainPostSearch.jsp").forward(request, response);
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
