package parkingReservation.model.vo;

public class ParkingReservation {

	private int reservationNo;
	private String userId;
	private String mountainName;
	private String reservationStartTime;
	private String reservationEndTime;
	private String reservationCarType;
	private String reservationPayTpye;
	private int reservationPayTotalPrice;
	private String reservationCancel;
	private String reservationStartDate;
	private String reservationEndDate;
	
	public ParkingReservation() {}

	public ParkingReservation(int reservationNo, String userId, String mountainName, String reservationStartTime,
			String reservationEndTime, String reservationCarType, String reservationPayTpye,
			int reservationPayTotalPrice, String reservationCancel, String reservationStartDate,
			String reservationEndDate) {
		super();
		this.reservationNo = reservationNo;
		this.userId = userId;
		this.mountainName = mountainName;
		this.reservationStartTime = reservationStartTime;
		this.reservationEndTime = reservationEndTime;
		this.reservationCarType = reservationCarType;
		this.reservationPayTpye = reservationPayTpye;
		this.reservationPayTotalPrice = reservationPayTotalPrice;
		this.reservationCancel = reservationCancel;
		this.reservationStartDate = reservationStartDate;
		this.reservationEndDate = reservationEndDate;
	}

	public int getReservationNo() {
		return reservationNo;
	}

	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMountainName() {
		return mountainName;
	}

	public void setMountainName(String mountainName) {
		this.mountainName = mountainName;
	}

	public String getReservationStartTime() {
		return reservationStartTime;
	}

	public void setReservationStartTime(String reservationStartTime) {
		this.reservationStartTime = reservationStartTime;
	}

	public String getReservationEndTime() {
		return reservationEndTime;
	}

	public void setReservationEndTime(String reservationEndTime) {
		this.reservationEndTime = reservationEndTime;
	}

	public String getReservationCarType() {
		return reservationCarType;
	}

	public void setReservationCarType(String reservationCarType) {
		this.reservationCarType = reservationCarType;
	}

	public String getReservationPayTpye() {
		return reservationPayTpye;
	}

	public void setReservationPayTpye(String reservationPayTpye) {
		this.reservationPayTpye = reservationPayTpye;
	}

	public int getReservationPayTotalPrice() {
		return reservationPayTotalPrice;
	}

	public void setReservationPayTotalPrice(int reservationPayTotalPrice) {
		this.reservationPayTotalPrice = reservationPayTotalPrice;
	}

	public String getReservationCancel() {
		return reservationCancel;
	}

	public void setReservationCancel(String reservationCancel) {
		this.reservationCancel = reservationCancel;
	}

	public String getReservationStartDate() {
		return reservationStartDate;
	}

	public void setReservationStartDate(String reservationStartDate) {
		this.reservationStartDate = reservationStartDate;
	}

	public String getReservationEndDate() {
		return reservationEndDate;
	}

	public void setReservationEndDate(String reservationEndDate) {
		this.reservationEndDate = reservationEndDate;
	}

	@Override
	public String toString() {
		return "ParkingReservation [reservationNo=" + reservationNo + ", userId=" + userId + ", mountainName="
				+ mountainName + ", reservationStartTime=" + reservationStartTime + ", reservationEndTime="
				+ reservationEndTime + ", reservationCarType=" + reservationCarType + ", reservationPayTpye="
				+ reservationPayTpye + ", reservationPayTotalPrice=" + reservationPayTotalPrice + ", reservationCancel="
				+ reservationCancel + ", reservationStartDate=" + reservationStartDate + ", reservationEndDate="
				+ reservationEndDate + "]";
	}


	}




