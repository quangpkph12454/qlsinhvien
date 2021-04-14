package com.example.assignmentsactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class DanhSachLopActivity extends AppCompatActivity {

    ListView lvDanhSachLop;
    List<Lop> Lop;
    static SQLiteLop lop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_lop);
        lvDanhSachLop = findViewById(R.id.lvDanhSachLop);
        lop = new SQLiteLop(this);
        Lop = lop.getAll();
        LopArrayAdapter lopArrayAdapter = new LopArrayAdapter(Lop);
        lvDanhSachLop.setAdapter(lopArrayAdapter);

//        lvDanhSachLop.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(DanhSachLopActivity.this);
//                builder.setMessage("Bạn có muốn xóa bản ghi không?");
//                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                return false;
//            }
//        });
    }
}
