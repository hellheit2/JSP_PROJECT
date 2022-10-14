package vo;

import java.sql.Timestamp;

public class UserVO {
	private int uno;
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Timestamp joinDate;
	
	public UserVO() {}
	public UserVO(String id, String pwd, String name, String email) { //회원가입(번호,날짜 제외)
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}
	public UserVO(int uno, String id, String pwd, String name, String email, Timestamp joinDate) {//로그인(번호,날짜 제외)
		super();
		this.uno = uno;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.joinDate = joinDate;
	}
	
	public int getUno() {
		return uno;
	}
	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public Timestamp getJoinDate() {
		return joinDate;
	}
	@Override
	public String toString() {
		return "UserVO [uno=" + uno + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email
				+ ", joinDate=" + joinDate + "]";
	}
	
	
	
}
