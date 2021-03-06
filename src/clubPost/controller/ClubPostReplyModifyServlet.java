package clubPost.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clubPost.model.service.ClubPostService;

/**
 * Servlet implementation class ClubPostReplyModify
 */
@WebServlet("/clubPostReply/modify")
public class ClubPostReplyModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClubPostReplyModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		int replyNo = Integer.parseInt(request.getParameter("replyNo"));
		String replyContents = request.getParameter("replyContents");
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		String replyUser = request.getParameter("replyUser");
		int result = new ClubPostService().modifyClubPostReply(userId, replyNo, replyContents, postNo, replyUser);
		if(result > 0) {
			response.sendRedirect("/clubPost/detail?postNo=" + postNo);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/club/ReplyError.html").forward(request, response);
		}
	}

}
