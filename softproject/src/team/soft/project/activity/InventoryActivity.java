package team.soft.project.activity;

import java.util.List;

import team.soft.project.adapter.InventoryAdapter;
import team.soft.project.model.Shoes;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class InventoryActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inventory);

		List<Shoes> items = ((MyApplication)getApplication()).getTotalShoes();
		
		InventoryAdapter adapter = new InventoryAdapter(this, R.layout.inventory_list_item, items);
		ListView listView = (ListView)findViewById(R.id.inventory_listView);
		listView.setAdapter(adapter);
		
	}
}
