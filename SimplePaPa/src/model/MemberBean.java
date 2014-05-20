package model;

public class MemberBean {

	//共10欄 無序號ID  圖片不放bean 註冊時間不放
	
	
	private String account;
	private String name;
	private String mPassword;
	private java.util.Date birth;
	private String email;
	private String sex;
	private String phone;
	private String mAddress;
	private int mTypeId;
	private int mStatusId;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getmAddress() {
		return mAddress;
	}

	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}

	public int getmTypeId() {
		return mTypeId;
	}
	
	public void setmTypeId(int mTypeId) {
		this.mTypeId = mTypeId;
	}

	public int getmStatusId() {
		return mStatusId;
	}

	public void setmStatusId(int mStatusId) {
		this.mStatusId = mStatusId;
	}

	public static void main(String[] args) {
	
	}

	public java.util.Date getBirth() {
		return birth;
	}

	public void setBirth(java.util.Date birth) {
		this.birth = birth;
	}
	
}
