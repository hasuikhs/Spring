package spring.biz.user.vo;

public class UserVO {
	private String userid    ;
	private String username  ;
	private String userpwd   ;
	private String email     ;
	private String phone     ;
	private String address   ;
	
	public UserVO() {
		super();
	}
	public UserVO(String userid, String username, String userpwd, String email, String phone, String address) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "UserVO [userid=" + userid + ", username=" + username + ", userpwd=" + userpwd + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + "]";
	}
}
