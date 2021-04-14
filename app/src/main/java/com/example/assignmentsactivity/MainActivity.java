package com.example.assignmentsactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void ThemLop(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        View dialog = LayoutInflater.from(this).inflate(R.layout.my_dialog,null);
        alertDialog.setView(dialog);

        Button btnClear, btnInsert;
        final EditText edtMaLop;
        final EditText edtTenLop;

        btnClear = dialog.findViewById(R.id.btnClear);
        btnInsert = dialog.findViewById(R.id.btnInsert);
        edtMaLop = dialog.findViewById(R.id.edtMaLop);
        edtTenLop = dialog.findViewById(R.id.edtTenLop);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maLop = edtMaLop.getText().toString();
                String tenLop = edtTenLop.getText().toString();
                if(maLop.equalsIgnoreCase("") || tenLop.equalsIgnoreCase("")){
                    Toast toast = Toast.makeText(MainActivity.this,"Thêm Thất bại",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    Lop lop = new Lop(maLop,tenLop);
                    DanhSachLopActivity.lop.add(lop);
                    Toast toast = Toast.makeText(MainActivity.this,"Thêm Thành công",Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtMaLop.setText("");
                edtTenLop.setText("");
            }
        });
        alertDialog.create();
        alertDialog.show();

    }

    public void XemLop(View view) {
        Intent intent = new Intent(MainActivity.this,DanhSachLopActivity.class);
        startActivity(intent);
    }

    public void QLSinhVien(View view) {
        Intent intent = new Intent(MainActivity.this,QLSinhVienActivity.class);
        startActivity(intent);

    }
}
