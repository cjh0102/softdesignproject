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
		nameTextView.setText("��ǰ �̸�:  "+ shoes.getName());

		TextView sizeTextView = (TextView)findViewById(R.id.sizeTextView);
		sizeTextView.setText("��ǰ ������:  " + shoes.getSize());

		TextView colorTextView = (TextView)findViewById(R.id.colorTextView);
		colorTextView.setText("��ǰ ����:  " + shoes.getColor());

		TextView priceTextView = (TextView)findViewById(R.id.priceTextView);
		priceTextView.setText("��ǰ ����:  " + shoes.getPrice());

		saleTextView = (TextView)findViewById(R.id.saleTextView);
		saleTextView.setText("��ǰ ����:  " + shoes.getQuantity());


		Button saleButton = (Button)findViewById(R.id.saleButton);
		saleButton.setOnClickListener(new OnClickListener() {
			private int saleNumber;
			public void onClick(View arg0) {

				List<Shoes> saleList = ((MyApplication)getApplication()).getSaleShoes();
				List<Shoes> totalList = ((MyApplication)getApplication()).getTotalShoes();

				// �Ǹ��� ���� ���� �޾ƿ�
				EditText saleEditText = (EditText)findViewById(R.id.saleEditTextView);
				String editText = saleEditText.getText().toString();

				//�Ǹ��� ���� ���� ����
				if(!editText.equals("")) {
					saleNumber = Integer.parseInt(editText);

					// �Ǹ� �ϰ����ϴ� ���� 0���� ������� ����ó��
					if(saleNumber <= 0) {
						Toast.makeText(SaleActivity.this, "0���� ū���� �Է��ϼ���", Toast.LENGTH_SHORT).show();
					} else {			
						// 0���� ū���� ���ð�� ��� 
						int value = shoes.getQuantity() - saleNumber;

						if (value < 0) {
							Toast.makeText(SaleActivity.this, "��� �����մϴ�", Toast.LENGTH_SHORT).show();
						} else {
							
							shoes.setQuantity(saleNumber);
							saleList.add(shoes);
							
							Shoes testShoes = totalList.get(totalList.indexOf(shoes));
							testShoes.setQuantity(value);

							if (value == 0) {
								totalList.remove(shoes);
								Toast.makeText(SaleActivity.this, "��ǰ�� ǰ���Ǿ����ϴ�", Toast.LENGTH_SHORT).show();
							} 

							Toast.makeText(SaleActivity.this, "�ǸŰ� �Ǿ����ϴ�", Toast.LENGTH_SHORT).show();

							Intent intent = new Intent(SaleActivity.this, SaleListActivity.class);
							SaleActivity.this.startActivity(intent);
							SaleActivity.this.finish();
						}
					}
				} else {
					Toast.makeText(SaleActivity.this, "������ �Է��ϼ���", Toast.LENGTH_SHORT).show();
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
