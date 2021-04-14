package com.example.assignmentsactivity;

import android.app.Dialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.List;

public class LopArrayAdapter extends BaseAdapter {

    List<Lop> Lop;

    public LopArrayAdapter(List<Lop> lop){
        this.Lop = lop;
    }
    @Override
    public int getCount() {
        return Lop.size();
    }
    @Override
    public View getView(int index, View view, final ViewGroup viewGroup) {

        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.viewlop,viewGroup,false);
        TextView tvSTT = view.findViewById(R.id.tvSTT);
        TextView tvMaLop = view.findViewById(R.id.tvMaLop);
        TextView tvTenLop = view.findViewById(R.id.tvTenLop);

        Lop lop = Lop.get(index);
        tvSTT.setText(String.valueOf(index+1));
        tvMaLop.setText(lop.maLop);
        tvTenLop.setText(lop.tenLop);

        view.setTag(index);
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Integer i = (Integer) v.getTag();
                DanhSachLopActivity.lop.deleteLop(Lop.get(i).maLop);
                Lop = DanhSachLopActivity.lop.getAll();
                Toast.makeText(viewGroup.getContext(),"Xóa Thành Công",Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
                return false;
            }
        });


        return view;
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
