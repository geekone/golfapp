package com.geek521.golfapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.geek521.models.User;
import com.geek521.services.UserService;

public class TestSqliteActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_sqlite);
		
		UserService service = new UserService(this);
		service.selectAll();
		
		//新增
		User user = new User("testuser","testpass");
		service.insert(user);
		service.find(1);
		
		//更新
		user.setUsername("abc");
		user.setPassword("def");
		service.update(user, 1);
		service.find(1);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test_sqlite, menu);
		return true;
	}

}
