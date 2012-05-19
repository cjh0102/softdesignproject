package team.soft.project.activity;

import java.util.List;

import team.soft.project.adapter.TotalListAdapter;
import team.soft.project.model.Shoes;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class TotalListActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.totallist);

		List<Shoes> items = ((MyApplication)getApplication()).getTotalShoes();
		
		TotalListAdapter adapter = new TotalListAdapter(this, R.layout.total_list_item, items);
		ListView listView = (ListView)findViewById(R.id.totalListView);
		listView.setAdapter(adapter);
		
	}
}
