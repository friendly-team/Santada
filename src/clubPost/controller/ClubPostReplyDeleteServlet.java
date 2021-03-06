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
 * Servlet implementation class ClubPostReplyDeleteServlet
 */
@WebServlet("/clubPostReply/delete")
public class ClubPostReplyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClubPostReplyDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		int replyNo = Integer.parseInt(request.getParameter("replyNo"));
		String writeUser = request.getParameter("replyUser");
		int result = new ClubPostService().deleteClubPostReply(userId, postNo, replyNo, writeUser);
		if(result > 0) {
			response.sendRedirect("/clubPost/detail?postNo=" + postNo);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/club/ClubPostReplyDeleteError.html").forward(request, response);
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
