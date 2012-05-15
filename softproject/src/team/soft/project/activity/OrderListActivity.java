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

		List<Shoes> orderShoes = ((MyApplication)getApplication()).getOrderShoes();
		CustomListAdapter adapter = new CustomListAdapter(this, R.layout.items_list_view, orderShoes); 
		
		if (!orderShoes.isEmpty()) {
			ListView listView = (ListView)findViewById(R.id.orderListView);
			listView.setAdapter(adapter);
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