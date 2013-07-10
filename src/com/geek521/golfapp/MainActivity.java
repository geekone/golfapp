package com.geek521.golfapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btn_setup = (Button)findViewById(R.id.btn_setup);
		btn_setup.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				//TODO 要带过去的参数
//				intent.putExtra("name", "value");
				intent.setClass(MainActivity.this, SetupActivity.class);
				startActivity(intent);
//				MainActivity.this.finish();			//不关的话可以切换
			}
			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	
	
}
