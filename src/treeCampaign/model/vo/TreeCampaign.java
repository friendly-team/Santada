package treeCampaign.model.vo;

import java.sql.Date;

public class TreeCampaign {
	private int treePostNo;
	private String treeUserId;
	private String treeParticipant;
	private String treeContents;
	private Date treeDate;
	
	public TreeCampaign() {}

	public int getTreePostNo() {
		return treePostNo;
	}

	public void setTreePostNo(int treePostNo) {
		this.treePostNo = treePostNo;
	}

	public String getTreeUserId() {
		return treeUserId;
	}

	public void setTreeUserId(String treeUserId) {
		this.treeUserId = treeUserId;
	}

	public String getTreeParticipant() {
		return treeParticipant;
	}

	public void setTreeParticipant(String treeParticipant) {
		this.treeParticipant = treeParticipant;
	}

	public String getTreeContents() {
		return treeContents;
	}

	public void setTreeContents(String treeContents) {
		this.treeContents = treeContents;
	}

	public Date getTreeDate() {
		return treeDate;
	}

	public void setTreeDate(Date treeDate) {
		this.treeDate = treeDate;
	}

	@Override
	public String toString() {
		return "TreeCampaign [treePostNo=" + treePostNo + ", treeUserId=" + treeUserId + ", treeParticipant="
				+ treeParticipant + ", treeContents=" + treeContents + ", treeDate=" + treeDate + "]";
	}
	
}
