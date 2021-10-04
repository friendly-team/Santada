package parking.model.vo;

public class ParkinglotInfo {
	
		private int parkinglot_no;
		private String mountain_name;
		private String parkinglot_name;
		private String parkinglot_address;
		private String parkinglot_tel;
		private String parkinglot_open_time;
		private String parkinglot_close_time;
		private int parkinglot_price_big;
		private int parkinglot_price_small;
		private int parkinglot_dayprice_big;
		private int parkinglot_dayprice_small;
		private int parkinglot_google_map_x;
		private int parkinglot_google_map_y;
		
		public ParkinglotInfo() {}
		
		
		public ParkinglotInfo(int parkinglot_no, String mountain_name, String parkinglot_name,
				String parkinglot_address, String parkinglot_tel, String parkinglot_open_time,
				String parkinglot_close_time, int parkinglot_price_big, int parkinglot_price_small,
				int parkinglot_dayprice_big, int parkinglot_dayprice_small, int parkinglot_google_map_x,
				int parkinglot_google_map_y) {
			super();
			this.parkinglot_no = parkinglot_no;
			this.mountain_name = mountain_name;
			this.parkinglot_name = parkinglot_name;
			this.parkinglot_address = parkinglot_address;
			this.parkinglot_tel = parkinglot_tel;
			this.parkinglot_open_time = parkinglot_open_time;
			this.parkinglot_close_time = parkinglot_close_time;
			this.parkinglot_price_big = parkinglot_price_big;
			this.parkinglot_price_small = parkinglot_price_small;
			this.parkinglot_dayprice_big = parkinglot_dayprice_big;
			this.parkinglot_dayprice_small = parkinglot_dayprice_small;
			this.parkinglot_google_map_x = parkinglot_google_map_x;
			this.parkinglot_google_map_y = parkinglot_google_map_y;
		}
		public int getParkinglot_no() {
			return parkinglot_no;
		}
		public void setParkinglot_no(int parkinglot_no) {
			this.parkinglot_no = parkinglot_no;
		}
		public String getMountain_name() {
			return mountain_name;
		}
		public void setMountain_name(String mountain_name) {
			this.mountain_name = mountain_name;
		}
		public String getParkinglot_name() {
			return parkinglot_name;
		}
		public void setParkinglot_name(String parkinglot_name) {
			this.parkinglot_name = parkinglot_name;
		}
		public String getParkinglot_address() {
			return parkinglot_address;
		}
		public void setParkinglot_address(String parkinglot_address) {
			this.parkinglot_address = parkinglot_address;
		}
		public String getParkinglot_tel() {
			return parkinglot_tel;
		}
		public void setParkinglot_tel(String parkinglot_tel) {
			this.parkinglot_tel = parkinglot_tel;
		}
		public String getParkinglot_open_time() {
			return parkinglot_open_time;
		}
		public void setParkinglot_open_time(String parkinglot_open_time) {
			this.parkinglot_open_time = parkinglot_open_time;
		}
		public String getParkinglot_close_time() {
			return parkinglot_close_time;
		}
		public void setParkinglot_close_time(String parkinglot_close_time) {
			this.parkinglot_close_time = parkinglot_close_time;
		}
		public int getParkinglot_price_big() {
			return parkinglot_price_big;
		}
		public void setParkinglot_price_big(int parkinglot_price_big) {
			this.parkinglot_price_big = parkinglot_price_big;
		}
		public int getParkinglot_price_small() {
			return parkinglot_price_small;
		}
		public void setParkinglot_price_small(int parkinglot_price_small) {
			this.parkinglot_price_small = parkinglot_price_small;
		}
		public int getParkinglot_dayprice_big() {
			return parkinglot_dayprice_big;
		}
		public void setParkinglot_dayprice_big(int parkinglot_dayprice_big) {
			this.parkinglot_dayprice_big = parkinglot_dayprice_big;
		}
		public int getParkinglot_dayprice_small() {
			return parkinglot_dayprice_small;
		}
		public void setParkinglot_dayprice_small(int parkinglot_dayprice_small) {
			this.parkinglot_dayprice_small = parkinglot_dayprice_small;
		}
		public int getParkinglot_google_map_x() {
			return parkinglot_google_map_x;
		}
		public void setParkinglot_google_map_x(int parkinglot_google_map_x) {
			this.parkinglot_google_map_x = parkinglot_google_map_x;
		}
		public int getParkinglot_google_map_y() {
			return parkinglot_google_map_y;
		}
		public void setParkinglot_google_map_y(int parkinglot_google_map_y) {
			this.parkinglot_google_map_y = parkinglot_google_map_y;
		}
		@Override
		public String toString() {
			return "ParkinglotInfo [parkinglot_no=" + parkinglot_no + ", mountain_name=" + mountain_name
					+ ", parkinglot_name=" + parkinglot_name + ", parkinglot_address=" + parkinglot_address
					+ ", parkinglot_tel=" + parkinglot_tel + ", parkinglot_open_time=" + parkinglot_open_time
					+ ", parkinglot_close_time=" + parkinglot_close_time + ", parkinglot_price_big="
					+ parkinglot_price_big + ", parkinglot_price_small=" + parkinglot_price_small
					+ ", parkinglot_dayprice_big=" + parkinglot_dayprice_big + ", parkinglot_dayprice_small="
					+ parkinglot_dayprice_small + ", parkinglot_google_map_x=" + parkinglot_google_map_x
					+ ", parkinglot_google_map_y=" + parkinglot_google_map_y + "]";
		}
		
		
		
		
}
