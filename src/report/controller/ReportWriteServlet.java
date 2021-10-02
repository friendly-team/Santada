package report.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import club.model.service.ClubService;
import club.model.vo.Club;
import club.model.vo.ClubManagement;
import report.model.service.ReportService;
import report.model.vo.Report;

/**
 * Servlet implementation class ReportServlet
 */
@WebServlet("/report/write")
public class ReportWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int postNo = Integer.parseInt(request.getParameter("postNo"));
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		Report report = new Report();
		report.setUserId(userId);
		//report.setPostNo(postNo);
		request.setAttribute("Report", report);
		request.getRequestDispatcher("/WEB-INF/views/report/ReportWrite.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId"); //
		int postNo  = Integer.parseInt(request.getParameter("postNo")); //
		String postType = request.getParameter("postType"); //
		String Contents = request.getParameter("Contents");//
		String Title = request.getParameter("Title"); //
		String reportType = request.getParameter("reportType"); //
		Report report = new Report();
		report.setUserId(userId);
		report.setPostNo(postNo);
		report.setPostType(postType);
		report.setReportContents(Contents);
		report.setReportTitle(Title);
		report.setReportType(reportType);
		int result = new ReportService().writeReport(report);
		if(result > 0) {
			ClubManagement cm = new ClubService().printOneId(userId);
			Club clubBossCheck = new ClubService().printBossCheck(userId);
			session.setAttribute("cm", cm);
			session.setAttribute("club", clubBossCheck);
			response.sendRedirect("/index.jsp");
		}else {
			request.getRequestDispatcher("/club/Error.html").forward(request, response);
		}
		
	}

}
