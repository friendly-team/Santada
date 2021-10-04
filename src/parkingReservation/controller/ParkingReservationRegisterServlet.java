package parkingReservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import parkingReservation.model.service.ParkingReservationService;
import parkingReservation.model.vo.ParkingReservation;


@WebServlet("/parkingReservation/register")
public class ParkingReservationRegisterServlet extends HttpServlet {
	
       
    
    public ParkingReservationRegisterServlet() {}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/parkinglot/parkinglotRe.jsp").forward(request, response);
		}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int reservationNo = Integer.parseInt(request.getParameter("reservation_no"));
		String userId = request.getParameter("user_id");
		String mountainName = request.getParameter("mountain_name");
		String reservationStartTime = request.getParameter("reservation_Starttime");
		String reservationEndTime = request.getParameter("reservation_Endtime");
		String reservationCar = request.getParameter("reservation_car_type");
		String reservationPay = request.getParameter("reservation_pay_type");
		int reservationTotalPrice  = Integer.parseInt (request.getParameter("reservationPayTotalPrice"));
		String reservationCancel = request.getParameter("reservation_cancel_yn");
		String reservationStartdate = request.getParameter("reservation_start_date");
		String reservationEnddate = request.getParameter("reservation_end_date");
		
		ParkingReservation pReservation = new ParkingReservation(reservationNo, userId, mountainName, reservationStartTime, reservationEndTime, reservationCar, reservationPay, reservationTotalPrice, reservationCancel, reservationStartdate, reservationEnddate);
		int result = new ParkingReservationService().registerParkingReservation(pReservation);
	
		if(result > 0 ) {
			response.sendRedirect("/WEB-INF/views/parkinglot/parkinglotInfo.jsp");
		}else {
			response.sendRedirect("/WEB-INF/views/parkinglot/error.html");
		
		}
	}
}
