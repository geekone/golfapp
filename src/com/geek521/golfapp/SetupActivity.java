package com.geek521.golfapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class SetupActivity extends Activity {

	Button btn_home;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setup);
		
		btn_home = (Button)findViewById(R.id.btn1);
		btn_home.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = SetupActivity.this.getIntent();
				intent.setClass(SetupActivity.this, MainActivity.class);
				startActivity(intent);
				SetupActivity.this.finish();
			}
			
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.setup, menu);
		return true;
	}

}
