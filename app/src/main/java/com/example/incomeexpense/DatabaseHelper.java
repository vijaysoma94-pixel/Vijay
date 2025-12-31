package com.example.incomeexpense;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.ContentValues;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "finance.db";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE records(id INTEGER PRIMARY KEY, type TEXT, amount INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public void addRecord(String type, int amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("type", type);
        cv.put("amount", amount);
        db.insert("records", null, cv);
    }

    public int getTotalIncome() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT SUM(amount) FROM records WHERE type='income'", null);
        if (c.moveToFirst()) return c.getInt(0);
        return 0;
    }

    public int getTotalExpense() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT SUM(amount) FROM records WHERE type='expense'", null);
        if (c.moveToFirst()) return c.getInt(0);
        return 0;
    }
}
