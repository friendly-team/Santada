package main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mountainPost.model.service.MountainPostService;
import mountainPost.model.vo.MountainPost;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/show/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터를 화면상에 보여줌 (post에서 가져옴) 
		// index.jsp -> main.jsp로 연결 
		 //mountainPostNo를 받아와서 출력 
		// 1
		
		List<MountainPost> mList = new MountainPostService().printPostAll();
		if(!mList.isEmpty()) {
			// 성공하면 mList 데이터를 가지고 main.jsp로 이동
			request.setAttribute("mList", mList);
			// 경로가 숨겨진경우
			request.getRequestDispatcher("/WEB-INF/views/show/main.jsp").forward(request, response);
		}else {
			// 실패하면 실패페이지로 이동 (경로가 안숨겨짐)
			request.getRequestDispatcher("/WEB-INF/views/recommend/mountainrecommendError.html").forward(request, response);
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
