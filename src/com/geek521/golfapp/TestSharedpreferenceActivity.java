package com.geek521.golfapp;

import java.io.File;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;


/****
 * 
 * SharedPreferences对象本身只能获取数据而不支持存储和修改，存储修改是通过Editor对象实现。实现SharedPreferences存储的步骤如下：

　　一、根据Context获取SharedPreferences对象

　　二、利用edit()方法获取Editor对象。

　　三、通过Editor对象存储key-value键值对数据。

　　四、通过commit()方法提交数据。

　　具体实现代码如下：实现存储，读取，清除，删除
 * 
 * 
 * @author Administrator
 *
 */
public class TestSharedpreferenceActivity extends Activity {

	SharedPreferences mShared = null;
	//保存的名字
	final static String SHARED_MAIN_XML = "main";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_testsharedpreference);
		
		mShared = getSharedPreferences(SHARED_MAIN_XML, MODE_PRIVATE);
		
		//测试
		read();
		write();
		read();
		clear();
		read();
		delete();
		read();
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.testsharedpreference, menu);
		return true;
	}

	//存入数据
	private void write(){
		Editor editor = mShared.edit();
		editor.putString("username", "test1");
		editor.putString("password","test1");
		editor.putInt("age", 350);
		editor.commit();
	}
	
	//读取
	private void read(){
		String username = mShared.getString("username", "暂时没有数据");
		String password = mShared.getString("password","暂时没有数据");
		int age = mShared.getInt("age", 0);
		
		System.out.println(username);
		System.out.println(password);
		System.out.println(age);
		
	}
	
	//清除
	private void clear(){
		Editor editor = mShared.edit();
		editor.clear();
		editor.commit();
	}
	
	//删除文件
	private void delete(){
		File file = new File("/data/data/com.geek521.golfapp" + "/shared_prefs/" + SHARED_MAIN_XML + ".xml");
		if(file.exists()){
			file.delete();
			Toast.makeText(this, "删除成功", Toast.LENGTH_LONG).show();
		}
	}
	
	
}
