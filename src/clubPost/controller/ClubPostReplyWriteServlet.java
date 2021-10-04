package clubPost.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clubPost.model.service.ClubPostService;
import clubPost.model.vo.ClubPostReply;

/**
 * Servlet implementation class ClubPostReplyWriteServlet
 */
@WebServlet("/clubPostReply/write")
public class ClubPostReplyWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClubPostReplyWriteServlet() {
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
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		String replyContents = request.getParameter("replyContents");
		ClubPostReply cpReply = new ClubPostReply();
		cpReply.setReplyUserId(userId);
		cpReply.setPostNo(postNo);
		cpReply.setReplyContents(replyContents);
		int result = new ClubPostService().registerClubPostReeply(cpReply);
		if(result > 0) {
			response.sendRedirect("/clubPost/detail?postNo=" + postNo);
		}else {
			response.sendRedirect("/index.jsp");
		}
	}

}
