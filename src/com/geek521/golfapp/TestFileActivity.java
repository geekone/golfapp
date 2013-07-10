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
 * ���˵��������ݴ���SharedPreferences�еĻ������ǿ����Լ�дһ���ļ�������Ҫ�����ݣ��������ҽ��ļ�������ϵͳ�еĹ���·���¡�

�����沼��һ����ɾ���ļ�Ҳһ�����������Ҳ�鲻��
 * @author Administrator
 *
 */
public class TestFileActivity extends Activity {

	private OutputStream os;		//�����
	private InputStream is;			//������
	
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
			/* ���ַ���ת�����ֽ����飬д���ļ��� */
			os.write(nameage.getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	//д��
	private void write(){
		String username = "�ҵ�����";
		String password = "�ҵ�����";
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
				//�ر������
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
