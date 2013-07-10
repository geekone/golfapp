package com.geek521.golfapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;



/**
 * 如果说不想把内容存在SharedPreferences中的话，我们可以自己写一个文件保存须要的数据，在这里我将文件保存在系统中的工程路径下。

跟上面布局一样，删除文件也一样，清除内容也查不多
 * @author Administrator
 *
 */
public class TestFileActivity extends Activity {

	private OutputStream os;		//输出流
	private InputStream is;			//输入流
	
	final static String MAIN_FILE = "main.txt";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_file);
		
		System.out.println("TEST.........File");
		write();
		read();
		clear();
		read();
		delete();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test_file, menu);
		return true;
	}

	
	
	private void delete() {
		File file = new File("/data/data/com.geek521.golfapp/files", MAIN_FILE);  
	        if (file.exists()) {  
	            file.delete();  
	        }  
	}
	private void clear() {
		String nameage="";
		try {
			os = this.openFileOutput(MAIN_FILE, MODE_PRIVATE);
			/* 把字符串转换成字节数组，写入文件中 */
			os.write(nameage.getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	//写入
	private void write(){
		String username = "我的名字";
		String password = "我的密码";
		String age = "35";
		try{
			os = this.openFileOutput(MAIN_FILE, MODE_PRIVATE);
			os.write(username.getBytes());
			os.write(password.getBytes());
			os.write(age.getBytes());
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			try{
				//关闭输出流
				os.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	
	private void read(){
		
		try{
			is = this.openFileInput(MAIN_FILE);
			byte[] b = new byte[1024];
			int length = is.read(b);
			System.out.println(new String(b));

		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
