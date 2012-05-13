package team.soft.project.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
	private EditText sizeEditText;
	private EditText quantityEditText;
	private EditText priceEditText;
	private Spinner colorSpinner;
	private String color;
	private String[] colors = new String[]{"BLACK", "WHITE", "BLUE", "RED", "GREEN", "PUPLE", "NABY"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.order);

		nameEditText = (EditText)findViewById(R.id.nameEdtiText);
		sizeEditText = (EditText)findViewById(R.id.sizeEditText);
		priceEditText = (EditText)findViewById(R.id.priceEditTextView);
		colorSpinner = (Spinner)findViewById(R.id.colorSpinner);
		quantityEditText = (EditText)findViewById(R.id.quantityEditTextView);
		Button addButton = (Button)findViewById(R.id.addButton);
		Button cancleButton = (Button)findViewById(R.id.cancleButton);
		
		colorSpinner.setPrompt("색깔을 선택하세요");
		colorSpinner.setSelection(0);
		ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, colors);
		colorSpinner.setAdapter(colorAdapter);

		colorSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View view,
					int index, long arg3) {

				switch (index) {
				case 0:
					color = "Black";
					break;
				case 1:
					color = "White";
					break;
				case 2:
					color = "Blue";
					break;
				case 3:
					color = "Red";
					break;
				case 4:
					color = "Green";
					break;
				case 5:
					color = "Puple";
					break;
				case 6:
					color = "Naby";
					break;
				}
			}
			public void onNothingSelected(AdapterView<?> arg0) {
				Toast.makeText(OrderActivity.this, "색깔선택 해주세요!!", Toast.LENGTH_SHORT).show();
			}
		});

		addButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				String name = nameEditText.getText().toString();
				String quantity = quantityEditText.getText().toString();
				String size = sizeEditText.getText().toString();
				String price = priceEditText.getText().toString();

				if (name.length() == 0) {
					Toast.makeText(OrderActivity.this, "모델명을 입력하세요!!", Toast.LENGTH_SHORT).show();
				} else if (name.length() == 1) {
					Toast.makeText(OrderActivity.this, "모델명이 한글자인가요??", Toast.LENGTH_SHORT).show();
				} else if (size.length() == 0 || Integer.parseInt(size) < 145 || Integer.parseInt(size) > 300  ) {
					Toast.makeText(OrderActivity.this, "145 ~ 300 크기를 입력하세요", Toast.LENGTH_SHORT).show();
				} else if (price.length() == 0 || Integer.parseInt(price) < 20000 || Integer.parseInt(price) > 300000 ) {
					Toast.makeText(OrderActivity.this, "2만원 이상 30만원이하의 가격을 입력하세요", Toast.LENGTH_SHORT).show();
				} else if (quantity.length() == 0 || Integer.parseInt(quantity) <= 0) {
					Toast.makeText(OrderActivity.this, "1개이상 수량을 입력하세요", Toast.LENGTH_SHORT).show();
				} else {

					Intent intent = new Intent(OrderActivity.this, OrderListActivity.class);

					intent.putExtra("name", name);
					intent.putExtra("color", color);
					intent.putExtra("quantity", quantity);
					intent.putExtra("size", size);
					intent.putExtra("price", price);

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
				startActivity(intent);
				finish();
			}
		});
		
	}
}
