package parkingReservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import parkingReservation.model.service.ParkingReservationService;
import parkingReservation.model.vo.ParkingReservation;

@WebServlet("/parkingReservation/Update")
public class ParkingReservationUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ParkingReservationUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int reservationNo = Integer.parseInt(request.getParameter("reservationNo"));
		String userId = request.getParameter("userId");
		String mountainName = request.getParameter("mountainName");
		String reservationCarType = request.getParameter("reservationCarType");
		String reservationStartDate = request.getParameter("reservationStartDate");
		String reservationEndDate = request.getParameter("reservationEndDate");
		String reservationStartTime = request.getParameter("reservationStartTime");
		String reservationEndTime = request.getParameter("reservationEndTime");
		String reservationCancel = request.getParameter("reservationCancel");
		
		ParkingReservation parkingreservation = new ParkingReservation();
//		parkingreservation.setReservationNo(reservationNo);
//		parkingreservation.setUserId(userId);
//		parkingreservation.setMountainName(mountainName);
//		parkingreservation.setReservationCarType(reservationCarType);
//		parkingreservation.setReservationStartDate(reservationStartDate);
//		parkingreservation.setReservationEndDate(reservationEndDate);
//		parkingreservation.setReservationStartTime(reservationStartTime);
//		parkingreservation.setReservationEndTime(reservationEndTime);
		parkingreservation.setReservationCancel(reservationCancel);
		int result = new ParkingReservationService().modifyParkingReservation(parkingreservation);
		if(result > 0) {
			response.sendRedirect("/parkingReservation/list");
		} else {
			request.getRequestDispatcher("/WEB-INF/views/parkinglot/error.html");
		}
	}
}
