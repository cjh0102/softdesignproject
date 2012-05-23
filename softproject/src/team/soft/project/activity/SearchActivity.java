package team.soft.project.activity;

import java.util.ArrayList;
import java.util.List;

import team.soft.project.adapter.SearchListAdapter;
import team.soft.project.model.Shoes;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class SearchActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);

		findViewById(R.id.searchButton).setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {

				List<Shoes> totalList = ((MyApplication)getApplication()).getTotalShoes();
				List<Shoes> searchList = new ArrayList<Shoes>();

				EditText nameEditText = (EditText)findViewById(R.id.nameEditText);
				String name = nameEditText.getText().toString();

				if (name.length() == 0) {
					Toast.makeText(SearchActivity.this, "이름을 입력하세요", Toast.LENGTH_SHORT).show();
				}

				if(!totalList.isEmpty()) {
					for (Shoes shoes : totalList) {
						if (shoes.getName().equals(name)) {
							searchList.add(new Shoes(shoes));
						} else {
							Toast.makeText(SearchActivity.this, "물품이없습니다", Toast.LENGTH_SHORT).show();
							
							
						}
					}
				} else {
					Toast.makeText(SearchActivity.this, "물품이없습니다", Toast.LENGTH_SHORT).show();
				}

				if(!searchList.isEmpty()) {
					SearchListAdapter adapter = new SearchListAdapter(SearchActivity.this, R.layout.search_list_item, searchList);
					ListView searchListView = (ListView)findViewById(R.id.searchListView);
					searchListView.setAdapter(adapter);
				}
			}
		});


	}
}
