package team.soft.project.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class StoreControlActivity extends TabActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		TabHost tabHost = getTabHost();

		tabHost.addTab(tabHost.newTabSpec("tag0")
				.setIndicator("��ǰ ����Ʈ").
				setContent(new Intent(this, InventoryActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("tag1")
				.setIndicator("��ǰ �ֹ�")
				.setContent(new Intent(this, OrderActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("tag2").
				setIndicator("��ǰ �˻�")
				.setContent(new Intent(this, SearchActivity.class)));

		Intent intent = getIntent();

		String msg = intent.getStringExtra("msg");

		if(msg.equals("add")) {
			tabHost.setCurrentTab(1);
		}
	}
}