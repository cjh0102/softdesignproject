package team.soft.project.activity;

import java.util.List;

import team.soft.project.model.Shoes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SaleActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sale);
		
		List<Shoes> totalShoes = ((MyApplication)getApplication()).getTotalShoes();
		Intent intent = getIntent();
		
	}
}
