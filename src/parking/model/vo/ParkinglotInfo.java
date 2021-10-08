package parking.model.vo;

public class ParkinglotInfo {
	
		private int parkinglotNo;
		private String mountainName;
		private String parkinglotName;
		private String parkinglotAddress;
		private String parkinglotTel;
		private String parkinglotOpenTime;
		private String parkinglotCloseTime;
		private int parkinglotPriceBig;
		private int parkinglotPriceSmall;
		private int parkinglotDayPriceBig;
		private int parkinglotDayPriceSmall;
		private int parkinglotGoogleMapX;
		private int parkinglotGoogleMapY;
		
		public ParkinglotInfo() {}

		public ParkinglotInfo(int parkinglotNo, String mountainName, String parkinglotName, String parkinglotAddress,
				String parkinglotTel, String parkinglotOpenTime, String parkinglotCloseTime, int parkinglotPriceBig,
				int parkinglotPriceSmall, int parkinglotDayPriceBig, int parkinglotDayPriceSmall,
				int parkinglotGoogleMapX, int parkinglotGoogleMapY) {
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

		public int getParkinglotNno() {
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

		public int getParkinglotPriceBig() {
			return parkinglotPriceBig;
		}

		public void setParkinglotPriceBig(int parkinglotPriceBig) {
			this.parkinglotPriceBig = parkinglotPriceBig;
		}

		public int getParkinglotPriceSmall() {
			return parkinglotPriceSmall;
		}

		public void setParkinglotPriceSmall(int parkinglotPriceSmall) {
			this.parkinglotPriceSmall = parkinglotPriceSmall;
		}

		public int getParkinglotDayPriceBig() {
			return parkinglotDayPriceBig;
		}

		public void setParkinglotDayPriceBig(int parkinglotDayPriceBig) {
			this.parkinglotDayPriceBig = parkinglotDayPriceBig;
		}

		public int getParkinglotDayPriceSmall() {
			return parkinglotDayPriceSmall;
		}

		public void setParkinglotDayPriceSmall(int parkinglotDayPriceSmall) {
			this.parkinglotDayPriceSmall = parkinglotDayPriceSmall;
		}

		public int getParkinglotGoogleMapX() {
			return parkinglotGoogleMapX;
		}

		public void setParkinglotGoogleMapX(int parkinglotGoogleMapX) {
			this.parkinglotGoogleMapX = parkinglotGoogleMapX;
		}

		public int getParkinglotGoogleMapY() {
			return parkinglotGoogleMapY;
		}

		public void setParkinglotGoogleMapY(int parkinglotGoogleMapY) {
			this.parkinglotGoogleMapY = parkinglotGoogleMapY;
		}

		@Override
		public String toString() {
			return "ParkinglotInfo [parkinglotNno=" + parkinglotNo + ", mountainName=" + mountainName
					+ ", parkinglotName=" + parkinglotName + ", parkinglotAddress=" + parkinglotAddress
					+ ", parkinglotTel=" + parkinglotTel + ", parkinglotOpenTime=" + parkinglotOpenTime
					+ ", parkinglotCloseTime=" + parkinglotCloseTime + ", parkinglotPriceBig=" + parkinglotPriceBig
					+ ", parkinglotPriceSmall=" + parkinglotPriceSmall + ", parkinglotDayPriceBig="
					+ parkinglotDayPriceBig + ", parkinglotDayPriceSmall=" + parkinglotDayPriceSmall
					+ ", parkinglotGoogleMapX=" + parkinglotGoogleMapX + ", parkinglotGoogleMapY="
					+ parkinglotGoogleMapY + "]";
		}
}
