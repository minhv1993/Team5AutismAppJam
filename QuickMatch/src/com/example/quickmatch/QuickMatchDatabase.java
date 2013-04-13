package com.example.quickmatch;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class QuickMatchDatabase {

	private static String DATABASE_NAME = "quickMatchDB";
	private final QuickMatchOpenHelper qmDatabaseOpenHelper;
	
	public QuickMatchDatabase(Context context) {
        qmDatabaseOpenHelper = new QuickMatchOpenHelper(context);
    }
	
	
	//Helps run DB commands
	private static class QuickMatchOpenHelper extends SQLiteOpenHelper {

		private static final String TAG = "QuickMatchOpenHelper";
		private static Boolean initializedDB;
	    private static final int DATABASE_VERSION = 2;
	    //Profile Table Build Contents
	    private static final String PROFILE_TABLE_NAME = "quick_match";
		private static String USERNAME;
		private static int CURRENTQUOTA;
		private static String PICNAME;
	    private static final String PROFILE_TABLE_CREATE =
	                "CREATE TABLE " + PROFILE_TABLE_NAME + " (" +
	                USERNAME + " TEXT, " +
	                CURRENTQUOTA + " INT, " + PICNAME + " TEXT);"
	                ;
	    //World Table Build Contents
	    //Level Table Build Contents

	    QuickMatchOpenHelper(Context context) {
	        super(context, DATABASE_NAME , null, DATABASE_VERSION);
	    }

	    @Override
	    public void onCreate(SQLiteDatabase db) {
	    	initializedDB = true;
	        db.execSQL(PROFILE_TABLE_CREATE);
	        
	    }

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
		{
			if (DATABASE_VERSION == oldVersion && oldVersion < newVersion)
			{
				///DATABASE_VERSION = b;
			}
		}
	}
}
