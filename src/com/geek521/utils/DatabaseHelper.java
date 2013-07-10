package com.geek521.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	static String name = "golf.db";
	static int dbVersion = 1;
	
	public DatabaseHelper(Context context) {
		super(context, name, null, dbVersion);
	}

	
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table users(id integer primary key autoincrement,username varchar(20),password varchar(20))";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

	
}
