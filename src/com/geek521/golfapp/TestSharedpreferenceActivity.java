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
 * SharedPreferences������ֻ�ܻ�ȡ���ݶ���֧�ִ洢���޸ģ��洢�޸���ͨ��Editor����ʵ�֡�ʵ��SharedPreferences�洢�Ĳ������£�

����һ������Context��ȡSharedPreferences����

������������edit()������ȡEditor����

��������ͨ��Editor����洢key-value��ֵ�����ݡ�

�����ġ�ͨ��commit()�����ύ���ݡ�

��������ʵ�ִ������£�ʵ�ִ洢����ȡ�������ɾ��
 * 
 * 
 * @author Administrator
 *
 */
public class TestSharedpreferenceActivity extends Activity {

	SharedPreferences mShared = null;
	//���������
	final static String SHARED_MAIN_XML = "main";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_testsharedpreference);
		
		mShared = getSharedPreferences(SHARED_MAIN_XML, MODE_PRIVATE);
		
		//����
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

	//��������
	private void write(){
		Editor editor = mShared.edit();
		editor.putString("username", "test1");
		editor.putString("password","test1");
		editor.putInt("age", 350);
		editor.commit();
	}
	
	//��ȡ
	private void read(){
		String username = mShared.getString("username", "��ʱû������");
		String password = mShared.getString("password","��ʱû������");
		int age = mShared.getInt("age", 0);
		
		System.out.println(username);
		System.out.println(password);
		System.out.println(age);
		
	}
	
	//���
	private void clear(){
		Editor editor = mShared.edit();
		editor.clear();
		editor.commit();
	}
	
	//ɾ���ļ�
	private void delete(){
		File file = new File("/data/data/com.geek521.golfapp" + "/shared_prefs/" + SHARED_MAIN_XML + ".xml");
		if(file.exists()){
			file.delete();
			Toast.makeText(this, "ɾ���ɹ�", Toast.LENGTH_LONG).show();
		}
	}
	
	
}
