package com.example.assignmentsactivity;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.List;

public class LopAdapter implements SpinnerAdapter {
    List<Lop> Lop;
    Context context;

    public LopAdapter(Context context,List<Lop> lop) {
        this.Lop = lop;
        this.context = context;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.drop_row,parent,false);
        TextView tvLop = convertView.findViewById(R.id.tvLop);
        tvLop.setText(Lop.get(position).tenLop);
        return convertView;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       convertView = LayoutInflater.from(context).inflate(R.layout.drop_row,parent,false);
        TextView tvLop = convertView.findViewById(R.id.tvLop);
        tvLop.setText(Lop.get(position).tenLop);
        return convertView;
    }
    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public int getCount() {
        return Lop.size();
    }

    @Override
    public Object getItem(int position) {
        return Lop.get(position);
    }





    @Override
    public int getItemViewType(int position) {
        return 0;
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }




    @Override
    public boolean isEmpty() {
        return false;
    }
    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }
}
