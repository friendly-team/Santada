package mountainPost.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mountainPost.model.service.MountainPostService;

/**
 * Servlet implementation class MountainPostReplyModifyServlet
 */
@WebServlet("/mountainPostReply/modify")
public class MountainPostReplyModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MountainPostReplyModifyServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String replyContents = request.getParameter("replyContents");
		int replyNo = Integer.parseInt(request.getParameter("replyNo"));
		int mPostNo = Integer.parseInt(request.getParameter("mountainPostNo"));
		int result = new MountainPostService().modifyReplyOne(replyContents, replyNo);
		if(result > 0) {
			response.sendRedirect("/mountainPost/detail?mountainPostNo=" + mPostNo);
		} else {
			request.getRequestDispatcher("/WEB-INF/views/mountain-climbing/post/mPostError.html").forward(request, response);
		}
	}

}
