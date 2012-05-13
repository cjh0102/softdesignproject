package team.soft.project.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Button startButton = (Button)findViewById(R.id.startButton);
		Button endButton = (Button)findViewById(R.id.endButton);
		
		startButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, StoreControlActivity.class);
				intent.putExtra("msg", "main");
				MainActivity.this.startActivity(intent);
			}
		});
		
		endButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
			finish();
			}
		});
	}
}
