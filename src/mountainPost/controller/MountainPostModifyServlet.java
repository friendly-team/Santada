package mountainPost.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mountainPost.model.service.MountainPostService;
import mountainPost.model.vo.MountainPost;

/**
 * Servlet implementation class MountainPostModifyServlet
 */
@WebServlet("/mountainPost/modify")
public class MountainPostModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MountainPostModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mtPostNo = Integer.parseInt(request.getParameter("mountainPostNo"));
		MountainPost mPostOne = new MountainPostService().printOneByNo(mtPostNo);
		request.setAttribute("mPostOne", mPostOne);
		request.getRequestDispatcher("/WEB-INF/views/mountain-climbing/post/mountainPostModify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int postNo = Integer.parseInt(request.getParameter("m-post-no"));
		String subject = request.getParameter("post-sub");
		String mRegion = request.getParameter("mountain-region");
		String mName = request.getParameter("mountain-name");
		String mCourse = request.getParameter("mountain-course");
		int mTime = Integer.parseInt(request.getParameter("mountain-time"));
		int mParty = Integer.parseInt(request.getParameter("mountain-party"));	
		int mLevel = Integer.parseInt(request.getParameter("mountain-level"));
		String mCaution = request.getParameter("mountain-caution");
		String mNeed = request.getParameter("mountain-need");
		String contents = request.getParameter("post-con");
		MountainPost mPost = new MountainPost();
		mPost.setMountainPostNo(postNo);
		mPost.setMountainPostSubject(subject);
		mPost.setMountainRegion(mRegion);
		mPost.setMountainName(mName);
		mPost.setMountainCourse(mCourse);
		mPost.setMountainTime(mTime);
		mPost.setMountainParty(mParty);
		mPost.setMountainLevel(mLevel);
		mPost.setMountainCaution(mCaution);
		mPost.setMountainNeed(mNeed);
		mPost.setMountainPostContents(contents);
		int result = new MountainPostService().modifyMountainPost(mPost);
		if(result > 0) {
			response.sendRedirect("/mountainPost/list");
		} else {
			request.getRequestDispatcher("/WEB-INF/views/mountain-climbing/post/serviceFailed.html").forward(request, response);
		}
	}

}
