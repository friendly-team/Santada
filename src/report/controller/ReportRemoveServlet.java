package report.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import report.model.service.ReportService;

/**
 * Servlet implementation class ReportRemoveServlet
 */
@WebServlet("/report/remove")
public class ReportRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportRemoveServlet() {
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
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String[] reportNo = request.getParameterValues("reportNo");
		
		int[]nums = new int[reportNo.length];
		for(int i=0; i<reportNo.length; i++) {
			nums[i] = Integer.parseInt(reportNo[i]);
		}
		
		int result = new ReportService().deleteReport(nums);
				
		if(result > 0) {
			// 성공하면 메인페이지로 이동!
			response.sendRedirect("/report/list");
		}else {
			// 실패하면 실패메시지 페이지로 이동!
			response.sendRedirect("/member/studentError.html");
		}
	}

}
