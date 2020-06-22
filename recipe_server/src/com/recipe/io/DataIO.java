package com.recipe.io;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.recipe.vo.Customer;
import com.recipe.vo.Favorite;
import com.recipe.vo.Ingredient;
import com.recipe.vo.Point;
import com.recipe.vo.Postal;
import com.recipe.vo.Purchase;
import com.recipe.vo.PurchaseDetail;
import com.recipe.vo.RD;
import com.recipe.vo.RecipeInfo;
import com.recipe.vo.RecipeIngredient;
import com.recipe.vo.Review;

public class DataIO {
	private DataOutputStream dos;
	private DataInputStream dis;	
	
	public DataIO(DataOutputStream dos, DataInputStream dis) {
		super();
		this.dos = dos;
		this.dis = dis;
	}
	
	/**
	 * "success" 메시지를 전송한다 (Server -> Client)
	 * @throws IOException
	 */
	public void sendSuccess() throws IOException{
		dos.writeUTF("success");
	}
	/**
	 * "success" 메시지를 전송한다 (Server -> Client)
	 * @param msg "success" 메시지 전송 후 보낼 메시지 내용
	 * @throws IOException
	 */
	public void sendSuccess(String msg) throws IOException {
		dos.writeUTF("success");
		dos.writeUTF(msg);
	}
	/**
	 * "fail" 메시지를 전송한다 (Server -> Client)
	 * @param msg "fail" 메시지 전송 후 보낼 메시지 내용
	 * @throws IOException
	 */
	public void sendFail(String msg) throws IOException {
		dos.writeUTF("fail");
		dos.writeUTF(msg);
	}
	/**
	 * 메시지를 전송한다
	 * @param str 보낼 메시지 내용
	 * @throws IOException
	 */
	public void send(String str) throws IOException {
		dos.writeUTF(str);
	}
	/**
	 * 메뉴 번호를 전송한다
	 * @param menuNo 보낼 메뉴 번호
	 * @throws IOException
	 */
	public void sendMenu(int menuNo) throws IOException {
		dos.writeInt(menuNo);
	}
	/**
	 * VO 객체 Customer의 내용들을 전송한다
	 * @param c 정보를 전송할 Customer
	 * @throws IOException
	 */
	public void send(Customer c) throws IOException {
		dos.writeUTF(c.getCustomerId());
		dos.writeUTF(c.getCustomerPwd());
		dos.writeUTF(c.getCustomerName());
		dos.writeUTF(c.getCustomerEmail());
		dos.writeUTF(c.getCustomerPhone());
		send(c.getPostal());
		dos.writeUTF(c.getCustomerAddr());
	}
	/**
	 * Customer List를 전송한다
	 * @param list 보낼 Customer들을 가진 List
	 * @throws IOException
	 */
	public void sendCustomers(List<Customer> list) throws IOException {
		dos.writeInt(list.size());
		for(Customer c: list) send(c);
	}
	/**
	 * VO 객체 Postal의 내용들을 전송한다
	 * @param p 정보를 전송할 Postal
	 * @throws IOException
	 */
	public void send(Postal p) throws IOException {
		dos.writeUTF(p.getBuildingno());
		dos.writeUTF(p.getZipcode());
		dos.writeUTF(p.getSido());
		dos.writeUTF(p.getSigungu());
		dos.writeUTF(p.getEupmyun());
		dos.writeUTF(p.getDorocode());
		dos.writeUTF(p.getDoro());
		dos.writeUTF(p.getJiha());
		dos.writeUTF(p.getBuilding1());
		dos.writeUTF(p.getBuilding2());
		dos.writeUTF(p.getDaryang());
		dos.writeUTF(p.getBuilding());
		dos.writeUTF(p.getDongcode());
		dos.writeUTF(p.getDong());
		dos.writeUTF(p.getRi());
		dos.writeUTF(p.getDongadmin());
		dos.writeUTF(p.getSan());
		dos.writeUTF(p.getZibun1());
		dos.writeUTF(p.getZibunserical());
		dos.writeUTF(p.getZibun2());
		dos.writeUTF(p.getZipIdcode());
		dos.writeUTF(p.getZipcodeserial());
	}
	/**
	 * VO 객체 RD의 내용들을 전송한다
	 * @param r 정보를 전송할 RD
	 * @throws IOException
	 */
	public void send(RD r) throws IOException {
		dos.writeUTF(r.getRdId());
		dos.writeUTF(r.getRdPwd());
		dos.writeUTF(r.getRdManagerName());
		dos.writeUTF(r.getRdTeamName());
		dos.writeUTF(r.getRdPhone());
	}
	/**
	 * VO 객체 Purchase의 내용들을 전송한다
	 * @param p 정보를 전송할 Purchase
	 * @throws IOException
	 */
	public void send(Purchase p) throws IOException {
		dos.writeInt(p.getPurchaseCode());
		dos.writeUTF(p.getCustomerId());
		dos.writeUTF(p.getPurchaseDate().toString());
		send(p.getPurchaseDetail());
	}
	/**
	 * VO 객체 PurchaseDetail의 내용들을 전송한다
	 * @param pd 정보를 전송할 PurchaseDetail
	 * @throws IOException
	 */
	public void send(PurchaseDetail pd) throws IOException {
		dos.writeInt(pd.getPurchaseCode());
		dos.writeInt(pd.getPurchaseDetailQuantity());
		send(pd.getRecipeInfo());
	}
	/**
	 * VO 객체 RecipeInfo의 내용들을 전송한다
	 * @param ri 정보를 전송할 RecipeInfo
	 * @throws IOException
	 */
	public void send(RecipeInfo r) throws IOException {
		dos.writeInt(r.getRecipeCode());
		dos.writeUTF(r.getRecipeName());
		dos.writeUTF(r.getRecipeSumm());
		dos.writeDouble(r.getRecipePrice());
		dos.writeUTF(r.getRecipeProcess());
		send(r.getPoint());
		sendRecipeIngredients(r.getIngredients());
	}
	/**
	 * VO 객체 RecipeIngredient의 내용들을 전송한다
	 * @param ri
	 * @throws IOException
	 */
	public void send(RecipeIngredient ri) throws IOException {
		send(ri.getIngredient());
	}
	/**
	 * VO 객체 Ingredient의 내용들을 전송한다
	 * @param i 정보를 전송할 Ingredient
	 * @throws IOException
	 */
	public void send(Ingredient i) throws IOException {
		dos.writeInt(i.getIngCode());
		dos.writeUTF(i.getIngName());
	}
	/**
	 * RecipeIngredient List를 전송한다
	 * @param list 보낼 RecipeIngredient들을 가진 List
	 * @throws IOException
	 */
	public void sendRecipeIngredients(List<RecipeIngredient> list) throws IOException {
		dos.writeInt(list.size());
		for(RecipeIngredient i : list) send(i);
	}
	/**
	 * VO 객체 Point의 내용들을 전송한다
	 * @param p 정보를 전송할 Point
	 * @throws IOException
	 */
	public void send(Point p) throws IOException {
		dos.writeInt(p.getRecipeCode());
		dos.writeInt(p.getLikeCount());
		dos.writeInt(p.getDisLikeCount());
	}
	/**
	 * VO 객체 Favorite의 내용들을 전송한다
	 * @param f 정보를 전송할 Favorite
	 * @throws IOException
	 */
	public void send(Favorite f) throws IOException {
		dos.writeUTF(f.getCustomerId());
		send(f.getRecipeInfo());
	}
	/**
	 * VO 객체 Review의 내용들을 전송한다
	 * @param r 정보를 전송할 Review
	 * @throws IOException
	 */
	public void send(Review r) throws IOException {
		dos.writeUTF(r.getCustomerId());
		dos.writeUTF(r.getReviewComment());
		dos.writeUTF(r.getReviewDate().toString());
		send(r.getRecipeInfo());
	}
	
	
	public String receiveStatus() throws IOException {
		return dis.readUTF();
	}
	/**
	 * 메시지를 전달받는다
	 * @return 전달된 메시지
	 * @throws IOException
	 */
	public String receive() throws IOException {
		return dis.readUTF();
	}
	/**
	 * Client로부터 메뉴 번호를 전달받는다
	 * @return 전달받은 메뉴 번호
	 * @throws IOException
	 */
	public int receiveMenu() throws IOException{
		return dis.readInt();
	}
	/**
	 * VO 객체 Customer의 내용들을 전달받는다
	 * @return 전달받은 내용들로 구성한 Customer
	 * @throws IOException
	 */
	public Customer receiveCustomer() throws IOException {
		String id = dis.readUTF();
		String pwd = dis.readUTF();
		String name = dis.readUTF();
		String email = dis.readUTF();
		String phone = dis.readUTF();
		Postal postal = receivePostal();
		String addr = dis.readUTF();
		
		return new Customer(id, pwd, name, email, phone, postal, addr);
	}
	/**
	 * Customer List를 전달받는다
	 * @return 전달받은 Customer들의 List
	 * @throws IOException
	 */
	public List<Customer> receiveCustomers() throws IOException {
		int size = dis.readInt();
		List<Customer> list = new ArrayList<>();
		for(int i=0; i<size; i++) list.add(receiveCustomer());
		
		return list;
	}
	/**
	 * VO 객체 Postal의 내용들을 전달받는다
	 * @return 전달받은 내용들로 구성한 Postal
	 * @throws IOException
	 */
	public Postal receivePostal() throws IOException {
		String buildingno = dis.readUTF();
		String zipcode = dis.readUTF();
		String sido = dis.readUTF();
		String sigungu = dis.readUTF();
		String eupmyun = dis.readUTF();
		String dorocode = dis.readUTF();
		String doro = dis.readUTF();
		String jiha = dis.readUTF();
		String building1 = dis.readUTF();
		String building2 = dis.readUTF();
		String daryang = dis.readUTF();
		String building = dis.readUTF();
		String dongcode = dis.readUTF();
		String dong = dis.readUTF();
		String ri = dis.readUTF();
		String dongadmin = dis.readUTF();
		String san = dis.readUTF();
		String zibun1 = dis.readUTF();
		String zibunserical = dis.readUTF();
		String zibun2 = dis.readUTF();
		String zipIdcode = dis.readUTF();
		String zipcodeserial = dis.readUTF();
		
		return new Postal(buildingno, zipcode, sido, sigungu, eupmyun, dorocode, doro, jiha, building1, building2, daryang, building, dongcode, dong, ri, dongadmin, san, zibun1, zibunserical, zibun2, zipIdcode, zipcodeserial);
	}
	/**
	 * VO 객체 RD의 내용들을 전달받는다
	 * @return 전달받은 내용들로 구성한 RD
	 * @throws IOException
	 */
	public RD receiveRd() throws IOException {
		String rdId = dis.readUTF();
		String rdPwd = dis.readUTF();
		String rdManagerName = dis.readUTF();
		String rdTeamName = dis.readUTF();
		String rdPhone = dis.readUTF();
		
		return new RD(rdId, rdPwd, rdManagerName, rdTeamName, rdPhone);
	}
	/**
	 * VO 객체 Purchase의 내용들을 전달받는다
	 * @return 전달받은 내용들로 구성한 Purchase
	 * @throws IOException
	 */
	public Purchase receivePurchase() throws IOException, ParseException {
		int purchaseCode = dis.readInt();
		String customerId = dis.readUTF();
		Date purchaseDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dis.readUTF());
		PurchaseDetail purchaseDetail = receivePurchaseDetail();
		
		return new Purchase(purchaseCode, customerId, purchaseDate, purchaseDetail);
	}
	/**
	 * VO 객체 PurchaseDetail의 내용들을 전달받는다
	 * @return 전달받은 내용들로 구성한 PurchaseDetail
	 * @throws IOException
	 */
	public PurchaseDetail receivePurchaseDetail() throws IOException {
		int purchaseCode = dis.readInt();
		int purchaseDetailQuantity = dis.readInt();
		RecipeInfo recipeInfo = receiveRecipeInfo();
		
		return new PurchaseDetail(purchaseCode, purchaseDetailQuantity, recipeInfo);
	}
	/**
	 * VO 객체 RecipeInfo의 내용들을 전달받는다
	 * @return 전달받은 내용들로 구성한 RecipeInfo
	 * @throws IOException
	 */
	public RecipeInfo receiveRecipeInfo() throws IOException {
		int recipeCode = dis.readInt();
		String recipeName = dis.readUTF();
		String recipeSumm = dis.readUTF();
		double recipePrice = dis.readDouble();
		String recipeProcess = dis.readUTF();
		Point point = receivePoint();
		List<RecipeIngredient> ingredients = receiveRecipeIngredients();
		
		return new RecipeInfo(recipeCode, recipeName, recipeSumm, recipePrice, recipeProcess, point, ingredients);
	}
	/**
	 * VO 객체 RecipeIngredient의 내용들을 전달받는다
	 * @return 전달받은 내용들로 구성한 RecipeIngredient
	 * @throws IOException
	 */
	public RecipeIngredient receiveRecipeIngredient() throws IOException {
		return new RecipeIngredient(receiveIngredient());
	}
	/**
	 * VO 객체 Ingredient의 내용들을 전달받는다
	 * @return 전달받은 내용들로 구성한 Ingredient
	 * @throws IOException
	 */
	public Ingredient receiveIngredient() throws IOException {
		int ingCode = dis.readInt();
		String ingName = dis.readUTF();
		
		return new Ingredient(ingCode, ingName);
	}
	/**
	 * RecipeIngredient List를 전달받는다
	 * @return 전달받은 RecipeIngredient들의 List
	 * @throws IOException
	 */
	public List<RecipeIngredient> receiveRecipeIngredients() throws IOException {
		int size = dis.readInt();
		List<RecipeIngredient> list = new ArrayList<RecipeIngredient>();
		for(int i = 0; i < size; i++) list.add(receiveRecipeIngredient());
		
		return list;
	}
	/**
	 * VO 객체 Point의 내용들을 전달받는다
	 * @return 전달받은 내용들로 구성한 Point
	 * @throws IOException
	 */
	public Point receivePoint() throws IOException {
		int recipeCode = dis.readInt();
		int likeCount = dis.readInt();
		int disLikeCount = dis.readInt();
		
		return new Point(recipeCode, likeCount, disLikeCount);
	}
	
	public void close() {
		if(dos != null)
		try {
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(dis != null)
		try {
			dis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
