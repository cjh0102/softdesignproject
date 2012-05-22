package team.soft.project.activity;

import java.util.ArrayList;
import java.util.List;

import team.soft.project.model.Shoes;
import android.app.Application;

public class MyApplication extends Application {
	private List<Shoes> totalShoes;
	private List<Shoes> orderShoes;
	private List<Shoes> saleShoes;
	
	@Override
	public void onCreate() {
		super.onCreate();
		totalShoes = new ArrayList<Shoes>();
		totalShoes.add(new Shoes("nike", 200000, "Black", "265", 100));
		totalShoes.add(new Shoes("에어플렉스", 79000, "White", "265", 66));
		totalShoes.add(new Shoes("프리트레이너", 119000, "White", "265", 80));
		totalShoes.add(new Shoes("프리런3", 129000, "Yellow", "270", 129));
		totalShoes.add(new Shoes("줌 스트럭쳐", 129000, "Blue", "265", 140));
		totalShoes.add(new Shoes("페가수스", 119000, "Gray", "265", 200));
		totalShoes.add(new Shoes("루나스파이더", 145000, "White", "235", 300));
		totalShoes.add(new Shoes("루나레이서", 139000, "Blue", "230", 400));
		totalShoes.add(new Shoes("루나글라이드3", 139000, "Red", "225", 600));
		totalShoes.add(new Shoes("에어맥스터뷸런스", 119000, "White", "260", 5));
		totalShoes.add(new Shoes("에어맥스엑셀러레이트", 169000, "Blue", "270", 2));
		totalShoes.add(new Shoes("에어맥스테일원드", 139000, "Yellow", "275", 4));
		totalShoes.add(new Shoes("스트릿가토", 99000, "Green", "270", 5));
		totalShoes.add(new Shoes("슛IVTF", 59000, "Blue", "275", 5));
		totalShoes.add(new Shoes("마에스트리3", 215000, "Orange", "265", 7));
		totalShoes.add(new Shoes("머큐리얼 빅토리3", 62000, "Peach", "270", 4));
		totalShoes.add(new Shoes("티엠포미스틱5", 185000, "White", "265", 2));
		totalShoes.add(new Shoes("티엠포레전드5", 185000, "White", "270", 3));
		totalShoes.add(new Shoes("머큐리얼 미라클3", 159000, "Peach", "265", 5));
		totalShoes.add(new Shoes("머큐리얼 글라이드3", 115000, "Peach", "265", 4));
		totalShoes.add(new Shoes("티엠포내츄럴5", 52000, "White", "270", 5));
		totalShoes.add(new Shoes("스트라이크5", 125000, "Blue", "265", 4));
		totalShoes.add(new Shoes("T90슛5", 85000, "Blue", "265", 5));
		totalShoes.add(new Shoes("티엠포플라이트", 125000, "White", "270", 6));
		totalShoes.add(new Shoes("스트라이크5", 125000, "Blue", "280", 7));
		totalShoes.add(new Shoes("머큐리얼 베이퍼6", 2589000, "Peach", "265", 8));
		totalShoes.add(new Shoes("티엠포내츄럴5", 52000, "White", "255", 7));
		totalShoes.add(new Shoes("리브레또2", 85000, "White", "270", 4));
		totalShoes.add(new Shoes("트레꽈티스타2", 125000, "White", "265", 8));
		totalShoes.add(new Shoes("나이키5봄바", 79000, "Gray", "265", 7));
		totalShoes.add(new Shoes("루나하이퍼게이머로우", 119000, "Blue", "270", 8));
		totalShoes.add(new Shoes("줌코비6", 159000, "White", "270", 4));
		totalShoes.add(new Shoes("줌KD", 119000, "Orange", "265", 8));
		totalShoes.add(new Shoes("줌하이퍼덩크", 129000, "Gray", "280", 20));
		totalShoes.add(new Shoes("르브론9", 195000, "Blue", "265", 40));
		totalShoes.add(new Shoes("나이키프리", 119000, "Orange", "235", 40));
		totalShoes.add(new Shoes("루나올웨이즈", 129000, "Blue", "225", 80));
		totalShoes.add(new Shoes("프리트위스트", 119000, "White", "240", 60));
		totalShoes.add(new Shoes("프리어드밴티지", 129000, "White", "235", 70));
		totalShoes.add(new Shoes("에어맥스", 115000, "White", "245", 40));
		totalShoes.add(new Shoes("에어토탈코어", 85000, "Pink", "225", 86));
		totalShoes.add(new Shoes("무브핏", 109000, "White", "230", 68));
		totalShoes.add(new Shoes("프리XT에브리데이핏", 129000, "Blue", "240", 98));
		totalShoes.add(new Shoes("플렉스트레이너", 79000, "Pink", "250", 80));
		totalShoes.add(new Shoes("루나글라이드3", 139000, "Red", "230", 100));
		totalShoes.add(new Shoes("루나올웨이즈", 129000, "Blue", "240", 86));
		totalShoes.add(new Shoes("루나썸머라이트", 138000, "Black", "225", 77));
		totalShoes.add(new Shoes("루나스파이더", 145000, "Green", "245", 43));
		totalShoes.add(new Shoes("루나이클립스2", 159000, "Blue", "230", 78));
		totalShoes.add(new Shoes("루나링스2", 218000, "Pink", "235", 98));
		totalShoes.add(new Shoes("프리런3", 129000, "Orange", "240", 120));
		totalShoes.add(new Shoes("프리트위스트", 119000, "Orange", "225", 89));
		totalShoes.add(new Shoes("프리어드밴티지", 129000, "Green", "230", 45));
		
		orderShoes = new ArrayList<Shoes>();
		saleShoes = new ArrayList<Shoes>();
	}
	
	public List<Shoes> getTotalShoes() {
		return totalShoes;
	}

	public List<Shoes> getSaleShoes() {
		return saleShoes;
	}

	public void setSaleShoes(List<Shoes> saleShoes) {
		this.saleShoes = saleShoes;
	}

	public void setTotalShoes(List<Shoes> totalShoes) {
		this.totalShoes = totalShoes;
	}

	public List<Shoes> getOrderShoes() {
		return orderShoes;
	}

	public void setOrderShoes(List<Shoes> orderShoes) {
		this.orderShoes = orderShoes;
	}
}
