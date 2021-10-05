package mountainRecommend.controller;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		String mountainCourse = null;
		int j = 0;
		Random random = new Random();

		
		String mountainRegion = request.getParameter("mountainRegion");
		int mountainTime = Integer.parseInt(request.getParameter("mountainTime"));
		int mountainLevel = Integer.parseInt(request.getParameter("mountainLevel"));
		
		
		// 코스 랜덤 출력
		List<Mountain> mList = new MountainRecommendService().printMountain(mountainRegion);
		j = new MountainRecommendService().getRandomNumber(mountainRegion);
		int index = (int)(Math.random()*j);
		//if(mList.size() != 0) { 
		Mountain mountain =  mList.get(index);
		mountainCourse = mountain.getMountainCourse();

				
		//}
		
		// MountainCourse = mList.get(i).getMountainCourse();
		List<MountainPost> pList = new MountainRecommendService().selectMountainPost(mountainCourse, mountainRegion, mountainTime, mountainLevel);
		
		if(!pList.isEmpty()) {
			request.setAttribute("mList", mList);
			request.setAttribute("pList", pList);
			request.getRequestDispatcher("/WEB-INF/views/recommend/mountainrecommend.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/recommend/mountainrecommend.jsp").forward(request, response);
			//response.sendRedirect("/recommend/mountainrecommend.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

}
