package team.soft.project.activity;

import java.util.List;

import team.soft.project.model.Shoes;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class OrderActivity extends Activity {
	
	private EditText nameEditText;
	private EditText quantityEditText;
	private EditText priceEditText;

	private Spinner colorSpinner;
	private Spinner sizeSpinner;

	private String color;
	private String size;
	
	private String[] sizes = new String[]{"240", "245", "250",
			"255", "260", "265", "270", "275", "280", 
			"285", "290", "300", "310", "320", "330"};
	private String[] colors = new String[]{"Black", "White", 
			"Blue", "Red", "Green", "Puple", "Naby"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.order);
		
		nameEditText = (EditText)findViewById(R.id.nameEdtiText);
		priceEditText = (EditText)findViewById(R.id.priceEditTextView);
		quantityEditText = (EditText)findViewById(R.id.quantityEditTextView);
		Button addButton = (Button)findViewById(R.id.addButton);
		Button cancleButton = (Button)findViewById(R.id.cancleButton);
		
		// Size Spinner
		sizeSpinner = (Spinner)findViewById(R.id.sizeSpinner);
		ArrayAdapter<String> sizeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sizes);
		sizeSpinner.setPrompt("사이즈를 선택하세요");
		sizeSpinner.setSelection(0);
		sizeSpinner.setAdapter(sizeAdapter);

		sizeSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int index, long arg3) {
				size = sizes[index];
			}

			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		
		// Color Spinner
		colorSpinner = (Spinner)findViewById(R.id.colorSpinner);
		ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, colors);
		colorSpinner.setPrompt("색깔을 선택하세요");
		colorSpinner.setSelection(0);
		colorSpinner.setAdapter(colorAdapter);

		colorSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View view,
					int index, long arg3) {
				color = colors[index];
			}
			public void onNothingSelected(AdapterView<?> arg0) {
				Toast.makeText(OrderActivity.this, "색깔선택 해주세요!!", Toast.LENGTH_SHORT).show();
			}
		});

		addButton.setOnClickListener(new OnClickListener() {
			int quantity;
			int price;

			public void onClick(View arg0) {
				String name = nameEditText.getText().toString();
				try {
					price = Integer.parseInt(priceEditText.getText().toString());
					quantity = Integer.parseInt(quantityEditText.getText().toString());

				} catch (NumberFormatException e) {
					Log.d("hwan", Integer.toString(price));
				}

				if (name.length() == 0) {
					Toast.makeText(OrderActivity.this, "모델명을 입력하세요!!", Toast.LENGTH_SHORT).show();
				} else if (name.length() == 1) {
					Toast.makeText(OrderActivity.this, "모델명이 한글자인가요??", Toast.LENGTH_SHORT).show();
				} else if (price < 0 || price < 20000 || price > 300000 ) {
					Toast.makeText(OrderActivity.this, "2만원 이상 30만원이하의 가격을 입력하세요", Toast.LENGTH_SHORT).show();
				} else if (quantity <= 0) {
					Toast.makeText(OrderActivity.this, "1개이상 수량을 입력하세요", Toast.LENGTH_SHORT).show();
				} else {

					Shoes shoes = new Shoes(name, price, color, size, quantity);
					
					List<Shoes> orderList = ((MyApplication)getApplication()).getOrderShoes();
					List<Shoes> totalList = ((MyApplication)getApplication()).getTotalShoes();
					
					if (totalList.contains(shoes)) {
						
						shoes.setQuantity(totalList.get(totalList.indexOf(shoes)).getQuantity() + quantity);
						totalList.remove(shoes);
						totalList.add(shoes);
						
						Shoes orderShoes = new Shoes(shoes);
						orderShoes.setQuantity(quantity);
						orderList.add(orderShoes);

					} else {
						orderList.add(new Shoes(shoes));
						totalList.add(new Shoes(shoes));
					}

					Intent intent = new Intent(OrderActivity.this, OrderListActivity.class);
					OrderActivity.this.startActivity(intent);
					OrderActivity.this.finish();
				}
			}
		});

		cancleButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent(OrderActivity.this, MainActivity.class);
				OrderActivity.this.startActivity(intent);
				finish();
			}
		});

		Button orderListButton = (Button)findViewById(R.id.orderListButton);
		orderListButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(OrderActivity.this, OrderListActivity.class);
				intent.putExtra("msg", "null");
				startActivity(intent);
				finish();
			}
		});

	}
}
