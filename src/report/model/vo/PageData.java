package report.model.vo;

import java.util.List;

public class PageData {
	private List<Report> rList;
	private String pageNavi;
	
	public PageData() {}

	public List<Report> getrList() {
		return rList;
	}

	public void setrList(List<Report> rList) {
		this.rList = rList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	@Override
	public String toString() {
		return "PageData [rList=" + rList + ", pageNavi=" + pageNavi + "]";
	}
	
	
}
