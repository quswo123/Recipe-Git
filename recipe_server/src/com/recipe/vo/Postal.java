package com.recipe.vo;

public class Postal {
	private String buildingno; //건물관리번호 pk
	private String zipcode;  //우편번호
	private String sido;
	private String sigungu;
	private String eupmyun;
	private String dorocode;
	private String doro;
	private String jiha;
	private String building1;
	private String building2;
	private String daryang;
	private String building;
	private String dongcode;
	private String dong;
	private String ri;
	private String dongadmin;
	private String san;
	private String zibun1;
	private String zibunserical;
	private String zibun2;
	private String zipIdcode;
	private String zipcodeserial;
	
	public Postal() {}

	public Postal(String buildingno, String zipcode, String sido, String sigungu, String eupmyun, String dorocode,
			String doro, String jiha, String building1, String building2, String daryang, String building,
			String dongcode, String dong, String ri, String dongadmin, String san, String zibun1, String zibunserical,
			String zibun2, String zipIdcode, String zipcodeserial) {
		super();
		this.buildingno = buildingno;
		this.zipcode = zipcode;
		this.sido = sido;
		this.sigungu = sigungu;
		this.eupmyun = eupmyun;
		this.dorocode = dorocode;
		this.doro = doro;
		this.jiha = jiha;
		this.building1 = building1;
		this.building2 = building2;
		this.daryang = daryang;
		this.building = building;
		this.dongcode = dongcode;
		this.dong = dong;
		this.ri = ri;
		this.dongadmin = dongadmin;
		this.san = san;
		this.zibun1 = zibun1;
		this.zibunserical = zibunserical;
		this.zibun2 = zibun2;
		this.zipIdcode = zipIdcode;
		this.zipcodeserial = zipcodeserial;
	}

	public String getBuildingno() {
		return buildingno;
	}

	public void setBuildingno(String buildingno) {
		this.buildingno = buildingno;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getSigungu() {
		return sigungu;
	}

	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}

	public String getEupmyun() {
		return eupmyun;
	}

	public void setEupmyun(String eupmyun) {
		this.eupmyun = eupmyun;
	}

	public String getDorocode() {
		return dorocode;
	}

	public void setDorocode(String dorocode) {
		this.dorocode = dorocode;
	}

	public String getDoro() {
		return doro;
	}

	public void setDoro(String doro) {
		this.doro = doro;
	}

	public String getJiha() {
		return jiha;
	}

	public void setJiha(String jiha) {
		this.jiha = jiha;
	}

	public String getBuilding1() {
		return building1;
	}

	public void setBuilding1(String building1) {
		this.building1 = building1;
	}

	public String getBuilding2() {
		return building2;
	}

	public void setBuilding2(String building2) {
		this.building2 = building2;
	}

	public String getDaryang() {
		return daryang;
	}

	public void setDaryang(String daryang) {
		this.daryang = daryang;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getDongcode() {
		return dongcode;
	}

	public void setDongcode(String dongcode) {
		this.dongcode = dongcode;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getRi() {
		return ri;
	}

	public void setRi(String ri) {
		this.ri = ri;
	}

	public String getDongadmin() {
		return dongadmin;
	}

	public void setDongadmin(String dongadmin) {
		this.dongadmin = dongadmin;
	}

	public String getSan() {
		return san;
	}

	public void setSan(String san) {
		this.san = san;
	}

	public String getZibun1() {
		return zibun1;
	}

	public void setZibun1(String zibun1) {
		this.zibun1 = zibun1;
	}

	public String getZibunserical() {
		return zibunserical;
	}

	public void setZibunserical(String zibunserical) {
		this.zibunserical = zibunserical;
	}

	public String getZibun2() {
		return zibun2;
	}

	public void setZibun2(String zibun2) {
		this.zibun2 = zibun2;
	}

	public String getZipIdcode() {
		return zipIdcode;
	}

	public void setZipIdcode(String zipIdcode) {
		this.zipIdcode = zipIdcode;
	}

	public String getZipcodeserial() {
		return zipcodeserial;
	}

	public void setZipcodeserial(String zipcodeserial) {
		this.zipcodeserial = zipcodeserial;
	}

	@Override
	public String toString() {
		return "Postal [buildingno=" + buildingno + ", zipcode=" + zipcode + ", sido=" + sido + ", sigungu=" + sigungu
				+ ", eupmyun=" + eupmyun + ", dorocode=" + dorocode + ", doro=" + doro + ", jiha=" + jiha
				+ ", building1=" + building1 + ", building2=" + building2 + ", daryang=" + daryang + ", building="
				+ building + ", dongcode=" + dongcode + ", dong=" + dong + ", ri=" + ri + ", dongadmin=" + dongadmin
				+ ", san=" + san + ", zibun1=" + zibun1 + ", zibunserical=" + zibunserical + ", zibun2=" + zibun2
				+ ", zipIdcode=" + zipIdcode + ", zipcodeserial=" + zipcodeserial + "]";
	}
	
	
}
