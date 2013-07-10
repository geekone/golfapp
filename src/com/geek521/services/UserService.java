package com.geek521.services;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.geek521.models.User;
import com.geek521.utils.DatabaseHelper;

public class UserService {
	private DatabaseHelper dbHelper;
	public UserService(Context context){
		dbHelper = new DatabaseHelper(context);
	}
	
	public boolean register(User user){
		SQLiteDatabase sdb = dbHelper.getReadableDatabase();
		String sql = "INSERT INTO users(username,password) VALUES (?,?)";
		Object obj[] = {user.getUsername(),user.getPassword()};
		sdb.execSQL(sql,obj);
		return true;
		
	}

}
