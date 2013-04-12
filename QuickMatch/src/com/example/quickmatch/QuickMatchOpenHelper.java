package com.example.quickmatch;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class QuickMatchOpenHelper extends SQLiteOpenHelper {

	private static final String TAG = "QuickMatchOpenHelper";
    private static final int DATABASE_VERSION = 2;
    private static final String QUICKMATCH_TABLE_NAME = "quick_match";
    private static final String QUICKMATCH_TABLE_CREATE =
                "CREATE TABLE " + QUICKMATCH_TABLE_NAME + " (" //+
                //KEY_WORD + " TEXT, " +
               // KEY_DEFINITION + " TEXT);"
                ;
	private static String DATABASE_NAME = "quickMatchDB.db";

    QuickMatchOpenHelper(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(QUICKMATCH_TABLE_CREATE);
    }

	@Override
	public void onUpgrade(SQLiteDatabase db, int a, int b)
	{
		if (DATABASE_VERSION == a && b > a)
		{
			///DATABASE_VERSION = b;
		}
	}
}