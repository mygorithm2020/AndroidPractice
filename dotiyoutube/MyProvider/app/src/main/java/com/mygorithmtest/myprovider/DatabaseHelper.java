package com.mygorithmtest.myprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "person.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABEL_NAME = "person";
    // 칼럼명
    public static final String PERSON_ID = "_id";
    public static final String PERSON_NAME = "name";
    public static final String PERSON_AGE = "age";
    public static final String PERSON_MOBILE = "mobile";

    public static final String[] ALL_COLUMNS = {PERSON_ID, PERSON_NAME, PERSON_AGE, PERSON_MOBILE};

    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABEL_NAME + "(" +
                    PERSON_ID + " integer primary key autoincrement, " +
                    PERSON_NAME + " text, " +
                    PERSON_AGE + " integer, "+
                    PERSON_MOBILE + " text" +
                    ")";
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // 기존 데이터베이스가 없는 경우
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // 테스트라 날리고 다시만드는데 실제로는 보존해야함
        sqLiteDatabase.execSQL("drop table if exists " + TABEL_NAME);
        onCreate(sqLiteDatabase);

    }
}
