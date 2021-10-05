package treeCampaign.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;
import treeCampaign.model.service.TreeCampaignService;
import treeCampaign.model.vo.TreeCampaign;

/**
 * Servlet implementation class TreeCampaignWriteServlet
 */
@WebServlet("/treeCampaign/write")
public class TreeCampaignWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TreeCampaignWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		Member member = new TreeCampaignService().printMember(userId);
		if(member != null) {
			request.setAttribute("member", member);
			request.getRequestDispatcher("/WEB-INF/views/tree-campaign/treeCampaignWrite.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		String treeParticipant = request.getParameter("tree-participant");
		String treeContents = request.getParameter("tree-con");
		int treePoint = Integer.parseInt(request.getParameter("tree-point"));
		TreeCampaign tCampaign = new TreeCampaign();
		tCampaign.setTreeUserId(userId);
		tCampaign.setTreeParticipant(treeParticipant);
		tCampaign.setTreeContents(treeContents);
		Member member = new Member();
		member.setUserId(userId);
		int result = new TreeCampaignService().registerTreeCampaign(tCampaign, member, treePoint);
		if(result > 500) {
			response.sendRedirect("/index.jsp");
		} else {
			response.sendRedirect("/treeCampaign/write");
		}
	}

}
