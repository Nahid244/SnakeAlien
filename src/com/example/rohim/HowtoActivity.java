package com.example.rohim;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class HowtoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().hide();
		setContentView(R.layout.activity_howto);
	}
public void onBackPressed() {
		
		super.onBackPressed();
		
		Intent intent=new Intent(HowtoActivity.this,MainActivity.class);
		 this.startActivity(intent);
		 
		
		 
		 finish();
	}
}
