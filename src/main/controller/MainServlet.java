package main.controller;

import java.io.IOException;
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
		
		// mountainPostNo를 받아와서 출력 
		int mountainPostNo = Integer.parseInt(request.getParameter("mountainPostNo")); // 이걸 가져와야 뭘 하지,
		MountainPost mPost = new MountainPostService().printMainPost(mountainPostNo);
		if(mPost != null) {
			request.setAttribute("mountainPostNo", mPost);
			request.getRequestDispatcher("/WEB-INF/views/show/main.jsp").forward(request, response);
		}else {
			response.sendRedirect("/recommend/mountainRecommendError.html");
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
