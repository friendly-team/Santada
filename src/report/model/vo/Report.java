package report.model.vo;

import java.util.List;


public class Report {

	
	private int reportNo;
	private String userId;
	private String postType;
	private String reportType;
	private String reportTitle;
	private String reportContents;
	private int answer;
	private int mountainPostNo;
	private int groupPostNo;
	private List<Report> report;
	
	public Report() {}

	
	public List<Report> getReport() {
		return report;
	}


	public void setReport(List<Report> report) {
		this.report = report;
	}


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

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public int getMountainPostNo() {
		return mountainPostNo;
	}

	public void setMountainPostNo(int mountainPostNo) {
		this.mountainPostNo = mountainPostNo;
	}

	public int getGroupPostNo() {
		return groupPostNo;
	}

	public void setGroupPostNo(int groupPostNo) {
		this.groupPostNo = groupPostNo;
	}

	@Override
	public String toString() {
		return "Report [reportNo=" + reportNo + ", userId=" + userId + ", postType=" + postType + ", reportType="
				+ reportType + ", reportTitle=" + reportTitle + ", reportContents=" + reportContents + ", answer="
				+ answer + ", mountainPostNo=" + mountainPostNo + ", groupPostNo=" + groupPostNo + "]";
	}
	
	
	
}