package mountainPost.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mountainPost.model.service.MountainPostService;
import mountainPost.model.vo.MountainPost;
import mountainPost.model.vo.MtFileData;
import mountainPostFile.model.service.MtFileService;

/**
 * Servlet implementation class MountainPostDetailServlet
 */
@WebServlet("/mountainPost/detail")
public class MountainPostDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MountainPostDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mtPostNo = Integer.parseInt(request.getParameter("mountainPostNo"));
		MountainPost mPostOne = new MountainPostService().printOneByNo(mtPostNo);
		MtFileData mFileOne = new MtFileService().printOneByNo(mtPostNo);
		if(mPostOne != null) {
			request.setAttribute("mPostOne", mPostOne);
			request.setAttribute("mFileOne", mFileOne);
			request.getRequestDispatcher("/WEB-INF/views/mountain-climbing/post/mountainPostDetail.jsp").forward(request, response);
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
