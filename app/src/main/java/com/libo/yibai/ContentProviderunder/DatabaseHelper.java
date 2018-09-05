package com.libo.yibai.ContentProviderunder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @Author LiBo on 2018/9/5.
 * @Email libo205@qq.com
 * @Describe :
 */

public   class DatabaseHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "College";

    static final int DATABASE_VERSION = 1;



    DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(StudentsProvider.CREATE_DB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +  StudentsProvider.STUDENTS_TABLE_NAME);
        onCreate(db);
    }
}