package report.model.vo;

import java.sql.Date;
import java.util.List;


public class Report {

	
	private int reportNo;
	private String userId;
	private String postType;
	private String reportType;
	private String reportTitle;
	private String reportContents;
	private String answer;
	private int PostNo;
	private Date reportDate;

	public Report() {}

	public int getReportNo() {
		return reportNo;
	}


	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPostType() {
		return postType;
	}


	public void setPostType(String postType) {
		this.postType = postType;
	}


	public String getReportType() {
		return reportType;
	}


	public void setReportType(String reportType) {
		this.reportType = reportType;
	}


	public String getReportTitle() {
		return reportTitle;
	}


	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}


	public String getReportContents() {
		return reportContents;
	}


	public void setReportContents(String reportContents) {
		this.reportContents = reportContents;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public int getPostNo() {
		return PostNo;
	}


	public void setPostNo(int postNo) {
		PostNo = postNo;
	}


	public Date getReportDate() {
		return reportDate;
	}


	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}


	@Override
	public String toString() {
		return "Report [reportNo=" + reportNo + ", userId=" + userId + ", postType=" + postType + ", reportType="
				+ reportType + ", reportTitle=" + reportTitle + ", reportContents=" + reportContents + ", answer="
				+ answer + ", PostNo=" + PostNo + ", reportDate=" + reportDate + "]";
	}

}