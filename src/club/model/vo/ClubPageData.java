package club.model.vo;

import java.util.List;

public class ClubPageData {
	private List<Club> cList;
	private String pageNavi;
	
	public ClubPageData() {}
	
	public ClubPageData(List<Club> cList, String pageNavi) {
		super();
		this.cList = cList;
		this.pageNavi = pageNavi;
	}

	public List<Club> getcList() {
		return cList;
	}

	public void setcList(List<Club> cList) {
		this.cList = cList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	@Override
	public String toString() {
		return "ClubPageData [cList=" + cList + ", pageNavi=" + pageNavi + "]";
	}
	
}
