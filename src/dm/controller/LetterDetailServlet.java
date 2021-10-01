package dm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dm.model.service.DmService;
import dm.model.vo.Dm;

/**
 * Servlet implementation class LetterDetailServlet
 */
@WebServlet("/letter/detail")
public class LetterDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LetterDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int letterNo = Integer.parseInt(request.getParameter("letterNo"));
		Dm LetterOne = new DmService().printOneByNo(letterNo);
		
		if(LetterOne != null) {
			// 성공하면 디테일 페이지
			request.setAttribute("LetterOne", LetterOne);
			// NoticeReply setAttribute 해줌
			request.getRequestDispatcher("/WEB-INF/views/DM/LetterDetail.jsp")
			.forward(request, response);
		}else {
			// 실패하면 에러페이지
			request.getRequestDispatcher("/index.jsp")
			.forward(request, response);
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
