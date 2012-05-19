package team.soft.project.activity;

import java.util.List;

import team.soft.project.model.Shoes;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SaleActivity extends Activity {
	private Shoes shoes;
	private TextView saleTextView;

	@Override 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sale);

		shoes = (Shoes)getIntent().getSerializableExtra("sale");

		TextView nameTextView = (TextView)findViewById(R.id.nameTextView);
		nameTextView.setText("물품 이름:  "+ shoes.getName());

		TextView sizeTextView = (TextView)findViewById(R.id.sizeTextView);
		sizeTextView.setText("물품 사이즈:  " + shoes.getSize());

		TextView colorTextView = (TextView)findViewById(R.id.colorTextView);
		colorTextView.setText("물품 색깔:  " + shoes.getColor());

		TextView priceTextView = (TextView)findViewById(R.id.priceTextView);
		priceTextView.setText("물품 가격:  " + shoes.getPrice());

		saleTextView = (TextView)findViewById(R.id.saleTextView);
		saleTextView.setText("물품 수량:  " + shoes.getQuantity());


		Button saleButton = (Button)findViewById(R.id.saleButton);
		saleButton.setOnClickListener(new OnClickListener() {
			private int saleNumber;
			public void onClick(View arg0) {

				List<Shoes> saleList = ((MyApplication)getApplication()).getSaleShoes();
				List<Shoes> totalList = ((MyApplication)getApplication()).getTotalShoes();

				// 판매할 수량 값을 받아옴
				EditText saleEditText = (EditText)findViewById(R.id.saleEditTextView);
				String editText = saleEditText.getText().toString();

				//판매할 량의 값을 구함
				if(!editText.equals("")) {
					saleNumber = Integer.parseInt(editText);

					// 판매 하고자하는 값이 0보다 작을경우 예외처리
					if(saleNumber <= 0) {
						Toast.makeText(SaleActivity.this, "0보다 큰수를 입력하세요", Toast.LENGTH_SHORT).show();
					} else {			
						// 0보다 큰값이 들어올경우 계산 
						int value = shoes.getQuantity() - saleNumber;

						if (value < 0) {
							Toast.makeText(SaleActivity.this, "재고가 부족합니다", Toast.LENGTH_SHORT).show();
						} else {
							
							shoes.setQuantity(saleNumber);
							saleList.add(shoes);
							
							Shoes testShoes = totalList.get(totalList.indexOf(shoes));
							testShoes.setQuantity(value);

							if (value == 0) {
								totalList.remove(shoes);
								Toast.makeText(SaleActivity.this, "물품이 품절되었습니다", Toast.LENGTH_SHORT).show();
							} 

							Toast.makeText(SaleActivity.this, "판매가 되었습니다", Toast.LENGTH_SHORT).show();

							Intent intent = new Intent(SaleActivity.this, SaleListActivity.class);
							SaleActivity.this.startActivity(intent);
							SaleActivity.this.finish();
						}
					}
				} else {
					Toast.makeText(SaleActivity.this, "수량을 입력하세요", Toast.LENGTH_SHORT).show();
				}
			} 
		});

		findViewById(R.id.cancleButton).setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent(SaleActivity.this, StoreControlActivity.class);
				intent.putExtra("msg", "home");
				SaleActivity.this.startActivity(intent);
				SaleActivity.this.finish();
			}
		});

		findViewById(R.id.saleListButton).setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent(SaleActivity.this, SaleListActivity.class);
				SaleActivity.this.startActivity(intent);
				SaleActivity.this.finish();
			}
		});
	}
}
