package com.example.quickmatch;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class QuickMatchDatabase {
	private static final String TAG = "QuickMatchOpenHelper";
	private static String DATABASE_NAME = "quickMatchDB";
	private final QuickMatchOpenHelper qmDatabaseOpenHelper;
    private static final int DATABASE_VERSION = 2;
    
	public QuickMatchDatabase(Context context) {
        qmDatabaseOpenHelper = new QuickMatchOpenHelper(context);
    }
	
	
	//Helps run DB commands
	private static class QuickMatchOpenHelper extends SQLiteOpenHelper {

        private final Context mHelperContext;
        private SQLiteDatabase mDatabase;
        
	    //Profile Table Columns & Build
	    private static final String PROFILE_TABLE_NAME = "quick_match";
	    private static String PROFILEID = "profile_id";
		private static String USERNAME = "username";
		private static String CURRENTQUOTA = "current_quota";
		private static String PICNAME = "pic_name";
	    private static final String PROFILE_TABLE_CREATE =
	                "CREATE TABLE " + PROFILE_TABLE_NAME + " (" + PROFILEID + " INTEGER, " +
	                USERNAME + " TEXT, " +
	                CURRENTQUOTA + " INT, " + PICNAME + " TEXT, PRIMARY KEY (" + PROFILEID + "ASC));"
	                ;
	    //World Table Columns & Build
	    public static final String WORLD_TABLE_NAME = "world";
	    private static String WORLDID = "world_id";
	    private static String WORLDNAME = "world_name";
	    private static String WORLDQUOTA = "current_world_quota";
	    private static String WORLDUNLOCKED = "unlocked";
	    private static final String WORLD_TABLE_CREATE =
                "CREATE TABLE " + WORLD_TABLE_NAME + " (" +
                WORLDID + " INTEGER, " + WORLDQUOTA + " INT, " +
                WORLDNAME + " TEXT, " + WORLDUNLOCKED + " TEXT, PRIMARY KEY(" + WORLDID + " ASC));"
                ;
	    //Level Table Columns & Build
	    public static final String LEVEL_TABLE_NAME = "level";
	    private static String LEVELID = "level_id";
	    private static String LEVELNAME = "level_name";
	    private static String LEVELQUOTA = "current_level_quota";
	    private static String LVLUNLOCKED = "unlocked";
	    private static final String LEVEL_TABLE_CREATE =
                "CREATE TABLE " + LEVEL_TABLE_NAME + " (" + WORLDID + " INTEGER, " +
                LEVELID + " INT, " + LEVELQUOTA + " INT, " +
                LEVELNAME + " TEXT, " + LVLUNLOCKED + " TEXT, FOREIGN KEY(" + WORLDID + ") REFERENCES +" +
                		WORLD_TABLE_NAME + "(" + WORLDID + "));"
                ;
	    
	    QuickMatchOpenHelper(Context context) {
	        super(context, DATABASE_NAME , null, DATABASE_VERSION);
	        mHelperContext = context;
	    }

	    @Override
	    public void onCreate(SQLiteDatabase db) {
	    	mDatabase = db;
	        db.execSQL(PROFILE_TABLE_CREATE);
	        db.execSQL(WORLD_TABLE_CREATE);
	        db.execSQL(LEVEL_TABLE_CREATE);
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
