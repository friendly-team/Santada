package member.model.vo;

import java.sql.Date;

public class Member {


		private String userId;
		private String userPwd;
		private String userName;
		private String userEmail;
		private String userPhone;
		private Date enrollDate;

		public Member() {}
		
		public Member(String userId, String userPwd, String userName, String userPhone, String userEmail) {
			super();
			this.userId = userId;
			this.userPwd = userPwd;
			this.userName = userName;
			this.userPhone = userPhone;
			this.userEmail = userEmail;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getUserPwd() {
			return userPwd;
		}
		public void setUserPwd(String userPwd) {
			this.userPwd = userPwd;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserEmail() {
			return userEmail;
		}
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
		public String getUserPhone() {
			return userPhone;
		}
		public void setUserPhone(String userPhone) {
			this.userPhone = userPhone;
		}
		public Date getEnrollDate() {
			return enrollDate;
		}
		public void setEnrollDate(Date enrollDate) {
			this.enrollDate = enrollDate;
		}
		@Override
		public String toString() {
			return "Member [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", userEmail="
					+ userEmail + ", userPhone=" + userPhone + ", enrollDate=" + enrollDate + "]";
		}
		
}