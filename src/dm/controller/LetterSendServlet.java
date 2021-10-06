package dm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dm.model.service.DmService;
import dm.model.vo.Dm;
import member.model.service.MemberService;

/**
 * Servlet implementation class LetterSendServlet
 */
@WebServlet("/letter/send")
public class LetterSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LetterSendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/dm/letter.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String recipientId = request.getParameter("recipient-id");
		String userId = request.getParameter("user-id");
		String letterSub = request.getParameter("letter-subject");
		String letterCon = request.getParameter("letter-contents");
		
		Dm Dm = new Dm(recipientId, userId, letterSub, letterCon);
		
		int result = new DmService().sendLetter(Dm);
		
		if(result > 0) {
			response.sendRedirect("/index.jsp");
		}else {
			
		}
	}

}
