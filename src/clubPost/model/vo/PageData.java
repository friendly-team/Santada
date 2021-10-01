package clubPost.model.vo;

import java.util.List;

public class PageData {
	private List<ClubPost> clubPostList;
	private String pageNavi;
	
	public PageData() {}

	public List<ClubPost> getClubPostList() {
		return clubPostList;
	}

	public void setClubPostList(List<ClubPost> clubPostList) {
		this.clubPostList = clubPostList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	@Override
	public String toString() {
		return "PageData [clubPostList=" + clubPostList + ", pageNavi=" + pageNavi + "]";
	}
	
	
}
