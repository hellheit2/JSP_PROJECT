package user.vo;

import java.sql.Timestamp;
import java.util.List;

public class UserVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Timestamp joinDate;
	private List<String> wishList;
	
	public UserVO() {}
	public UserVO(String id, String pwd, String name, String email) { //회원가입(번호,날짜 제외)
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}
	public UserVO(String id, String pwd, String name, String email, Timestamp joinDate) {//로그인(번호,날짜 제외)
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.joinDate = joinDate;
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
	
	public List<String> getWishList() {
		return wishList;
	}
	public void setWishList(List<String> wishList) {
		this.wishList = wishList;
	}
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email
				+ ", joinDate=" + joinDate + ", wishList=" + wishList + "]";
	}
	
	
	
}
