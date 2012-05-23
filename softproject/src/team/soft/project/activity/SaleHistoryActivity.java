package team.soft.project.activity;

import java.util.List;

import team.soft.project.adapter.SaleListAdapter;
import team.soft.project.model.Shoes;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class SaleHistoryActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.salehistory);
		
		List<Shoes> saleList = ((MyApplication)getApplication()).getSaleShoes();

		TextView moneyTextView = (TextView)findViewById(R.id.moneyTextView);
		moneyTextView.setText("ÃÑ±Ý¾×: 0¿ø");
		
		int sum = 0;
		if (!saleList.isEmpty()) {
			for (Shoes shoes : saleList) {
				sum += shoes.getQuantity() * shoes.getPrice();
			}
			
			ListView saleListView = (ListView)findViewById(R.id.saleListView);
			SaleListAdapter adapter = new SaleListAdapter(this, R.layout.sale_list_item, saleList);
			saleListView.setAdapter(adapter);

			moneyTextView.setText("ÃÑ ±Ý¾×: " + sum + "¿ø");
		}
		
	}
}
