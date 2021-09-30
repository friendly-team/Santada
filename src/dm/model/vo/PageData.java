package dm.model.vo;

import java.util.List;

public class PageData {
	private List<Dm> letterList;
	private String pageNavi;
	
	public PageData() {}

	public List<Dm> getletterList() {
		return letterList;
	}

	public void setletterList(List<Dm> letterList) {
		this.letterList = letterList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	@Override
	public String toString() {
		return "PageData [letterList=" + letterList + ", pageNavi=" + pageNavi + "]";
	}

	
	
	
}
