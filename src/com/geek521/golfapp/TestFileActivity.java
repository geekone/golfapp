package com.geek521.golfapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class TestFileActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_file);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test_file, menu);
		return true;
	}

}
