package parking.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import parking.model.service.ParkinglotInfoService;
import parking.model.vo.ParkinglotInfo;

/**
 * Servlet implementation class parkinglotInfoServlet
 */
@WebServlet("/parkinglotInfo/Detail")
public class ParkinglotInfoDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParkinglotInfoDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parkinglotNo = request.getParameter("PARKINGLOT_NO");
		ParkinglotInfo pInfo = new ParkinglotInfoService().Detail(parkinglotNo);
		
		if(pInfo != null) {
			request.setAttribute("pInfo", pInfo);
			request.getRequestDispatcher("/WEB-INF/views/parkinglot/parkinglotInfo.jsp").forward(request, response);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/parkinglot/error.html");
			view.forward(request, response);
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
