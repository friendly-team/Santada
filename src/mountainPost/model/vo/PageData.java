package mountainPost.model.vo;

import java.util.List;

public class PageData {
	private List<MountainPost> mList;
	private String pageNavi;
	
	public PageData() {}

	public List<MountainPost> getmList() {
		return mList;
	}

	public void setmList(List<MountainPost> mList) {
		this.mList = mList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	@Override
	public String toString() {
		return "PageData [mList=" + mList + ", pageNavi=" + pageNavi + "]";
	}
	
}
