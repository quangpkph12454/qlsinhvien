package com.example.assignmentsactivity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    List<SinhVien> sinhvien;

    public SinhVienAdapter(List<SinhVien> sinhvien) {
        this.sinhvien = sinhvien;
    }

    @Override
    public View getView(final int position, View view, final ViewGroup parent) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewsinhvien,parent,false);
        final TextView tvSTT1 = view.findViewById(R.id.tvSTT1);
        final TextView tvID = view.findViewById(R.id.tvID);
        final TextView tvTenSV = view.findViewById(R.id.tvTenSV);
        final TextView tvNgaySinh = view.findViewById(R.id.tvNgaySinh);
        final TextView tvLop = view.findViewById(R.id.tvLop);
        SinhVien sv = sinhvien.get(position);
        tvSTT1.setText(String.valueOf(position+1));
        tvID.setText(sv.id);
        tvTenSV.setText(sv.ten);
        tvNgaySinh.setText(sv.Date);
        tvLop.setText(sv.lop);

        Button btnDelete = view.findViewById(R.id.btnDelete);

        btnDelete.setTag(position);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer i = (Integer) v.getTag();
                QLSinhVienActivity.sinhvien.deleteSV(sinhvien.get(i).id);
                sinhvien = QLSinhVienActivity.sinhvien.getSV();
                Toast.makeText(parent.getContext(),"Xoa thanh cong",Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
            }
        });
        view.setTag(position);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer i =(Integer) v.getTag();
                QLSinhVienActivity.edtID.setText(sinhvien.get(i).id);
                QLSinhVienActivity.edtTenSV.setText(sinhvien.get(i).ten);
                QLSinhVienActivity.edtNgaySinh.setText(sinhvien.get(i).Date);
            }
        });
        Button btnEdit = view.findViewById(R.id.btnEdit);
        btnEdit.setTag(position);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer i = (Integer) v.getTag();
                SinhVien sinhvienss = sinhvien.get(i);
                if(QLSinhVienActivity.edtTenSV.getText().length()==0 || QLSinhVienActivity.edtNgaySinh.getText().length()==0|| QLSinhVienActivity.spLop.getSelectedItem().equals("_       Show All     _")){
                    Toast.makeText(parent.getContext(),"Sửa thất bại",Toast.LENGTH_SHORT).show();
                }else {
//                    tvSTT1.setText(String.valueOf(i + 1));
//                    tvID.setText(QLSinhVienActivity.edtID.getText().toString());
                    sinhvienss.id = QLSinhVienActivity.edtID.getText().toString();
                    sinhvienss.ten = QLSinhVienActivity.edtTenSV.getText().toString();
                    sinhvienss.Date = QLSinhVienActivity.edtNgaySinh.getText().toString();
                    Lop lop = (Lop) QLSinhVienActivity.spLop.getSelectedItem();
                    tvID.setText(sinhvienss.id);
                    tvTenSV.setText(sinhvienss.ten);
                    tvNgaySinh.setText(sinhvienss.Date);
                    sinhvienss.lop = lop.tenLop;
                    tvLop.setText(sinhvienss.lop);
                    QLSinhVienActivity.sinhvien.update(sinhvienss);
                    sinhvien = QLSinhVienActivity.sinhvien.getSV();
                    Toast.makeText(parent.getContext(),"Sửa thành công",Toast.LENGTH_SHORT).show();
                    notifyDataSetChanged();
                }
            }
        });

        return view;
    }
    @Override
    public int getCount() {
        return sinhvien.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
