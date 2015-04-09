package com.thesis.androidcontroller;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	// --- Database Settings ---//
	private static final int DB_VERSION = 1;
	private static final String DB_NAME = "android_controller";
	
	private static final String USER_ROW_ID = "id";
	private static final String USER_NAME = "username";
	private static final String USER_FULL = "fullname";
	private static final String USER_PASS = "password";
	
	// --- Tables Settings  ---//
		private static final String TBL_USER 		  = "user";
	
	public DatabaseHandler(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		String CREATE_TBL_USER = "CREATE TABLE IF NOT EXISTS " + TBL_USER + "("
			   + USER_ROW_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
			   + USER_NAME	   + " TEXT, "
			   + USER_PASS 	   + " TEXT, "
			   + USER_FULL   + " TEXT);";
		
		
		
		db.execSQL(CREATE_TBL_USER);

		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TBL_USER);

		onCreate(db);
	}
	
	LoginCredentials getCheckAccount(String username, String password) {
		SQLiteDatabase db = this.getReadableDatabase();
			
				Cursor cursor = db.query(TBL_USER, 
						   new String[] {USER_ROW_ID, USER_NAME, USER_PASS, USER_FULL},
						   USER_NAME + "=? AND "  + USER_PASS + "=?", 
						   new String[] {String.valueOf(username),String.valueOf(password)}, 
						   null, null, null);
				
				cursor.moveToFirst();
				LoginCredentials classs = new LoginCredentials(cursor.getInt(0), cursor.getString(1),
							cursor.getString(2), cursor.getString(3));	

		return classs;

	}
	
	public boolean login(String username, String password) throws SQLException {
		SQLiteDatabase db = this.getReadableDatabase();
		
		Cursor cursor = db.rawQuery("SELECT * FROM " + TBL_USER + " WHERE username=? AND password=?", new String[]{username,password});
		if (cursor != null) {
			if(cursor.getCount() > 0){
				return true;
			}
		}
		return false;
	}
	
	void addUser(LoginCredentials c) {
		
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		
		values.put(USER_NAME, c.getUsername());
		values.put(USER_PASS, c.getPassword());
		values.put(USER_FULL, c.getFullname());
		
		db.insert(TBL_USER, null, values);
		db.close();
		
	}
}
