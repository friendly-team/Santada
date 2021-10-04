package parkingReservation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import parkingReservation.model.service.ParkingReservationService;
import parkingReservation.model.vo.PageData;
import parkingReservation.model.vo.ParkingReservation;

@WebServlet("/parkingReservation/list")
public class ParkingReservationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ParkingReservationListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 0;
		String getCurrentPage = request.getParameter("currentPage");
		if(getCurrentPage == null) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(getCurrentPage);
		}
		PageData pagedata = new ParkingReservationService().printAllparkinglotReservation(currentPage);
		List<ParkingReservation> pList = pagedata.getpReList();
		if(!pList.isEmpty()) {
			request.setAttribute("pList", pList);
			request.setAttribute("pageNavi",pagedata.getPageNavi());
			request.getRequestDispatcher("/WEB-INF/views/parkinglot/parkinglotReList.jsp").forward(request, response);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/parkinglot/error.html");
			view.forward(request,response);
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
