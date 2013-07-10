package com.geek521.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.geek521.models.User;
import com.geek521.utils.DatabaseHelper;

public class UserService {
	private DatabaseHelper dbHelper;
	public UserService(Context context){
		dbHelper = new DatabaseHelper(context);
	}
	
	public void insert(User user){
		SQLiteDatabase sdb = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("username",user.getUsername());
		values.put("password", user.getPassword());
		sdb.insert("users",null, values);
		sdb.close();
	}
	
	public void find(int id){
		User user = null;
		SQLiteDatabase sdb = dbHelper.getReadableDatabase();
		Cursor cursor = sdb.query("users", new String[]{"id","username","password"}, "id=?", new String[]{String.valueOf(id)}, null,null,null);
		if(cursor.moveToFirst()){
			user = new User();
			user.setId(cursor.getInt(0));
			user.setUsername(cursor.getString(1));
			user.setPassword(cursor.getString(2));
		}
		cursor.close();
		sdb.close();
		
		System.out.println(user.getId() + "  " + user.getUsername() + "  " + user.getPassword());
	}
	
	public void delete(int id){
		SQLiteDatabase sdb = dbHelper.getWritableDatabase();
		sdb.delete("users", "id=?", new String[]{String.valueOf(id)});
		sdb.close();
	}
	
	//¸üÐÂ
	public void update(User user,int id){
		SQLiteDatabase sdb = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("username", user.getUsername());
		values.put("password", user.getPassword());
		sdb.update("users", values, "id=?", new String[]{String.valueOf(id)});
		sdb.close();
	}
	
	
	
	public void selectAll(){
		SQLiteDatabase sdb = dbHelper.getReadableDatabase();
		Cursor cursor = sdb.query("users", new String[]{"id","username","password"}, null, null, null, null, null);
		while(cursor.moveToNext()){
			System.out.println(cursor.getInt(0) + " " + cursor.getString(1) + "  " + cursor.getString(2));
		}
		cursor.close();
		sdb.close();
	}
	
	
	public boolean register(User user){
		SQLiteDatabase sdb = dbHelper.getReadableDatabase();
		String sql = "INSERT INTO users(username,password) VALUES (?,?)";
		Object obj[] = {user.getUsername(),user.getPassword()};
		sdb.execSQL(sql,obj);
		return true;
		
	}

}
