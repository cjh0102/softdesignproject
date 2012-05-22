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
		totalShoes.add(new Shoes("�����÷���", 79000, "White", "265", 66));
		totalShoes.add(new Shoes("����Ʈ���̳�", 119000, "White", "265", 80));
		totalShoes.add(new Shoes("������3", 129000, "Yellow", "270", 129));
		totalShoes.add(new Shoes("�� ��Ʈ����", 129000, "Blue", "265", 140));
		totalShoes.add(new Shoes("�䰡����", 119000, "Gray", "265", 200));
		totalShoes.add(new Shoes("�糪�����̴�", 145000, "White", "235", 300));
		totalShoes.add(new Shoes("�糪���̼�", 139000, "Blue", "230", 400));
		totalShoes.add(new Shoes("�糪�۶��̵�3", 139000, "Red", "225", 600));
		totalShoes.add(new Shoes("����ƽ��ͺ深��", 119000, "White", "260", 5));
		totalShoes.add(new Shoes("����ƽ�����������Ʈ", 169000, "Blue", "270", 2));
		totalShoes.add(new Shoes("����ƽ����Ͽ���", 139000, "Yellow", "275", 4));
		totalShoes.add(new Shoes("��Ʈ������", 99000, "Green", "270", 5));
		totalShoes.add(new Shoes("��IVTF", 59000, "Blue", "275", 5));
		totalShoes.add(new Shoes("������Ʈ��3", 215000, "Orange", "265", 7));
		totalShoes.add(new Shoes("��ť���� ���丮3", 62000, "Peach", "270", 4));
		totalShoes.add(new Shoes("Ƽ�����̽�ƽ5", 185000, "White", "265", 2));
		totalShoes.add(new Shoes("Ƽ����������5", 185000, "White", "270", 3));
		totalShoes.add(new Shoes("��ť���� �̶�Ŭ3", 159000, "Peach", "265", 5));
		totalShoes.add(new Shoes("��ť���� �۶��̵�3", 115000, "Peach", "265", 4));
		totalShoes.add(new Shoes("Ƽ��������5", 52000, "White", "270", 5));
		totalShoes.add(new Shoes("��Ʈ����ũ5", 125000, "Blue", "265", 4));
		totalShoes.add(new Shoes("T90��5", 85000, "Blue", "265", 5));
		totalShoes.add(new Shoes("Ƽ�����ö���Ʈ", 125000, "White", "270", 6));
		totalShoes.add(new Shoes("��Ʈ����ũ5", 125000, "Blue", "280", 7));
		totalShoes.add(new Shoes("��ť���� ������6", 2589000, "Peach", "265", 8));
		totalShoes.add(new Shoes("Ƽ��������5", 52000, "White", "255", 7));
		totalShoes.add(new Shoes("���극��2", 85000, "White", "270", 4));
		totalShoes.add(new Shoes("Ʈ����Ƽ��Ÿ2", 125000, "White", "265", 8));
		totalShoes.add(new Shoes("����Ű5����", 79000, "Gray", "265", 7));
		totalShoes.add(new Shoes("�糪�����۰��̸ӷο�", 119000, "Blue", "270", 8));
		totalShoes.add(new Shoes("���ں�6", 159000, "White", "270", 4));
		totalShoes.add(new Shoes("��KD", 119000, "Orange", "265", 8));
		totalShoes.add(new Shoes("�������۵�ũ", 129000, "Gray", "280", 20));
		totalShoes.add(new Shoes("�����9", 195000, "Blue", "265", 40));
		totalShoes.add(new Shoes("����Ű����", 119000, "Orange", "235", 40));
		totalShoes.add(new Shoes("�糪�ÿ�����", 129000, "Blue", "225", 80));
		totalShoes.add(new Shoes("����Ʈ����Ʈ", 119000, "White", "240", 60));
		totalShoes.add(new Shoes("��������Ƽ��", 129000, "White", "235", 70));
		totalShoes.add(new Shoes("����ƽ�", 115000, "White", "245", 40));
		totalShoes.add(new Shoes("������Ż�ھ�", 85000, "Pink", "225", 86));
		totalShoes.add(new Shoes("������", 109000, "White", "230", 68));
		totalShoes.add(new Shoes("����XT���긮������", 129000, "Blue", "240", 98));
		totalShoes.add(new Shoes("�÷���Ʈ���̳�", 79000, "Pink", "250", 80));
		totalShoes.add(new Shoes("�糪�۶��̵�3", 139000, "Red", "230", 100));
		totalShoes.add(new Shoes("�糪�ÿ�����", 129000, "Blue", "240", 86));
		totalShoes.add(new Shoes("�糪��Ӷ���Ʈ", 138000, "Black", "225", 77));
		totalShoes.add(new Shoes("�糪�����̴�", 145000, "Green", "245", 43));
		totalShoes.add(new Shoes("�糪��Ŭ����2", 159000, "Blue", "230", 78));
		totalShoes.add(new Shoes("�糪����2", 218000, "Pink", "235", 98));
		totalShoes.add(new Shoes("������3", 129000, "Orange", "240", 120));
		totalShoes.add(new Shoes("����Ʈ����Ʈ", 119000, "Orange", "225", 89));
		totalShoes.add(new Shoes("��������Ƽ��", 129000, "Green", "230", 45));
		
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
