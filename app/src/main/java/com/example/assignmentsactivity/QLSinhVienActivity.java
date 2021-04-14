package com.example.assignmentsactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QLSinhVienActivity extends AppCompatActivity {

    static AppCompatSpinner spLop;
    static List<Lop> Lop;
    static  SQLiteSinhVien sinhvien;
    List<SinhVien> sinhViens;
    static EditText edtID,edtTenSV,edtNgaySinh;
    ListView lvSV;
    Button btnThemSV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_l_sinh_vien);
        spLop = findViewById(R.id.spLop);
        edtID = findViewById(R.id.edtIDSV);
        edtTenSV = findViewById(R.id.edtTenSV);
        edtNgaySinh = findViewById(R.id.edtNgaySinh);
        lvSV =(ListView) findViewById(R.id.lvSV);
        btnThemSV = findViewById(R.id.btnThemSV);
        Lop = DanhSachLopActivity.lop.getAll();
        Lop lop = new Lop();
        lop.tenLop = "_       Show All     _";
        Lop.add(0,lop);
        LopAdapter lopAdapter = new LopAdapter(QLSinhVienActivity.this,Lop);
        spLop.setAdapter(lopAdapter);
        sinhvien = new SQLiteSinhVien(QLSinhVienActivity.this);

        spLop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Lop lop1 = (Lop) spLop.getSelectedItem();
                String lop = lop1.tenLop;
                if(lop.equalsIgnoreCase("_       Show All     _")){
                    sinhViens = sinhvien.getSV();
                    SinhVienAdapter sinhVienAdapter = new SinhVienAdapter(sinhViens);
                    lvSV.setAdapter(sinhVienAdapter);
                }else{
                    sinhViens = sinhvien.checkLop(lop);
                    SinhVienAdapter sinhVienAdapter = new SinhVienAdapter(sinhViens);
                    lvSV.setAdapter(sinhVienAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnThemSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id,ten,Date;
                id = edtID.getText().toString();
                ten = edtTenSV.getText().toString();
                Date = edtNgaySinh.getText().toString();
                Lop lop1 =(Lop) spLop.getSelectedItem();
                if(id.equalsIgnoreCase("") || ten.equalsIgnoreCase("")|| Date.equalsIgnoreCase("")|| lop1.tenLop.equalsIgnoreCase("_       Show All     _")){
                    Toast toast = Toast.makeText(QLSinhVienActivity.this,"Thêm Thất bại",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    SinhVien sv = new SinhVien(id,ten,Date,lop1.tenLop);
                    sinhvien.addSV(sv);
                    sinhViens = sinhvien.getSV();
                    SinhVienAdapter sinhVienAdapter = new SinhVienAdapter(sinhViens);
                    lvSV.setAdapter(sinhVienAdapter);
                }

            }
        });

    }
}
