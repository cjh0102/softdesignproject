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
