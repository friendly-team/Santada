package clubPost.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clubPost.model.service.ClubPostService;
import clubPost.model.vo.ClubPost;

/**
 * Servlet implementation class ModifyClubPostServlet
 */
@WebServlet("/clubPost/modify")
public class ModifyClubPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyClubPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = String.valueOf(session.getAttribute("userId"));
		String writeUser = request.getParameter("write-user");
		int postNo = Integer.parseInt(request.getParameter("post-no"));
		ClubPost cp = null;
		if(writeUser.equals(userId)) {
			cp = new ClubPostService().printDetailClubPost(postNo);
			request.setAttribute("cp", cp);
			request.getRequestDispatcher("/WEB-INF/views/club/modifyPost.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/club/modifyError.html").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String subject = request.getParameter("clubPost-subject");
		String contents = request.getParameter("clubPost-contents");
		int postNo = Integer.parseInt(request.getParameter("post-no"));
		ClubPost cp = new ClubPost();
		cp.setPostSubject(subject);
		cp.setPostContents(contents);
		cp.setPostNo(postNo);
		int result = new ClubPostService().modifyClubPost(cp);
		if(result > 0) {
			response.sendRedirect("/clubPost/List");
		}else {
			response.sendRedirect("/index.jsp");
		}
	}

}
