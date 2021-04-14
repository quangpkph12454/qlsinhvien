package com.example.assignmentsactivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SQLiteLop extends SQLiteOpenHelper {
    public SQLiteLop(@Nullable Context context) {
        super(context, "data.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String Lop = "Create table lop(maLop text primary key,tenLop text)";
        db.execSQL(Lop);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void add(Lop lop){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues ad = new ContentValues();
        ad.put("maLop",lop.maLop);
        ad.put("tenLop",lop.tenLop);
        db.insert("lop",null,ad);
    }
    public List<Lop> getAll(){
        List<Lop> Lop = new ArrayList<>();
        String getAll = "SELECT*FROM lop";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(getAll,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            String maLop,tenLop;
            maLop = cursor.getString(0);
            tenLop = cursor.getString(1);
            Lop lop = new Lop(maLop,tenLop);
            Lop.add(lop);
            cursor.moveToNext();
        }
        cursor.close();
        return Lop;
    }
    public void deleteLop(String maLop){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete("lop","maLop =?",new String[]{maLop});

    }
}
