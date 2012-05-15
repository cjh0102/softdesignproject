package team.soft.project.activity;

import java.util.List;

import team.soft.project.adapter.CustomListAdapter;
import team.soft.project.model.Shoes;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class OrderListActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.orderlist);

		Intent intent = getIntent();

		List<Shoes> orderShoes = ((MyApplication)getApplication()).getOrderShoes();
		CustomListAdapter adapter = new CustomListAdapter(this, R.layout.items_list_view, orderShoes); 


		// 추가라는 메세지가 오면 
		if (intent.getStringExtra("msg").equals("add")) {
			Shoes shoes = (Shoes)intent.getSerializableExtra("shoes");
			orderShoes.add(shoes);
			adapter.notifyDataSetChanged();

			// 주문받은 신발이 중복되는지 파악하기위한 객체
			Shoes item = shoes;

			// 신발 전체 리스트
			List<Shoes> totalShoes = ((MyApplication)getApplication()).getTotalShoes();

			// 물품 리스트에 같은 신발이 있으면 수량만 증가, 없으면 리스트에 추가
			if (totalShoes.contains(item)) {
				item = totalShoes.get(totalShoes.indexOf(item));
				try {
					String sum = Integer.toString((Integer.parseInt(item.getQuantity()) + Integer.parseInt(shoes.getQuantity())));
					item.setQuantity(sum);
				} catch (NumberFormatException e) {
					Log.d("hwan", "NumberFormatException");
				}
			} else {
					totalShoes.add(item);
			}
		} 
		
		if(!orderShoes.isEmpty()) {
			ListView listView = (ListView)findViewById(R.id.orderListView);
			listView.setAdapter(adapter);
		} else {
			Log.d("hwan", "orderShoes is empty");
		}
		
		Button addButton = (Button)findViewById(R.id.addButton);
		Button homeButton = (Button)findViewById(R.id.homeButton);

		addButton.setOnClickListener(this);
		homeButton.setOnClickListener(this);
	}

	public void onClick(View view) {
		Intent intent;

		if (view.getId() == R.id.addButton) {
			intent = new Intent(OrderListActivity.this, StoreControlActivity.class);
			intent.putExtra("msg", "add");
			OrderListActivity.this.startActivity(intent);
			OrderListActivity.this.finish();
		} else if (view.getId() == R.id.homeButton) {
			intent = new Intent(OrderListActivity.this, StoreControlActivity.class);
			intent.putExtra("msg", "home");
			OrderListActivity.this.startActivity(intent);
			OrderListActivity.this.finish();
		}
	}
}