package mountainRecommend.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mountainPost.model.vo.MountainPost;
import mountainRecommend.model.service.MountainRecommendService;
import mountainRecommend.model.vo.Mountain;
import mountainRecommend.model.vo.MountainRecommend;

/**
 * Servlet implementation class MountainListServlet
 */
// recommend 화면에서  search를 눌렀을때 하단에 post에서 끌어온 값을 연결해주는 서블릿
@WebServlet("/mountain/list")
public class MountainListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MountainListServlet() {
        super();
        // TODO Auto-generated constructor stub    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mountainRegion = request.getParameter("mountainRegion");
		int mountainTime = Integer.parseInt(request.getParameter("mountainTime"));
		int mountainLevel = Integer.parseInt(request.getParameter("mountainLevel"));
		String mountainCourse = request.getParameter("mountainCourse");
		
		List<MountainPost> pList = new MountainRecommendService().selectMountainPost(mountainRegion, mountainTime, mountainLevel);
		List<Mountain> mList = new MountainRecommendService().printMountain(mountainCourse);
		
		if(!pList.isEmpty()) {
			request.setAttribute("pList", pList);
			request.setAttribute("mList", mList);
			request.getRequestDispatcher("/mountain/list").forward(request, response);
		}else {
			response.sendRedirect("/WEB-INF/views/recommend/mountainrecommendError.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

}
