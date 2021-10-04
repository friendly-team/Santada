package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import report.model.service.ReportService;
import report.model.vo.PageData;
import report.model.vo.Report;

/**
 * Servlet implementation class PointAddServlet
 */
@WebServlet("/admin/report")
public class AdminReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 0;
		String getCurrentPage = request.getParameter("currentPage");
		
		if(getCurrentPage ==null) {
			currentPage =1;
		}else {
			currentPage = Integer.parseInt(getCurrentPage);
		}
		PageData pd = new ReportService().printAdminReport(currentPage);
		List<Report> rList = pd.getrList();
		
		if(!rList.isEmpty()) {
			request.setAttribute("rList", rList);
			request.setAttribute("pageNavi", pd.getPageNavi());
			request.getRequestDispatcher("/WEB-INF/views/admin/reportmg.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/admin/reportmg.jsp").forward(request, response);
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] check = request.getParameterValues("check");
		int result = new ReportService().removeReport(check);
		if(result > 0) {
			int currentPage = 0;
			String getCurrentPage = request.getParameter("currentPage");
			
			if(getCurrentPage ==null) {
				currentPage =1;
			}else {
				currentPage = Integer.parseInt(getCurrentPage);
			}
			PageData pd = new ReportService().printAdminReport(currentPage);
			List<Report> rList = pd.getrList();
			
			if(!rList.isEmpty()) {
				request.setAttribute("rList", rList);		
				request.setAttribute("pageNavi", pd.getPageNavi());		
				response.sendRedirect("/admin/report");		
			}else {
				response.sendRedirect("/admin/report");	
			}
		}else {
			request.getRequestDispatcher("/WEB-INF/views/admin/reportmg.jsp").forward(request, response);
		}
	}

}
