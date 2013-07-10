package com.geek521.golfapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class TestActivity extends Activity {

	private Button btn1,btn2,btn3,btn4;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		
		btn1 = (Button)findViewById(R.id.testbtn1);
		btn2 = (Button)findViewById(R.id.testbtn2);
		btn3 = (Button)findViewById(R.id.testbtn2);
		btn4 = (Button)findViewById(R.id.testbtn2);
		
		btn1.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(TestActivity.this, TestSharedpreferenceActivity.class);
				startActivity(intent);
			}
		});
		
		btn2.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(TestActivity.this, TestFileActivity.class);
				startActivity(intent);
				
			}
		});
		
		btn3.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(TestActivity.this, TestSqliteActivity.class);
				startActivity(intent);
			}
		});
		
		btn4.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(TestActivity.this, TestContentproviderActivity.class);
				startActivity(intent);
			}
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test, menu);
		return true;
	}

}
