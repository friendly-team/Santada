package parking.model.vo;

public class ParkinglotInfo {
	
		private int parkinglotNo;
		private String mountainName;
		private String parkinglotName;
		private String parkinglotAddress;
		private String parkinglotTel;
		private String parkinglotOpenTime;
		private String parkinglotCloseTime;
		private String parkinglotPriceBig;
		private String parkinglotPriceSmall;
		private String parkinglotDayPriceBig;
		private String parkinglotDayPriceSmall;
		private String parkinglotGoogleMapX;
		private String parkinglotGoogleMapY;
		
		public ParkinglotInfo() {}

		public ParkinglotInfo(int parkinglotNo, String mountainName, String parkinglotName, String parkinglotAddress,
				String parkinglotTel, String parkinglotOpenTime, String parkinglotCloseTime, String parkinglotPriceBig,
				String parkinglotPriceSmall, String parkinglotDayPriceBig, String parkinglotDayPriceSmall,
				String parkinglotGoogleMapX, String parkinglotGoogleMapY) {
			super();
			this.parkinglotNo = parkinglotNo;
			this.mountainName = mountainName;
			this.parkinglotName = parkinglotName;
			this.parkinglotAddress = parkinglotAddress;
			this.parkinglotTel = parkinglotTel;
			this.parkinglotOpenTime = parkinglotOpenTime;
			this.parkinglotCloseTime = parkinglotCloseTime;
			this.parkinglotPriceBig = parkinglotPriceBig;
			this.parkinglotPriceSmall = parkinglotPriceSmall;
			this.parkinglotDayPriceBig = parkinglotDayPriceBig;
			this.parkinglotDayPriceSmall = parkinglotDayPriceSmall;
			this.parkinglotGoogleMapX = parkinglotGoogleMapX;
			this.parkinglotGoogleMapY = parkinglotGoogleMapY;
		}

		public int getParkinglotNo() {
			return parkinglotNo;
		}

		public void setParkinglotNo(int parkinglotNo) {
			this.parkinglotNo = parkinglotNo;
		}

		public String getMountainName() {
			return mountainName;
		}

		public void setMountainName(String mountainName) {
			this.mountainName = mountainName;
		}

		public String getParkinglotName() {
			return parkinglotName;
		}

		public void setParkinglotName(String parkinglotName) {
			this.parkinglotName = parkinglotName;
		}

		public String getParkinglotAddress() {
			return parkinglotAddress;
		}

		public void setParkinglotAddress(String parkinglotAddress) {
			this.parkinglotAddress = parkinglotAddress;
		}

		public String getParkinglotTel() {
			return parkinglotTel;
		}

		public void setParkinglotTel(String parkinglotTel) {
			this.parkinglotTel = parkinglotTel;
		}

		public String getParkinglotOpenTime() {
			return parkinglotOpenTime;
		}

		public void setParkinglotOpenTime(String parkinglotOpenTime) {
			this.parkinglotOpenTime = parkinglotOpenTime;
		}

		public String getParkinglotCloseTime() {
			return parkinglotCloseTime;
		}

		public void setParkinglotCloseTime(String parkinglotCloseTime) {
			this.parkinglotCloseTime = parkinglotCloseTime;
		}

		public String getParkinglotPriceBig() {
			return parkinglotPriceBig;
		}

		public void setParkinglotPriceBig(String parkinglotPriceBig) {
			this.parkinglotPriceBig = parkinglotPriceBig;
		}

		public String getParkinglotPriceSmall() {
			return parkinglotPriceSmall;
		}

		public void setParkinglotPriceSmall(String parkinglotPriceSmall) {
			this.parkinglotPriceSmall = parkinglotPriceSmall;
		}

		public String getParkinglotDayPriceBig() {
			return parkinglotDayPriceBig;
		}

		public void setParkinglotDayPriceBig(String parkinglotDayPriceBig) {
			this.parkinglotDayPriceBig = parkinglotDayPriceBig;
		}

		public String getParkinglotDayPriceSmall() {
			return parkinglotDayPriceSmall;
		}

		public void setParkinglotDayPriceSmall(String parkinglotDayPriceSmall) {
			this.parkinglotDayPriceSmall = parkinglotDayPriceSmall;
		}

		public String getParkinglotGoogleMapX() {
			return parkinglotGoogleMapX;
		}

		public void setParkinglotGoogleMapX(String parkinglotGoogleMapX) {
			this.parkinglotGoogleMapX = parkinglotGoogleMapX;
		}

		public String getParkinglotGoogleMapY() {
			return parkinglotGoogleMapY;
		}

		public void setParkinglotGoogleMapY(String parkinglotGoogleMapY) {
			this.parkinglotGoogleMapY = parkinglotGoogleMapY;
		}

		@Override
		public String toString() {
			return "ParkinglotInfo [parkinglotNo=" + parkinglotNo + ", mountainName=" + mountainName
					+ ", parkinglotName=" + parkinglotName + ", parkinglotAddress=" + parkinglotAddress
					+ ", parkinglotTel=" + parkinglotTel + ", parkinglotOpenTime=" + parkinglotOpenTime
					+ ", parkinglotCloseTime=" + parkinglotCloseTime + ", parkinglotPriceBig=" + parkinglotPriceBig
					+ ", parkinglotPriceSmall=" + parkinglotPriceSmall + ", parkinglotDayPriceBig="
					+ parkinglotDayPriceBig + ", parkinglotDayPriceSmall=" + parkinglotDayPriceSmall
					+ ", parkinglotGoogleMapX=" + parkinglotGoogleMapX + ", parkinglotGoogleMapY="
					+ parkinglotGoogleMapY + "]";
		}

		
		
		
		
}
