package team.soft.project.activity;

import java.util.List;

import team.soft.project.adapter.SaleListAdapter;
import team.soft.project.model.Shoes;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

public class SaleListActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.salelist);
		
		List<Shoes> saleShoes = ((MyApplication)getApplication()).getSaleShoes();
		
		if (!saleShoes.isEmpty()) {
			SaleListAdapter adapter = new SaleListAdapter(this, R.layout.sale_list_item, saleShoes);
			ListView listView = (ListView)findViewById(R.id.saleListView);
			listView.setAdapter(adapter);
		}
		
		findViewById(R.id.addsaleButton).setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent(SaleListActivity.this, StoreControlActivity.class);
				intent.putExtra("msg", "home");
				startActivity(intent);
				finish();
			}
		});
	}
}
