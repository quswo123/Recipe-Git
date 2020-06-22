package com.recipe.vo;

public class RD {
	private String rdId; //아이디
	private String rdPwd; //비밀번호
	private String rdManagerName;//담당자이름
	private String rdTeamName;//부서이름
	private String rdPhone;//전화번호
	
	public RD() {}
	public RD(String rdId, String rdPwd, String rdManagerName, String rdTeamName, String rdPhone) {
		super();
		this.rdId = rdId;
		this.rdPwd = rdPwd;
		this.rdManagerName = rdManagerName;
		this.rdTeamName = rdTeamName;
		this.rdPhone = rdPhone;
	}
	

	public String getRdId() {
		return rdId;
	}


	public void setRdId(String rdId) {
		this.rdId = rdId;
	}


	public String getRdPwd() {
		return rdPwd;
	}


	public void setRdPwd(String rdPwd) {
		this.rdPwd = rdPwd;
	}


	public String getRdManagerName() {
		return rdManagerName;
	}


	public void setRdManagerName(String rdManagerName) {
		this.rdManagerName = rdManagerName;
	}


	public String getRdTeamName() {
		return rdTeamName;
	}


	public void setRdTeamName(String rdTeamName) {
		this.rdTeamName = rdTeamName;
	}


	public String getRdPhone() {
		return rdPhone;
	}


	public void setRdPhone(String rdPhone) {
		this.rdPhone = rdPhone;
	}


	@Override
	public String toString() {
		return "RD [rdId=" + rdId + ", rdPwd=" + rdPwd + ", rdManagerName=" + rdManagerName + ", rdTeamName="
				+ rdTeamName + ", rdPhone=" + rdPhone + "]";
	}
	
}
