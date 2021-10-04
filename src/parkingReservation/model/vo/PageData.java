package parkingReservation.model.vo;

import java.util.List;

public class PageData {

	private List<ParkingReservation> pReList;
	private String pageNavi;
	
	public PageData() {}

	public List<ParkingReservation> getpReList() {
		return pReList;
	}

	public void setpReList(List<ParkingReservation> pReList) {
		this.pReList = pReList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	@Override
	public String toString() {
		return "PageData [pReList=" + pReList + ", pageNavi=" + pageNavi + "]";
	}
	
	
	
	
	
	
	
}
