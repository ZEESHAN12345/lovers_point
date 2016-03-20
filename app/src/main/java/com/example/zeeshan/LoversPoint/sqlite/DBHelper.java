package com.example.zeeshan.LoversPoint.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by AZforever on 12-02-2016.
 */
public class DBHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "LoversPointDatabase.db";
    public static final String USERS_TABLE_NAME = "user_detail";
    public static final String USERS_COLUMN_ID = "id";
    public static final String USERS_COLUMN_NAME = "name";
    public static final String USERS_COLUMN_EMAIL = "email";
    public static final String USERS_COLUMN_PASSWORD = "password";

    HashMap map;

    public DBHelper(Context context) {
        super(context,DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("create table user_detail" + "id text, name text, email text, password text");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user_detail");
    }

    public void insertUser_Detail(String name, String email, String password) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", 1);
        cv.put("name", name);
        cv.put("email", email);
        cv.put("password", password);
        db.insert(USERS_TABLE_NAME, null, cv);

    }

    public Cursor get_UserDetail(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor user_info = db.rawQuery("select * from user_details where id = " + id + "", null);
        return user_info;
    }

    public int numberOfRows () {
        SQLiteDatabase db = this.getReadableDatabase();
        int numberOfRows = (int) DatabaseUtils.queryNumEntries(db, USERS_TABLE_NAME);
        return numberOfRows;
    }

    public void updateUser_Detail(Integer id, String name, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("email", email);
        cv.put("password", password);
        db.update(USERS_TABLE_NAME, cv, "id = ?", new String[] {Integer.toString(id)} );
    }

    public void deleteUser_Detail(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete( USERS_TABLE_NAME, "id = ?", new String[] {Integer.toString(id)} );
    }

    public ArrayList<String> getAll_User_Info() {
        ArrayList<String> array_list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user_detail", null);
        cursor.moveToFirst();
        while( !cursor.isAfterLast() ) {
            array_list.add(cursor.getString(cursor.getColumnIndex(USERS_COLUMN_NAME)));
            cursor.moveToNext();
        }
        cursor.close();

        return array_list;
    }

}