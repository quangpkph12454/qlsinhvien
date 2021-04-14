package com.example.assignmentsactivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SQLiteSinhVien extends SQLiteOpenHelper {
    public SQLiteSinhVien(@Nullable Context context) {
        super(context, "py.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SinhVien = "Create Table sinhvien(id text primary key,ten text,date text,class text)";
        db.execSQL(SinhVien);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void addSV(SinhVien sinhvien){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues py = new ContentValues();
        py.put("id",sinhvien.id);
        py.put("ten",sinhvien.ten);
        py.put("date",sinhvien.Date);
        py.put("class",sinhvien.lop);
        db.insert("sinhvien",null,py);
    }
    public List<SinhVien> getSV(){
        List<SinhVien> sv = new ArrayList<>();
        String getAll = "SELECT*FROM sinhvien";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(getAll,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String id,ten,Date,lop;
            id = cursor.getString(0);
            ten = cursor.getString(1);
            Date = cursor.getString(2);
            lop =cursor.getString(3);
            SinhVien sinhVien = new SinhVien(id,ten,Date,lop);
            sv.add(sinhVien);
            cursor.moveToNext();
        }
        cursor.close();
        return sv;
    }
    public void deleteSV(String id){
        SQLiteDatabase sql = getReadableDatabase();
        sql.delete("sinhvien","id =?",new String[]{id});
    }
    public void update(SinhVien sv){

        SQLiteDatabase sql = getReadableDatabase();
        ContentValues py = new ContentValues();
        py.put("ten",sv.ten);
        py.put("date",sv.Date);
        py.put("class",sv.lop);
        sql.update("sinhvien",py,"id=?",new String[]{sv.id});
    }
    public List<SinhVien> checkLop(String lop){
        List<SinhVien> sv1 = new ArrayList<>();
        String getAll = "SELECT*FROM sinhvien where class = '"+ lop+"'" ;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(getAll,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String id,ten,Date,lop1;
            id = cursor.getString(0);
            ten = cursor.getString(1);
            Date = cursor.getString(2);
            lop1 =cursor.getString(3);
            SinhVien sinhVien = new SinhVien(id,ten,Date,lop1);
            sv1.add(sinhVien);
            cursor.moveToNext();
        }
        cursor.close();
        return sv1;

    }
}
