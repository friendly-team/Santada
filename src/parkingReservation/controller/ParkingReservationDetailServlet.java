package parkingReservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import parkingReservation.model.service.ParkingReservationService;
import parkingReservation.model.vo.ParkingReservation;

@WebServlet("/parkingReservation/detail")
public class ParkingReservationDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ParkingReservationDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reservationNo = Integer.parseInt(request.getParameter("reservationNo"));
		ParkingReservation pReOne = new ParkingReservationService().printOneByNo(reservationNo);
	
		//예약 취소 화면 보여주기 취소 누르면 거기서 또 예약 내역 으로 이동 또는 메인화면으로 이동
		if(pReOne != null) {
			 request.setAttribute("pReOne", pReOne);
			 request.getRequestDispatcher("/WEB-INF/views/parkinglot/parkinglotReCancel.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/parkinglot/error.html").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
