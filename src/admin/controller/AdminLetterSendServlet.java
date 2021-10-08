package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dm.model.service.DmService;
import dm.model.vo.Dm;
import report.model.service.ReportService;

/**
 * Servlet implementation class LetterSendServlet
 */
@WebServlet("/admin/letter")
public class AdminLetterSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLetterSendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reportNo = Integer.parseInt(request.getParameter("reportNo"));
		String writeId = (String)(request.getParameter("writeId"));
		request.setAttribute("reportNo", reportNo);
		request.setAttribute("writeId", writeId);
		request.getRequestDispatcher("/WEB-INF/views/admin/adminDM.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String recipientId = request.getParameter("recipient-id");
		String userId = request.getParameter("user-id");
		String letterSub = request.getParameter("letter-subject");
		String letterCon = request.getParameter("letter-contents");
		
		Dm Dm = new Dm(recipientId, userId, letterSub, letterCon);
		int reportNo = Integer.parseInt(request.getParameter("reportNo"));
		System.out.println(reportNo);
		int result = new DmService().sendLetter(Dm);
		int answer = new ReportService().modifyAnswer(reportNo);
		if(result > 0) {
			if(answer > 0) {
				request.getRequestDispatcher("/WEB-INF/views/admin/adminDMRespond.jsp").forward(request, response);
			}
		}else {
			
		}
	}

}
