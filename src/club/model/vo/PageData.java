package club.model.vo;

import java.util.List;

public class PageData {
	private List<ClubManagement> cmList;
	private String pageNavi;
	
	public PageData() {}

	public List<ClubManagement> getCmList() {
		return cmList;
	}

	public void setCmList(List<ClubManagement> cmList) {
		this.cmList = cmList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	@Override
	public String toString() {
		return "PageData [cmList=" + cmList + ", pageNavi=" + pageNavi + "]";
	}
	
	

}