package com.theapperclass.sqlitedatabase;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;



public class DBInterface extends SQLiteOpenHelper{
	
	public DBInterface(Context context) {
		super(context, DBName, null, DBVersion);
		// TODO Auto-generated constructor stub
	}
	
	private static final String DBName = "LogBook";
	private static final String TableName = "Entries";
	private static final int DBVersion = 1;
	
	private static final String key = "key";
	private static final String id = "id";
	private static final String Name = "name";
	private static final String Dept = "dept";
	private static final String Stamp = "stamp";
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String CREATE_LOGBOOK = "CREATE TABLE ENTRIES(key auto_increment " + "integer primary key, id integer, name string, dept string, stamp timestamp);";
		db.execSQL(CREATE_LOGBOOK);
		
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	public void addEntry(Entry entry){  // calls entry class and acquire data
		
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();          //put data inside it
		cv.put(id, entry.getId());
		cv.put(Name, entry.getName());
		cv.put(Dept, entry.getDept());
		cv.put(Stamp, entry.getStamp().toString());
		db.insert(TableName, null, cv);
		db.close();
	}
	
	public List<Entry> getAllEntries(){  
		
		List<Entry> temp = new ArrayList<Entry>();
		String getAll = "SELECT * FROM ENTRIES";
		
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(getAll, null);       //indicator for data to get
		if(cursor.moveToFirst()){
			do{
				Entry entry = new Entry(Integer.parseInt(cursor.getString(1)), cursor.getString(2), 
						cursor.getString(3), new java.util.Date(cursor.getString(4)));
				temp.add(entry);
			}while(cursor.moveToNext());
		}
		return temp;
	}


}
