package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;
import treeCampaign.model.service.TreeCampaignService;
import treeCampaign.model.vo.TreeCampaign;

/**
 * Servlet implementation class PointListServlet
 */
@WebServlet("/admin/point")
public class PointListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PointListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TreeCampaign> tList = new TreeCampaignService().printPointList();
		if(!tList.isEmpty()) {
			// 성공하면 sList 데이터를 가지고 memberList.jsp로 이동
			request.setAttribute("tList", tList);
			request.getRequestDispatcher("/WEB-INF/views/admin/treecampaignmg.jsp").forward(request, response);
		}else {
			// 실패하면 실패페이지로 이동
			response.sendRedirect("/member/StudentError.html");
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
